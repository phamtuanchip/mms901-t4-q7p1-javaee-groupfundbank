<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
  <head>
    <link rel="shortcut icon" href="/Images/favicon.ico" type="image/x-icon" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title><sitemesh:write property='title'/></title>
    <link rel="stylesheet" href="<%=
            pageContext.getServletContext().getInitParameter("ServerPath").toString() + 
            pageContext.getServletContext().getInitParameter("ContextPath").toString()
            %>Style/Site.css" type="text/css" />
    <sitemesh:write property='head'/>
  </head>
  <body>
    <div id="main-wrapper" class="wrapper">
        <div id="main">
            <%
            //<h1 class='title'><sitemesh:write property='title'/></h1>
            %>
            <div id="title">
                <a href="<%=
            pageContext.getServletContext().getInitParameter("ServerPath").toString() + 
            pageContext.getServletContext().getInitParameter("ContextPath").toString()
            %>">
                    <img alt="GroupFund Bank" src="<%=
            pageContext.getServletContext().getInitParameter("ServerPath").toString() + 
            pageContext.getServletContext().getInitParameter("ContextPath").toString()
            %>Images/groupfund-logo.jpg" title="GroupFund Bank" id="logo" 
                         height="50"/>
                </a>
                <div id="global-nav" class="hnav">
                    <ul>
                        <li>
                            <a href="<%=
            pageContext.getServletContext().getInitParameter("ServerPath").toString() + 
            pageContext.getServletContext().getInitParameter("ContextPath").toString()
            %>">Trang chủ</a>
                        </li>
                        <li>
                            <a href="<%=
            pageContext.getServletContext().getInitParameter("ServerPath").toString() + 
            pageContext.getServletContext().getInitParameter("ContextPath").toString()
            %>Account">Cá nhân</a>
                        </li>
                        <li>
                            <a href="<%=
            pageContext.getServletContext().getInitParameter("ServerPath").toString() + 
            pageContext.getServletContext().getInitParameter("ContextPath").toString()
            %>Products">Sản phẩm và dịch vụ</a>
                        </li>
                        <li>
                            <a href="<%=
            pageContext.getServletContext().getInitParameter("ServerPath").toString() + 
            pageContext.getServletContext().getInitParameter("ContextPath").toString()
            %>About">Giới thiệu</a>
                        </li>
                    </ul>
                </div>
                <%
                //HttpSession ss = request.getSession();
                //ss.setMaxInactiveInterval(60);
                %>
                <div class="clearfloat"></div>
            </div>

            
 
            <div class='mainBody'>
                <sitemesh:write property='body'/>
            </div>

            
            <div class="clearfloat"></div>
            <div id='disclaimer'>
                Copryright © 2011 GroupFund Bank
            </div>
        </div>
    </div>
  </body>
</html>