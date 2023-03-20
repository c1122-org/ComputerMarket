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

<div class="row text-primary m-1">
  <div class="col-6">
    <h1 class="text-danger">Thông tin chi tiết</h1>
    <h4>Mã sản phẩm : ${computer.idPc}</h4>
    <h4>Tên : ${computer.name}</h4>
    <h4>Giá : ${computer.price}</h4>
    <h4>Nhà sản xuất : ${computer.producer}</h4>
    <h4>Xuất xứ : ${computer.country}</h4>
    <h4>Mô tả : ${computer.describe}</h4>
    <h4>Tên người đăng : ${computer.user.name}</h4>
    <h4>Số điện thoại liên hệ : ${computer.user.phoneNumber}</h4>
  </div>
  <div class="col-6">
    <img alt="..." height="390px" class="card-img-top" src="${computer.img}">
  </div>
</div>
</body>
</html>
