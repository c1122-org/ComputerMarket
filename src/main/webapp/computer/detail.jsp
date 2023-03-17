<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/03/2023
  Time: 2:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-8" style="width: 60% ">
        <img src="/img/1.jpg" class="card-img-top" alt="...">
    </div>
    <div class="col-4" style="width: 40%">

                <p>ID : ${computer.id}</p>
                <p>NAME : ${computer.name}</p>
                <p>PRICE : ${computer.producer}</p>
                <p>COUNTRY : ${computer.country}</p>
                <p>DERSCRIBE : ${computer.describe}</p>
    </div>
</div>

</body>
</html>
