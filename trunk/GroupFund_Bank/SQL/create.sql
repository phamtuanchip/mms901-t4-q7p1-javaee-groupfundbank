
CREATE TABLE "GROUPS"
(
"GROUPID" SMALLINT NOT NULL PRIMARY KEY,
"GROUPNAME" VARCHAR(20) NOT NULL,
"GROUPDESCRIPTION" VARCHAR(100)
);

CREATE TABLE "USERS"
(
"USERID" CHAR(16) NOT NULL PRIMARY KEY,
"USERNAME" VARCHAR(50) UNIQUE,
"PASSWORD" CHAR(64) NOT NULL,
"BIRTHDAY" DATE NOT NULL,
"GROUPID" SMALLINT NOT NULL DEFAULT 1,
FOREIGN KEY (GROUPID) REFERENCES GROUPS (GROUPID)
);
CREATE INDEX IX_USER_PASSWORD
ON USERS
(
PASSWORD
);


CREATE TABLE "BANKINGOFFICER"
(
"BANKINGOFFICERCODE" CHAR(10) NOT NULL PRIMARY KEY,
"BANKINGOFFICERFNAME" VARCHAR(20) NOT NULL,
"BANKINGOFFICERLNAME" VARCHAR(20) NOT NULL,
"BANKINGOFFICERBIRTHDAY" DATE NOT NULL,
"BANKINGOFFICERADDRESS" VARCHAR(100) NOT NULL,
"BANKINGOFFICERPHONE" VARCHAR(15),
"BANKINGOFFICERMAIL" VARCHAR(100)
);
CREATE INDEX IX_BANKINGOFFICER_FNAME
ON BANKINGOFFICER
(
BANKINGOFFICERFNAME
);
CREATE INDEX IX_BANKINGOFFICER_LNAME
ON BANKINGOFFICER
(
BANKINGOFFICERLNAME
);

CREATE TABLE "BRANCH"
(
"BRANCHCODE" INT NOT NULL PRIMARY KEY,//
"BRANCHNAME" VARCHAR(50) NOT NULL UNIQUE,
"BRANCHLOCATION" VARCHAR(100) NOT NULL UNIQUE,     
"BRANCHPHONE" VARCHAR(15)
);
CREATE INDEX IX_BRANCH_NAME
ON BRANCH
(
BRANCHNAME ASC
);

CREATE TABLE "PRODUCT"
(
"PRODUCTCODE" CHAR(5) NOT NULL PRIMARY KEY,
"PRODUCTNAME" VARCHAR(20) NOT NULL UNIQUE,
"PRODUCTDESCRIPTION" VARCHAR(500) NOT NULL
);
CREATE INDEX IX_PRODUCT_NAME
ON PRODUCT
(
PRODUCTNAME
);

CREATE TABLE "SERVICEDESK"
(
"SERVICEDESKCODE" INT NOT NULL PRIMARY KEY
        GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
"BRANCHCODE" CHAR(6) NOT NULL,
"PRODUCTCODE" CHAR(5) NOT NULL,
"BANKINGOFFICERCODE" CHAR(10),
"ISACTIVE" SMALLINT NOT NULL DEFAULT 1,
FOREIGN KEY (BRANCHCODE) REFERENCES "BRANCH" (BRANCHCODE),
FOREIGN KEY (PRODUCTCODE) REFERENCES "PRODUCT" (PRODUCTCODE),
FOREIGN KEY (BANKINGOFFICERCODE) REFERENCES "BANKINGOFFICER" (BANKINGOFFICERCODE)
);

CREATE TABLE "TICKET"
(
"TICKETNUMBER" CHAR(20) NOT NULL PRIMARY KEY,
"TICKETDATE" DATE NOT NULL DEFAULT current_date,
"SERVICEDESKCODE" INT NOT NULL,
"USERID" CHAR(16) NOT NULL,
"TICKETPRIORITY" SMALLINT NOT NULL DEFAULT 1,
"ISPROCESSED" SMALLINT NOT NULL DEFAULT 0,
FOREIGN KEY (SERVICEDESKCODE) REFERENCES SERVICEDESK (SERVICEDESKCODE),
FOREIGN KEY (USERID) REFERENCES USERS (USERID)
);
CREATE INDEX IX_TICKET_NUMBER
ON TICKET
(
TICKETNUMBER
);
