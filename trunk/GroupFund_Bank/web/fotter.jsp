<%-- 
    Document   : fotter
    Created on : Jun 11, 2011, 7:17:11 PM
    Author     : BinhNX
--%>

<%@page import="Session.SessionListener"%>
<h1>User visited: <%=SessionListener.getTotalSession()%></h1>