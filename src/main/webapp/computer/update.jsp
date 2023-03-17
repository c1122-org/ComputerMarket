
<%--
  Created by IntelliJ IDEA.
  User: anhda
  Date: 3/16/2023
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
