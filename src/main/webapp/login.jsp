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
    <title>Login</title>
</head>
<body>

<%-- ---- LINK TO INDEX ---- --%>
<%@ include file="/partials/navbar.jsp" %>

<article class="login-all">


    <section class="login-card">

        <section class="hello-world-section">
            <h1>Account Login</h1>
            <p>
                I'm baby forage gentrify selvage, 90's crucifix bushwick man bun. Kale chips readymade lomo, food truck
                blue
                bottle aesthetic everyday carry.
                Tote bag gochujang photo booth asymmetrical tofu raclette, live-edge offal farm-to-table iceland.
            </p>

            <%-- ---- SOCIAL BUTTONS ---- --%>
            <div id="social-btns">
                <input type="submit" value="Facebook" id="facebook-btn">
                <input type="submit" value="Google" id="google-btn">
            </div>

        </section>

        <section class="login-section">

            <%-- ---- FORM ---- --%>
            <form action="${pageContext.request.contextPath}/login.jsp" method="post" class="login-form">

                <%-- ---- USERNAME ---- --%>
                <div class="username">
                    <label for="username"></label>
                    <input type="text" id="username" name="username" placeholder="Enter your username">
                </div>

                <%-- ---- PASSWORD ---- --%>
                <div class="password">
                    <label for="pass"></label>
                    <input type="password" id="pass" name="password"
                           minlength="8" required placeholder="Password">
                </div>

                <%-- ---- SUBMIT BUTTON ---- --%>
                <input type="submit" value="Sign in" id="submit-btn">
            </form>

        </section>
    </section>
</article>
</body>
</html>
