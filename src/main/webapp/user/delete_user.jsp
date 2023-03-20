<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 17/3/2023
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>
<body class="container-lg p-4">
<form class="container-md" method="post">
        <h3 class="text-center text-uppercase mb-4">delete user</h3>
        <button style="margin-left: 158px; margin-bottom: 20px" class="btn btn-outline-danger"><a style="text-decoration: none" href="/user">Back to user list</a></button>
<table class="table w-75 bg-gradient table-bordered border-primary m-auto">
    <tbody>
    <tr>
        <td scope="row">ID</td>
        <td>${user.idUser}</td>
    </tr>
    <tr>
        <td scope="">NAME</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td scope="">EMAIL</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td scope="">PASSWORD</td>
        <td>${user.password}</td>
    </tr>
    <tr>
        <td scope="">PHONE NUMBER</td>
        <td>${user.phoneNumber}</td>
    </tr>
    </tbody>

</table>
    <tr class="m-auto">
        <td>
            <%--                <button type="submit" class="btn btn-primary">Submit</button>--%>
            <button type="button" class="btn btn-primary d-flex m-auto mt-3" data-bs-toggle="modal" data-bs-target="#exampleModal">
                delete
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Are you sure?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success">Delete</button>

                        </div>
                    </div>
                </div>
            </div>
        </td>
    </tr>
</form>
</body>
</html>
