<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MR. NEN
  Date: 11/22/2022
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Amado - Furniture Ecommerce Template | Home</title>

    <!-- Favicon  -->
    <link rel="icon" href="../img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link href="../https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/core-style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/scss/style.scss">


</head>
<body>
<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img style="width: 500px; height:500px" class="d-block w-100"
                 src="https://homehome.vn/wp-content/uploads/6-mau-hinh-anh-noi-that-nha-dep-theo-phong-cach-hien-dai.jpg"
                 alt="First slide">
        </div>
        <div class="carousel-item">
            <img style="width: 500px; height:500px" class="d-block w-100"
                 src="https://homehome.vn/wp-content/uploads/6-mau-hinh-anh-noi-that-nha-dep-theo-phong-cach-hien-dai-6.jpg"
                 alt="Second slide">
        </div>
        <div class="carousel-item">
            <img style="width: 500px; height:500px" class="d-block w-100"
                 src="https://nhadepkinghome.vn/wp-content/uploads/2022/01/1-4.jpg" alt="Third slide">
        </div>
    </div>
</div>

<!-- Search Wrapper Area Start -->
<div class="search-wrapper section-padding-100">
    <div class="search-close">
        <i class="fa fa-close" aria-hidden="true"></i>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="search-content">
                    <form action="#" method="get">
                        <input type="search" name="search" id="search" placeholder="Type your keyword...">
                        <button type="submit"><img src="<%=request.getContextPath()%>/views/img/core-img/search.png"
                                                   alt=""></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Search Wrapper Area End -->

<!-- ##### Main Content Wrapper Start ##### -->
<div class="main-content-wrapper d-flex clearfix">

    <!-- Mobile Nav (max width 767px)-->
    <div class="mobile-nav">
        <!-- Navbar Brand -->
        <div class="amado-navbar-brand">
            <a href="<%=request.getContextPath()%>/views/user/home.jsp"><img
                    src="<%=request.getContextPath()%>/views/img/core-img/logo.png" alt=""></a>
        </div>
        <!-- Navbar Toggler -->
        <div class="amado-navbar-toggler">
            <span></span><span></span><span></span>
        </div>
    </div>

    <!-- Header Area Start -->
    <header class="header-area clearfix">
        <!-- Close Icon -->
        <div class="nav-close">
            <i class="fa fa-close" aria-hidden="true"></i>
        </div>
        <!-- Logo -->
        <div class="logo">
            <a href="<%=request.getContextPath()%>/views/user/home.jsp"><img
                    src="<%=request.getContextPath()%>/views/img/core-img/logo.png" alt=""/></a>
        </div>
        <!-- Amado Nav -->
        <nav class="amado-nav">
            <ul>
                <li class="active"><a href="<%=request.getContextPath()%>/HomeServlet?action=home">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/HomeServlet?action=shop">Shop</a></li>
<%--                <li><a href="<%=request.getContextPath()%>/HomeServlet?action=detail&&productId">Product</a></li>--%>
                <!-- <li><a href="checkout.html">Checkout</a></li> -->
            </ul>
        </nav>
        <!-- Button Group -->
        <div class="amado-btn-group mt-30 mb-100">
            <a href="<%=request.getContextPath()%>/views/user/register.jsp" class="btn amado-btn mb-15" style="background-image: linear-gradient(
                    to right,
                    #25aae1,
                    #40e495,
                    #30dd8a,
                    #2bb673
                    );border-radius: 30px;
                box-shadow: 0 4px 15px 0 rgba(8, 233, 225, 0.75)">Register</a>
            <a href="<%=request.getContextPath()%>/views/user/login.jsp" class="btn amado-btn active" style="background-image: linear-gradient(
                    to right,
                    #25aae1,
                    #40e495,
                    #30dd8a,
                    #2bb673
                    );border-radius: 30px;
                box-shadow: 0 4px 15px 0 rgba(8, 233, 225, 0.75)">Login</a>
        </div>
        <!-- Cart Menu -->
        <div class="cart-fav-search mb-100">
            <a href="" class="cart-nav"><img src="<%=request.getContextPath()%>/views/img/core-img/cart.png"
                                                      alt=""> Cart <span>(0)</span></a>
            <a href="#" class="fav-nav"><img src="<%=request.getContextPath()%>/views/img/core-img/favorites.png"
                                             alt=""> Favourite</a>
            <a href="#" class="search-nav"><img src="<%=request.getContextPath()%>/views/img/core-img/search.png"
                                                alt=""> Search</a>
        </div>
        <!-- Social Button -->
        <div class="social-info d-flex justify-content-between">
            <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
        </div>
    </header>
    <!-- Header Area End -->
    <!-- Product Catagories Area Start -->
    <div class="products-catagories-area clearfix">
        <div class="amado-pro-catagory clearfix">
            <!-- Single Catagory -->
            <c:forEach items="${listproduct}" var="pro">
                <div class="single-products-catagory clearfix">
                    <a href="<%=request.getContextPath()%>/HomeServlet?action=detail&&productId=${pro.productId}">
                        <img src="<%=request.getContextPath()%>/images/${pro.productImage}"
                             alt="${pro.productName}" width="600px" height="600px" />
                        <!-- Hover Content -->
                        <div class="hover-content">
                            <div class="line"></div>
                            <p>${pro.productName}</p>
                            <p>From ${pro.price}</p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <div class="row">
            <div class="col-12">
                <!-- Pagination -->
                <nav aria-label="navigation">
                    <ul class="pagination justify-content-end mt-50">
                        <li class="page-item active"><a class="page-link" href="#">01.</a></li>
                        <li class="page-item"><a class="page-link" href="product-detail.jsp">02.</a></li>
                        <li class="page-item"><a class="page-link" href="#">03.</a></li>
                        <li class="page-item"><a class="page-link" href="#">04.</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <!-- ##### Footer Area Start ##### -->
<%--    <jsp:include page="footer.jsp"></jsp:include>--%>
    <!-- Area End ##### -->
    <!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
    <script src="<%=request.getContextPath()%>/views/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="<%=request.getContextPath()%>/views/js/popper.min.js"></script>

    <!-- Bootstrap js -->
    <script src="<%=request.getContextPath()%>/views/js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="<%=request.getContextPath()%>/views/js/plugins.js"></script>
    <!-- Active js -->
    <script src="<%=request.getContextPath()%>/views/js/active.js"></script>
</body>
</html>
