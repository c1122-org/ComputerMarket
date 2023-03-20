<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/17/2023
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login</title>
  <link href="../bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>
<body>

  <h3 class="text-primary text-center display-3">Login</h3>
  <form method="post" class="container-lg" action="/user?action=login">
    <div class="mb-3">
      <label for="exampleInputName" class="form-label" placeholder="Your Email">Email</label>
      <input type="text" class="form-control" id="exampleInputName" type="email" name="email" aria-describedby="nameHelp" placeholder="Your Email">
      <i class="input-icon uil uil-at"></i>
    </div>
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">Password</label>
      <input type="password" name="password" class="form-control" id="exampleInputEmail1"  aria-describedby="emailHelp" placeholder="Your Password">
    </div>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
    <button class="btn btn-outline-danger"><a style="text-decoration: none" href="/user/register.jsp">Create new account</a></button>
<%--    <p class="mb-0 mt-4 text-center"><a href="/user/register.jsp" class="link">Create new account</a></p>--%>
    <p class="text-center text-danger">${loginFail} </p>
    </div>

  </form>

</body>
</html>

