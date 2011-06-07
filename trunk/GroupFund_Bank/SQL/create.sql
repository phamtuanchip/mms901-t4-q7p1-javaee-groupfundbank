
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

CREATE TABLE "SESSIONS"
(
"SESSIONID" VARCHAR(40) NOT NULL PRIMARY KEY,
"USERID" CHAR(16),
FOREIGN KEY (USERID) REFERENCES USERS (USERID)
);
CREATE INDEX IX_SESSIONS_ID
ON SESSIONS
(
SESSIONID
);

CREATE TABLE "BRANCH"
(
"BRANCHID" INT NOT NULL PRIMARY KEY
          GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
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
"PRODUCTID" INT NOT NULL PRIMARY KEY
          GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
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
"SERVICEDESKCODE" CHAR(5) NOT NULL PRIMARY KEY,
"BRANCHID" INT NOT NULL,
"PRODUCTID" INT NOT NULL,
"ISACTIVE" SMALLINT NOT NULL DEFAULT 1,
FOREIGN KEY (BRANCHID) REFERENCES "BRANCH" (BRANCHID),
FOREIGN KEY (PRODUCTID) REFERENCES "PRODUCT" (PRODUCTID)
);

CREATE TABLE "BANKINGOFFICER"
(
"BANKINGOFFICERID" INT NOT NULL PRIMARY KEY
        GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
"BANKINGOFFICERFNAME" VARCHAR(20) NOT NULL,
"BANKINGOFFICERLNAME" VARCHAR(20) NOT NULL,
"BANKINGOFFICERADDRESS" VARCHAR(100) NOT NULL,
"BANKINGOFFICERPHONE" VARCHAR(15),
"BANKINGOFFICERMAIL" VARCHAR(100),
"SERVICEDESKCODE" CHAR(5),
"USERID" CHAR(16),
FOREIGN KEY (SERVICEDESKCODE) REFERENCES SERVICEDESK (SERVICEDESKCODE),
FOREIGN KEY (USERID) REFERENCES USERS (USERID)
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

CREATE TABLE "TICKET"
(
"TICKETNUMBER" CHAR(10) NOT NULL PRIMARY KEY,
"TICKETDATE" DATE NOT NULL DEFAULT current_date,
"SERVICEDESKCODE" CHAR(5) NOT NULL,
"ISPROCESSED" SMALLINT NOT NULL DEFAULT 0,
FOREIGN KEY (SERVICEDESKCODE) REFERENCES SERVICEDESK (SERVICEDESKCODE)
);
CREATE INDEX IX_TICKET_NUMBER
ON TICKET
(
TICKETNUMBER
);

CREATE TABLE "QUEUE"
(
"TICKETNUMBER" CHAR(10) NOT NULL,
"TICKETPRIORITY" SMALLINT NOT NULL,
"USERID" CHAR(16) NOT NULL,
FOREIGN KEY (USERID) REFERENCES USERS (USERID)
);
CREATE INDEX IX_QUEUE_USERID
ON QUEUE
(
USERID
);
