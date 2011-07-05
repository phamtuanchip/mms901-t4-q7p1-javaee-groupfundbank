<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tlds/util.tld" prefix="u" %> 
<html>
  <head>
    <link rel="shortcut icon" href="/Images/favicon.ico" type="image/x-icon" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title><sitemesh:write property='title'/></title>
    <link rel="stylesheet" href="<%=
            request.getContextPath()
            %>/Style/Site.css" type="text/css" />
    <sitemesh:write property='head'/>
  </head>
    <body>
    <div id="main-wrapper" class="wrapper">
        <div id="main">
            <%
            //<h1 class='title'><sitemesh:write property='title'/></h1>
            
            %>
            <div id="title">
                <a href="<%=response.encodeURL(request.getContextPath() + "/")%>">
                    <img alt="GroupFund Bank" src="<%=
            request.getContextPath()
            %>/Images/groupfund-logo.jpg" title="GroupFund Bank" id="logo" 
                         height="50"/>
                </a>
                <div id="global-nav" class="hnav">
                    <ul>
                        <li>
                            <a href="<u:encodeUrl secure="false" url="" />">Trang chủ</a>
                        </li>
                        <li>
                            <a href="<u:encodeUrl secure="false" url="Account" />">Tài khoản</a>
                        </li>
                        <li>
                            <a href="<u:encodeUrl secure="false" url="Products" />">Sản phẩm và dịch vụ</a>
                        </li>
                        <li>
                            <a href="<u:encodeUrl secure="false" url="About" />">Giới thiệu</a>
                        </li>
                    </ul>
                </div>
                <%
                //HttpSession ss = request.getSession();
                //ss.setMaxInactiveInterval(60);
                %>
                <div class="clearfloat"></div>
                
            </div>

            
            <div id="mainContent">
                <sitemesh:write property='body'/>
            </div>
            
            <div class="clearfloat"></div>
            <div id='disclaimer'>
                Copryright © 2011 GroupFund Bank
            </div>
        </div>
    </div>
  </body>