<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
<%-- ---- LINK TO NAVBAR ---- --%>
<%@ include file="/WEB-INF/partials/navbar.jsp" %>

<article class="content-body">
    <h1>Home Page</h1>

    <p>Hey all you cool cats and kittens.</p>
</article>
</body>
</html>
