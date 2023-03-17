
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
    <title>Create</title>
</head>
<body>
<h3>More Product Details</h3>
<c:if test="${message!=null}">
    <p style="color: green">${message}</p>
</c:if>
<form method="post">
    <pre>Tên sản phẩm:    <input type="text" name="name"></pre>
    <pre>Giá:             <input type="text" name="price"></pre>
    <pre>Nhà sản xuất:    <input type="text" name="producer"></pre>
    <pre>Quốc gia:        <input type="text" name="country"></pre>
    <pre>Mô tả chi tiết:  <input type="text" name="describe"></pre>
    <pre>Ảnh:             <input type="text" name="img"></pre>
    <pre>                 <button style="background-color: #67dc6a">Lưu</button></pre>
</form>
<a href="/computer">< Quay lại trang Danh sách chính</a>
</body>
</html>
