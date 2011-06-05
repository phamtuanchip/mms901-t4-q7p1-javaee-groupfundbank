<%-- 
    Document   : Login
    Created on : May 15, 2011, 6:09:14 AM
    Author     : binhnx218
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="<%=application.getContextPath() + "/Script/jquery-1.6.js"%>" ></script>
        <script type="text/javascript" src="<%=application.getContextPath() + "/Script/jquery-plugin.js"%>" ></script>
        <script type="text/javascript" src="<%=application.getContextPath() + "/Script/validator.js"%>" ></script>
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() + "/Style/Site.css"%>" >
    </head>
    <body>
        <form action='<%=application.getInitParameter("ServerSecurePath") + "/Account/LoginAuth"%>' method='post' onsubmit="return validate()">
            <input type="hidden" id='hiddenUrl' name='returnUrl' value='<%=request.getParameter("returnUrl")%>' />
            <input type='text' id='username' class='login require-validation' name='username' value='Username' />
            <label style="display:none" class='err require-validation-err'>Username must not empty</label>
            <input type='password' id='password' class='login require-validation' name='password' value='Password' />
            <label style="display:none" class='err require-validation-err'>Password must not empty</label>
            <input type='submit' value='Submit' />
        </form>
                    <label><%=
                    request.getContextPath() +
                    request.getServerName() +
            application.getContextPath() + "\n" +
            application.getInitParameter("ServerPath") +
            getInitParameter("ServerPath")%></label>
            <%

            %>
            <%=session.isNew() + session.getId()
            %>
        <script type="text/javascript" >
		$( function() {
                    $(document).data("ready", false);
                        $("#username").focus();
                    $(document).data("ready", true);
                });
                $("input").toggleValue();

	</script>
    </body>
</html>
