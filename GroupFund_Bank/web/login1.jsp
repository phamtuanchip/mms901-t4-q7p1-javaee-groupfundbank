<%-- 
    Document   : login
    Created on : May 13, 2011, 3:13:12 AM
    Author     : binhnx218
--%>

<%@page import="sun.management.Agent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>TODO write content</div>
        <form action="LoginServlet" method="post">
            <input type="hidden" id="hiddenUrl" name="returnUrl" value="<%=request.getParameter("returnUrl")%>" on />
            <input type="text" id="username" name="username" value="Username" />
            <input type="password" id="password" name="password" value="Password" />
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
