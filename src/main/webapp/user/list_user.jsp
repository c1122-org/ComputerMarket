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
    <title>List User</title>
    <link href="../bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
    <meta charset="utf-8"/>
</head>
<body class="container-lg p-4">
<h3 class="text-center text-uppercase mb-4">User List</h3>
<form style="margin-bottom: 10px" class="d-flex w-100" role="search" method="post" action="/user?action=search">
    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="name">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>
<button class="btn btn-outline-danger"><a style="text-decoration: none" href="/user?action=sort">Sort by name</a></button>
<button class="btn btn-outline-danger"><a style="text-decoration: none" href="/user">User list</a></button>
<button class="btn btn-outline-danger"><a style="text-decoration: none" href="/computer">Home page</a></button>

<table class="mt-4 table table-hover table-inverse table-responsive table-bordered border-primary">
    <thead class="thead-inverse">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>PASSWORD</th>
        <th>PHONE NUMBER</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td scope="row">${user.idUser}</td>
            <td><a style="text-decoration: none" href="/user?action=view&idUser=${user.idUser}">${user.name}</a></td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.phoneNumber}</td>
            <td><a href="/user?action=update&idUser=${user.idUser}">Edit</a></td>
            <td><a href="/user?action=delete&idUser=${user.idUser}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${message != null}">
    <p  class="table-borderless display-3 text-danger">${message}</p>
</c:if>
</body>
</html>
