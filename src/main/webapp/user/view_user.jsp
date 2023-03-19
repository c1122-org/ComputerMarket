<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 17/3/2023
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="../bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>
<body class="p-4">
<form class="container-md border-5 table-borderless text-body" method="post" >
    <fieldset>
        <h3 class="text-center text-uppercase mb-4">user information</h3>
        <table class="mt-4 table table-hover table-inverse table-responsive table-bordered border-primary">
            <tbody>
            <tr>
                <td scope="row">ID</td>
                <td>${user.idUser}</td>
            </tr>
            <tr>
                <td scope="">NAME</td>
                <td>${user.name}</td>
            </tr>
            <tr>
                <td scope="">EMAIL</td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td scope="">PASSWORD</td>
                <td>${user.password}</td>
            </tr>
            <tr>
                <td scope="">PHONE NUMBER</td>
                <td>${user.phoneNumber}</td>
            </tr>
            </tbody>

        </table>
    </fieldset>
</form>
</body>
</html>
