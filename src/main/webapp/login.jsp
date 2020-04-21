<%--
  Created by IntelliJ IDEA.
  User: taryn.mckenzie
  Date: 4/21/20
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>

<%-- TODO: Build A Login Form--%>
<%--       a. Create two files, login.jsp and profile.jsp--%>
<%--       b. When a user visits /login.jsp, they should see a form for logging in--%>
<%--          This form should have a 'username' and 'password' field.--%>
<%--       c. This form should submit a POST request to /login.jsp--%>
<%--       d. Inside of login.jsp write some code to check the submmitted values. If the username submitted is "admin", and the password is "password", redirect the user to the profile page; otherwise, redirect back to the login form.&ndash;%&gt;--%>
<%-- We will give our site's login page much more robust functionality in future lessons.--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%-- ---- LOGIN FORM CHECK ---- --%>
<%

    if (request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ((username.equals("admin") && password.equals("password"))) {

            session.setAttribute("username", username);
            response.sendRedirect("profile.jsp");

        } else
            response.sendRedirect("login.jsp");
    }
%>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <%-- ---- LINK TO INDEX ---- --%>
        <%@ include file="index.jsp" %>

        <%-- ---- HEADING ---- --%>
        <h1>Account Login</h1>


        <%-- ---- FORM ---- --%>
        <form action="${pageContext.request.contextPath}/login.jsp" method="post">

            <%-- ---- USERNAME ---- --%>
            <div>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username">
            </div>

            <%-- ---- PASSWORD ---- --%>
            <div>
                <label for="pass">Password (8 characters minimum):</label>
                <input type="password" id="pass" name="password"
                       minlength="8" required>
            </div>

            <%-- ---- SUBMIT BUTTON ---- --%>
            <input type="submit" value="Sign in">
        </form>

    </body>
</html>
