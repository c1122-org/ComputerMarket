<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/17/2023
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <form action="/user?action=login" method="post">
    <div class="section text-center">
      <h4 class="mb-4 pb-3">Log In</h4>
      <div class="form-group">
        <input type="email" name="email" class="form-style" placeholder="Your Email" autocomplete="off" required>
        <i class="input-icon uil uil-at"></i>
      </div>
      <div class="form-group mt-2">
        <input type="password" name="password" class="form-style" placeholder="Your Password" autocomplete="off" required>
        <i class="input-icon uil uil-lock-alt"></i>
      </div>
      <button type="submit" class="btn mt-4">submit</button>
      <p class="mb-0 mt-4 text-center"><a href="#0" class="link">Forgot your password?</a></p>
    </div>
  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
