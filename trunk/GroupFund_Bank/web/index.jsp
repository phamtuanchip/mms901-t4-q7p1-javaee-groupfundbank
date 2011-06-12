<%-- 
    Document   : index
    Created on : May 12, 2011, 5:48:07 PM
    Author     : binhnx218
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/GroupFund_Bank/Style/Site.css" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="banner.jsp" %>
        <%
        HttpSession ss = request.getSession();
        ss.setMaxInactiveInterval(60);
        %>
        <div id="main-wrapper">
            <div id="header">
                <a href="/">
                    <img alt="GroupFund Bank" src="/GroupFund_Bank/Image/groupfund-logo.jpg" title="GroupFund Bank - Tiền mất tật mang :))" id="logo" />
                </a>
            </div>
        </div>
        <%@include file="fotter.jsp" %>
    </body>
</html>
