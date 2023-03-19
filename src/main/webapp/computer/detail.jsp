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

<div class="row text-primary">
  <div class="col-6">
    <h3 class="display-3 text-danger">Thông tin chi tiết</h3>
    <p class="display-6">Mã sản phẩm : ${computer.idPc}</p>
    <p class="display-6">Tên : ${computer.name}</p>
    <p class="display-6">Giá : ${computer.price}</p>
    <p class="display-6">Nhà sản xuất : ${computer.producer}</p>
    <p class="display-6">Xuất xứ : ${computer.country}</p>
    <p class="display-6">Mô tả : ${computer.describe}</p>
  </div>
  <div class="col-6">
    <img alt="..." class="card-img-top" src="${computer.img}">
  </div>
</div>
<a href="/computer?action=update&idPc=${computer.idPc}">Update</a>
</body>
</html>
