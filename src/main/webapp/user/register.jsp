<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/17/2023
  Time: 9:41 AM
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
  <title>Register</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <form action="/user?action=register" method="post">
    <div class="section text-center">
      <h4 class="mb-4 pb-3">Register</h4>
      <div class="form-group d-flex align-items-center text-danger">
        <input type="text" name="name" class="form-style" placeholder="Your Full Name" autocomplete="off" minlength="3" maxlength="50" required>
        <span class="ms-2" style="padding-top: 8px;"> *</span>
      </div>
      <div class="form-group mt-2 d-flex align-items-center text-danger">
        <input type="email" name="email" class="form-style" placeholder="Your Email"  autocomplete="off" max="50" required>
        <span class="ms-2" style="padding-top: 8px;"> *</span>
      </div>
      <div class="form-group mt-2 d-flex align-items-center text-danger">
        <input type="password" name="password" class="form-style" placeholder="Your Password"  autocomplete="off" minlength="6" maxlength="50" required>
        <span class="ms-2" style="padding-top: 8px;"> *</span>
      </div>
      <button type="submit" class="btn mt-4">Submit</button>
    </div>
  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>