<%-- 
    Document   : index
    Created on : May 15, 2011, 3:22:38 PM
    Author     : binhnx218
--%>

<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="Entities.BranchFacadeLocal"%>
<%@page import="Entities.Branch"%>
<%@page import="java.util.Date"%>
<%@page import="Entities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        //if (session.getAttribute("User"))
            //{
                
            //}
        Users u = new Users();
        u.setUserid("ABCDEFG");
        u.setUsername("BinhNX");
        u.setBirthday(new Date());
        session.setAttribute("user", u);
        Object o = session.getAttribute("user");
        %>
        <%=
        o.toString()
        %>
                <%//TODO: Đăng nhập%>
        <h4>Chào mừng đến với hệ thống Ngân hàng điện tử của GroupFund Bank!</h4>
        <p>
            Hiện nay hệ thống đang được xây dựng, nên bạn chỉ có thể tự đi đến 
            1 chi nhánh nào đó của chúng tôi mà giao dịch <br />
            (Shit project, how a website is fitted with this use-case????)
        </p>
        <h1>Chọn một trong các chi nhánh sau đây (hoa mắt quá)</h1>
        <form method="POST" action="NewTicket.do">
        <%
        BranchFacadeLocal branchFacade = 
                (BranchFacadeLocal)new InitialContext().lookup("java:module/BranchFacade");
        List<Branch> branchList = branchFacade.findAll();
        %>
        <select onchange="this.form.submit()">
        <%
        for (Branch b : branchList) {                     
        %>
        <option value="<%=b.getBranchid()%>">
                <%=b.getBranchname()%> - <%=b.getBranchlocation()%>
            </option>
        <% } %>
        </select>
            <input type="submit" value="Lấy Tích-kê" />
        </form>
    </body>
</html>
