<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 16/3/2023
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Computer</title>
    <link href="../bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
    <style>
        table,th,td{
            border: black solid 1px;
        }
    </style>
</head>
<body>
<table class="table table-hover table-inverse table-responsive">
    <thead class="thead-inverse">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>PRODUCER</th>
        <th>COUNTRY</th>
        <td>DESCRICE</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${computerList}" var="computer" >
        <tr>
            <td>${computer.idPc}</td>
            <td><a href="/computer?action=detail&id=${computer.idPc}">${computer.name}</a></td>
            <td>${computer.price}</td>
            <td>${computer.producer}</td>
            <td>${computer.country}</td>
            <td>${computer.describe}</td>
            <td>${computer.img}</td>
            <td>${computer.idUser}</td>
            <td><a href="/computer?action=edit&id=${computer.idPc}">edit</a></td>
            <td><a href="/computer?action=delete&id=${computer.idPc}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
    <p><a href="/computer?action=create">create</a></p>
</table>
</body>
</html>
