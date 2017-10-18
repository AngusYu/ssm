<%--
  Created by IntelliJ IDEA.
  User: AngusYu
  Date: 2017/10/17
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>list Page</title>
    <script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<table class="table table-striped table-bordered">
    <thead>
    <tr>
        <th colspan="4" style="text-align:center;">Book Inventory</th>
    </tr>
    <tr>
        <th>Book Id</th>
        <th>Book Name</th>
        <th>Book Amount</th>
        <th>Operation</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${!empty books}">
    <c:forEach items="${books}" var="book" varStatus="st">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.amount}</td>
            <td><a href="/book/${book.id}/detail"><button class="btn btn-info">Detail</button></a></td>
        </tr>
    </c:forEach>
    </c:if>
    </tbody>
</table>
<br>
</body>
</html>
