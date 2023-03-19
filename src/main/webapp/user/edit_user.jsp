<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 17/3/2023
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>

</head>
<body class="container-lg p-4">
<h3 class="text-center text-uppercase mb-4">update user</h3>
<a class="btn btn-outline-primary" href="/user">Back to List user</a>
<c:if test="${message != null}">
    <p>${message}</p></c:if>
<form method="post" class="container-md">
    <div class="mb-3">
        <label for="exampleInputName" class="form-label">Name</label>
        <input type="text" class="form-control" id="exampleInputName" name="name" aria-describedby="nameHelp" value="${user.name}">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email</label>
        <input type="text" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" value="${user.email}">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input type="text" class="form-control" id="exampleInputPassword1" name ="password" value="${user.password}">
    </div>
    <div class="mb-3">
        <label for="exampleInputPhoneNumber" class="form-label">Phone Number</label>
        <input type="text" class="form-control" id="exampleInputPhoneNumber" name ="phoneNumber" value="${user.phoneNumber}">
    </div>
    <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
