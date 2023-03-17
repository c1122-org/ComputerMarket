
<%--
  Created by IntelliJ IDEA.
  User: anhda
  Date: 3/16/2023
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>

    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

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

    <title>Update</title>
</head>
<body>
<h3>Update Computer Information</h3>
<c:if test="${message!=null}">
    <p style="color: blue">${message}</p>
</c:if>
<form method="post">
    <pre>Tên máy tính:    <input value="${user.getName()}" type="text" name="name"></pre>
    <pre>Giá:             <input value="${user.getPrice()}" type="text" name="price"></pre>
    <pre>Nhà sản xuất:    <input value="${user.getProducer()}" type="text" name="producer"></pre>
    <pre>Quốc gia:        <input value="${user.getCountry()}" type="text" name="country"></pre>
    <pre>Chi tiết:        <input value="${user.getDescribe()}" type="text" name="describe"></pre>
    <pre>Ảnh:             <input value="${user.getImg()}" type="text" name="img"></pre>
    <pre>                 <button style="background-color: #5c9be3">Cập nhật</button></pre>
</form>
<a href="/user">< Quay lại trang Danh sách chính</a>

</body>
</html>