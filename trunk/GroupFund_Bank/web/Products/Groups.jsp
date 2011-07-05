<%-- 
    Document   : Products
    Created on : Jul 3, 2011, 4:20:42 PM
    Author     : BinhNX
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GroupFund Bank - Products And Services</title>
    </head>
    <body>
    <%@include file="/Template/LeftColPartial.jsp" %>
    <div id="mainContent-wrap" style="margin-left: 205px">
    <div id="mainContent">
        <%
        int productId = 0;
        try
        {
            productId = Integer.parseInt(request.getParameter("pid"));
        }
        catch (Exception ex)
        {
            productId = Integer.MIN_VALUE;
        }
        %>
        <h1>Hello World!</h1>
        <%
        if (productId == Integer.MIN_VALUE) {
        %>
            List
        <%
        } else {
        %>
            Select
        <%}%>
    </div>
    </div>
    </body>
</html>
