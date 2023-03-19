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
    <c:forEach items="${computerList}" var="computer">
        <tr>
            <td scope="row">${computer.id}</td>
            <td><a href="/computer?action=detail&id=${computer.id}">${computer.name}</a></td>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>List Computer</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead>
    <tr style="font-weight: bold">
        <th>STT</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Nhà sản xuất</th>
        <th>Quốc gia</th>
        <th>Thông tin chi tiết</th>
        <th>Ảnh</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="computer" items="${computerList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${computer.name}</td>
            <td>${computer.price}</td>
            <td>${computer.producer}</td>
            <td>${computer.country}</td>
            <td>${computer.describe}</td>

            <td><a href="/computer?action=edit&id=${computer.id}">edit</a></td>
            <td><a href="/computer?action=delete&id=${computer.id}">delete</a></td>
            <td><img style="width: 100px" src="${computer.img}"></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>
