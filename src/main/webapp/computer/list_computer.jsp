
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            height: 60px;
            z-index: 2;
            background: #f8d7da !important;

        }
        .navbar-collapse {
            align-items: center;
        }
        .content {
            padding-top: 60px;
        }
        img {
            height: 100%;
            /*overflow: hidden;*/
        }
        .card {
            height: 450px;
            margin-bottom: 20px;
            overflow: hidden;
        }
        .card .thumbnail {
            height: 200px;
            overflow: hidden;
        }
        .card:hover {
            background: #dde0e3;
        }
        .card .thumbnail img {
            transition: all 0.3s;
            object-fit: cover;
        }
        .card:hover img {
            transform: scale(1.2);
        }
        .card-body {
            text-align: center;
        }
        footer {
            height: 100px;
            background: #f8d7da !important;
            text-align: center;
        }
        #carouselExampleCaptions{
            margin: auto;
            height: 300px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <button aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"
                class="navbar-toggler"
                data-bs-target="#navbarSupportedContent" data-bs-toggle="collapse" type="button">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a aria-expanded="false" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
                       id="navbarDropdown" role="button">
                        Computer
                    </a>
                    <ul aria-labelledby="navbarDropdown" class="dropdown-menu">
                        <li><a class="dropdown-item" href="https://www.thegioididong.com/laptop-ldp">Laptop</a></li>
                        <li><a class="dropdown-item" href="https://www.thegioididong.com/may-tinh-bang">Tablet</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="https://www.thegioididong.com/may-tinh-de-ban">Desktop Computer</a></li>
                    </ul>
                </li>
                <c:if test="${sessionScope.nameAccount != null}">
                <li>
                    <a href="/computer/create.jsp"><button class="btn btn-primary" type="button">Create</button></a>
                </li>
                </c:if>
                <li>
                <button style="margin-left: 10px" class="btn btn-light"><a href="/computer?action=sort" style="text-decoration: snow">Sort By Producer</a></button>
                </li>
                <c:if test="${sessionScope.nameAccount.getEmail() == 'admin@gmail.com'}">
                <li>
                    <button style="margin-left: 10px; width: 75px" class="btn btn-light"><a href="/user" style="text-decoration: snow">User</a></button>
                </li>
                </c:if>
            </ul>
            <form class="d-flex mb-0" method="post" action="/computer?action=search">
                <input aria-label="Search" class="form-control me-2" placeholder="Search" type="search" name="producer">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>

            <div>
                <c:if test="${sessionScope.nameAccount != null}">
            <div>
                <a style="color: white; text-decoration:none; position: relative; right: 35px; top: 5px" href="#">${sessionScope.nameAccount.name}</a>
            </div>
            <div class="nav-item mx-2"><button style="padding: 0px" class="btn btn-light" type="button"><a href="/user?action=logout"
                                         class="nav-link active login text-secondary text-nav "
                                         aria-current="page">
                <i style="position: absolute; right: 190px; width: 30px; padding-top: 5px; color: white" class="ti-shift-right"></i>
                Logout</a></button>
            </div>
            </c:if>
            <c:if test="${sessionScope.nameAccount == null}">
                <div class="nav-item mx-2">
                    <i class="ti-user"></i>
                    <button style="padding: 0px" class="btn btn-light" type="button"><a href="/user/login.jsp"
                                              class="nav-link active login text-secondary text-nav"
                                              aria-current="page">Login</a></button>
                </div>
            </c:if>
            </div>
        </div>
    </div>
</nav>
<div class="row position-relative content align-content-center">
    <div class="">
        <a href="https://www.chotot.com/"><img
                alt="..."
                class=" card-img-top"
             src="https://cdn.chotot.com/admincentre/43b2b5de-fddc-41bb-9ef9-489adefe70dc_banner_mobile.png"
                style ="height: 400px; object-fit: cover">
        </a>
    </div>
</div>
<div class="container-fluid mt-4" style="background-color: white">


    <h1 class="text-center rounded-pill bg-danger  display-5 text-light">Chợ Tốt - Chợ Mua Bán, Rao Vặt Trực Tuyến Hàng Đầu Của Người Việt</h1>

    <div id="carouselExampleCaptions" class="carousel" style="margin: 50px 150px">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <a href="https://www.chotot.com/"><img href="https://www.chotot.com/" src="https://taiphanmempc.net/wp-content/uploads/2017/07/tai-hinh-nen-4k-cho-may-tinh.jpg" class="d-block w-100" alt="..."></a>
                <div class="carousel-caption d-none d-md-block">
                    <h5>MacBook Promax</h5>
                    <p>Laptop mới 90% giảm giá 30% chỉ duy nhất trong hôm nay.</p>
                </div>
            </div>
            <div class="carousel-item">
                <a href="https://www.chotot.com/"><img src="https://cdn.tgdd.vn/Files/2019/08/22/1190454/laptop-vien-man-hinh-mong-co-nhung-uu-va-nhuoc-diem-gi--6.jpg" class="d-block w-100" alt="..."></a>
                <div class="carousel-caption d-none d-md-block">
                    <h5>Apple</h5>
                    <p>Laptop mới 99% giảm giá 10% chỉ duy nhất trong hôm nay.</p>
                </div>
            </div>
            <div class="carousel-item">
                <a href="https://www.chotot.com/"><img src="https://cdn.nguyenkimmall.com/images/companies/_1/dell-vostro-5568-thiet-ke-dep.jpg" class="d-block w-100" alt="..."></a>
                <div class="carousel-caption d-none d-md-block">
                    <h5>Ipad pro max 2023</h5>
                    <p>Laptop mới 50% giảm giá 20% chỉ duy nhất trong hôm nay.</p>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <h4 class="display-6 text-uppercase fw-bold text-center mb-4">Sản phẩm đang hot</h4>
    <div class="row" >
        <c:forEach items="${computerList}" var="computer">
            <div class="col-12 col-sm-6 col-md-3">
                <div class="card">
                    <a class="thumbnail" href="/computer?action=detail&idPc=${computer.idPc}"><img alt="..." class="card-img-top" src="${computer.img}"></a>
                    <div class="card-body">
                        <h5 class="card-title">${computer.name}</h5>
                        <h4 class="card-text text-primary">${computer.price}</h4>
                        <c:if test="${sessionScope.nameAccount != null}">
                        <a class="btn btn-outline-primary" href="/computer?action=update&idPc=${computer.idPc}">UPDATE</a>
                        <a class="btn btn-danger" href="/computer?action=delete&idPc=${computer.idPc}">DELETE</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <footer class="mt-4 p-2">
        <p>CodeGym_group2@2023. All rights reserved.</p>
    </footer>
</div>

</body>
</html>