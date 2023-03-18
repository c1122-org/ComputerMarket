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
<div class="container-fluid">
    <div class="row col-12">
        <div id="carouselExampleControls" class="carousel slide col-8" data-bs-ride="carousel" style="width: 60%">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="/img/1.jpg" width=100%>
                </div>
                <div class="carousel-item">
                    <img src="/img/2.jpg" width=100% >
                </div>
                <div class="carousel-item">
                    <img src="/img/3.jpg" width=100%>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
        <div class="col-4" style="width: 40%;background: #ffd8f9">
            <h3>Thông tin chi tiết</h3>
            <p>Mã sản phẩm : ${computer.idPc}</p>
            <p>Tên : ${computer.name}</p>
            <p>Giá : ${computer.producer}</p>
            <p>Xuất xứ : ${computer.country}</p>
            <p>Mô tả : ${computer.describe}</p>
            <p>Ảnh : ${computer.img}</p>
            <p>ID_User : ${computer.idUser}</p>
        </div>
    </div>
</div>

</body>
</html>
