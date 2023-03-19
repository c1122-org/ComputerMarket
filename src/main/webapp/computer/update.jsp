<%--
  Created by IntelliJ IDEA.
  User: anhda
  Date: 3/16/2023
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Cập nhật tin đăng</h1>
<h4><a href="/computer">Quay lại trang chủ</a></h4>
<h3>
    <c:if test="${message != null}">
        <p style="color: coral">${message}</p>
    </c:if>
</h3>

<form class="container-fluid" method="post">
    <div class="mb-3">
        <label for="formGroupExampleInput2" class="form-label">NAME</label>
        <input type="text" class="form-control" id="formGroupExampleInput2" name="name" value="${computer.name}">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput3" class="form-label">PRICE</label>
        <input type="text" class="form-control" id="formGroupExampleInput3" name="price" value="${computer.price}">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput4" class="form-label">PRODUCT</label>
        <input type="text" class="form-control" id="formGroupExampleInput4" name="producer" value="${computer.producer}">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput5" class="form-label">COUNTRY</label>
        <input type="text" class="form-control" id="formGroupExampleInput5" name="country" value="${computer.country}">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput6" class="form-label">DESCRIBE</label>
<%--        <textarea id="formGroupExampleInput6" name="describe" >${computer2.describe} </textarea>--%>
        <input type="text" class="form-control" id="formGroupExampleInput6" name="describe" value="${computer.describe}">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput7" class="form-label">PICTURE</label>
        <input type="text" class="form-control" id="formGroupExampleInput7" name="img" value="${computer.img}">
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>

</body>
</html>
