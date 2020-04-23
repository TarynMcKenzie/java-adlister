<%--
  Created by IntelliJ IDEA.
  User: taryn.mckenzie
  Date: 4/23/20
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>

<%-- TODO: 1. Build an index page for all of your ads--%>
<%--        TODO:  a. Create a directory inside webapp named ads--%>
<%--        TODO:  b. Create a file ads/index.jsp. This file will show a listing of all the ads on your site.--%>
<%--        TODO:  c. This page should be available when a user visits /ads.--%>
<%--        TODO:  d. Use the all method on the ListAdsDao class to get a listing of all the ads, and pass this on to your jsp file--%>
<%--        TODO:  e. In your jsp file, loop through all the ads and display each one.--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Welcome to our Ads!"/>
    </jsp:include>
</head>
<body>

    <jsp:include page="../partials/navbar.jsp"/>

    <article class="content-body">
    <%-- Get the attribute "ads" set in the ShowAdsServlet--%>
    <c:forEach var="ad" items="${ads}">
        <div class="ad">
            <%-- Get the name of the ad--%>
            <h2>${ad.title}</h2>
            <%-- Get the description of the ad --%>
            <p>Description: ${ad.description}</p>
        </div>
    </c:forEach>
    </article>

</body>
</html>
