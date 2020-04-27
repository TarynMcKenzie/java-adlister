<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <article class="content-body">
        <section class="user-profile">
            <%-- ---- PROFILE ---- --%>
            <img src="img/linnea-sandbakk-yLaZQBDa6WM-unsplash.jpg" alt="User image placeholder" id="user-img">
            <h2>Welcome back ${sessionScope.user}!</h2>
            <h4>Bio</h4>
            <p>
                I'm baby vinyl VHS knausgaard, heirloom neutra vice flannel ugh. Viral drinking vinegar salvia, thundercats
                everyday carry scenester meh fashion axe sriracha.
                Keytar tote bag XOXO twee occupy, etsy glossier humblebrag. Tofu portland helvetica venmo flannel deep v
                blog, cred cray gochujang.
            </p>
        </section>
    </article>

</body>
</html>
