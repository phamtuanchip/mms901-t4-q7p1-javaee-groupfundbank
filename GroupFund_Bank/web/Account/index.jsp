<%-- 
    Document   : index
    Created on : May 15, 2011, 3:22:38 PM
    Author     : binhnx218
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        if (session.isNew())
            {
        %>
        <p>What do you want to do?</p>

        <a href="queue">Show queue</a>
        <br />
        <a href="info"></a>
        <br />
        <br /> or <br />
        <%
            }
        %>
        <a href="Request">
            <h2>Get a queue ticket</h2>
        </a>
    </body>
</html>
