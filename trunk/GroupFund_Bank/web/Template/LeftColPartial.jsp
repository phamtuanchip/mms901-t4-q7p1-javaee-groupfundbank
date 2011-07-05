<%@page language="java" contentType="text/html;charset=UTF-8" %>
<%@page import="Entities.ProductFacadeLocal"%>
<%@page import="Entities.ProductgroupFacadeLocal"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="Entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="Entities.Productgroup"%>
            <%
            InitialContext initContext = new InitialContext();
            ProductgroupFacadeLocal pGroupFacade = (ProductgroupFacadeLocal)initContext.lookup("java:module/ProductgroupFacade");
            ProductFacadeLocal pFacade = (ProductFacadeLocal)initContext.lookup("java:module/ProductFacade");
            List<Productgroup> pGroupList = pGroupFacade.findAll();
            //pGroupList.get(1).getProductgroupname()
            %>    
<div id="maincol-left" class="lcolumn">
                    <div id="login">
                        <form method="GET" action="<%=
            pageContext.getServletContext().getInitParameter("ServerPath").toString() + 
            pageContext.getServletContext().getInitParameter("ContextPath").toString()
            %>Account/Login.jsp">
                            <input type="submit" value="Đăng nhập" />
                        </form>
                    </div>
                    <div id="site-nav" class="vnav">
                    <div class="vnav-header">
                        Các sản phẩm và dịch vụ
                    </div>
                    <ul>
                        <% for (Productgroup pGroup : pGroupList) { %>
                            <li>
                                <a href="<%=
            pageContext.getServletContext().getInitParameter("ServerPath").toString() + 
            pageContext.getServletContext().getInitParameter("ContextPath").toString()
            %>Products/Groups.jsp?gid=<%=pGroup.getProductgroupid()%>">
                                   <%=pGroup.getProductgroupname()%>
                                </a>
                                <ul>
                                <%
                                List<Product> pList = pFacade.getProductList(pGroup.getProductgroupid());
                                for (Product pr : pList) {
                                %>
                                    <li>
                                        <a href="<%=
            pageContext.getServletContext().getInitParameter("ServerPath").toString() + 
            pageContext.getServletContext().getInitParameter("ContextPath").toString()
            %>Products/Details.jsp?pid=<%=pr.getProductid()%>">
                                   <%=pr.getProductname()%>
                                        </a>
                                    </li>
                                <% } %>
                                </ul>
                            </li>
                        <% } %>
                    </ul>
                </div>
                </div>