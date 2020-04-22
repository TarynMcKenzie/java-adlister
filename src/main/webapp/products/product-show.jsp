<%--
  Created by IntelliJ IDEA.
  User: taryn.mckenzie
  Date: 4/22/20
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

<%-- ---- LINK TO NAVBAR ---- --%>
<%@ include file="../partials/navbar.jsp" %>

<%-- ---- PRODUCT INFO ---- --%>
<div class="container">
    <%-- ---- PRODUCT TITLE ---- --%>
    <h1>Current Product: ${product.title}</h1>
    <%-- ---- PRODUCT PRICE ---- --%>
    <p>Price: $${product.price}</p>
    <%-- ---- PRODUCT DESCRIPTION ---- --%>
    <p>Description: ${product.description}</p>
</div>

</body>
</html>
