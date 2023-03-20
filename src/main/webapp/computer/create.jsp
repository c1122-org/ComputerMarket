<%--
  Created by IntelliJ IDEA.
  User: anhda
  Date: 3/16/2023
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
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
<h1>Create new PC</h1>
<h4><a href="/computer">Quay lại trang chủ</a></h4>
<h3>
    <c:if test="${message != null}">
        <p style="color: coral">${message}</p>
    </c:if>
</h3>

<form class="container-fluid" action="/computer?action=create" method="post">
    <div class="mb-3">
        <label for="formGroupExampleInput2" class="form-label">NAME</label>
        <input type="text" class="form-control" id="formGroupExampleInput2" name="name">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput3" class="form-label">PRICE</label>
        <input type="text" class="form-control" id="formGroupExampleInput3" name="price">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput4" class="form-label">PRODUCT</label>
        <input type="text" class="form-control" id="formGroupExampleInput4" name="product">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput5" class="form-label">COUNTRY</label>
        <input type="text" class="form-control" id="formGroupExampleInput5" name="country">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput6" class="form-label">DESCRIBE</label>
        <textarea class="form-control" id="formGroupExampleInput6" name="describe"> </textarea>
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput7" class="form-label">PICTURE</label>
        <input type="text" class="form-control" id="formGroupExampleInput7" name="img">
    </div>
    <button type="create" class="btn btn-primary">Submit</button>
</form>

</body>
</html>

