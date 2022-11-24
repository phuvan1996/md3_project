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
    <link href="../https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/core-style.css">
    <link rel="stylesheet" href="../scss/style.scss">


</head>
<body>
<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img style="width: 500px; height:500px" class="d-block w-100" src="https://homehome.vn/wp-content/uploads/6-mau-hinh-anh-noi-that-nha-dep-theo-phong-cach-hien-dai.jpg" alt="First slide">
        </div>
        <div class="carousel-item">
            <img style="width: 500px; height:500px" class="d-block w-100" src="https://homehome.vn/wp-content/uploads/6-mau-hinh-anh-noi-that-nha-dep-theo-phong-cach-hien-dai-6.jpg" alt="Second slide">
        </div>
        <div class="carousel-item">
            <img style="width: 500px; height:500px" class="d-block w-100" src="https://nhadepkinghome.vn/wp-content/uploads/2022/01/1-4.jpg" alt="Third slide">
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
                        <button type="submit"><img src="../img/core-img/search.png" alt=""></button>
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
            <a href="home.jsp"><img src="../img/core-img/logo.png" alt=""></a>
        </div>
        <!-- Navbar Toggler -->
        <div class="amado-navbar-toggler">
            <span></span><span></span><span></span>
        </div>
    </div>

    <!-- Header Area Start -->
   <jsp:include page="header.jsp"></jsp:include>
    <!-- Header Area End -->

    <!-- Product Catagories Area Start -->
    <div class="products-catagories-area clearfix">
        <div class="amado-pro-catagory clearfix">

            <!-- Single Catagory -->
            <div class="single-products-catagory clearfix">
                <a href="shop.jsp">
                    <img src="../img/bg-img/1.jpg" alt="">
                    <!-- Hover Content -->
                    <div class="hover-content">
                        <div class="line"></div>
                        <p>From $180</p>
                        <h4>Modern Chair</h4>
                    </div>
                </a>
            </div>

            <!-- Single Catagory -->
            <div class="single-products-catagory clearfix">
                <a href="shop.jsp">
                    <img src="../img/bg-img/2.jpg" alt="">
                    <!-- Hover Content -->
                    <div class="hover-content">
                        <div class="line"></div>
                        <p>From $180</p>
                        <h4>Minimalistic Plant Pot</h4>
                    </div>
                </a>
            </div>

            <!-- Single Catagory -->
            <div class="single-products-catagory clearfix">
                <a href="shop.jsp">
                    <img src="../img/bg-img/3.jpg" alt="">
                    <!-- Hover Content -->
                    <div class="hover-content">
                        <div class="line"></div>
                        <p>From $180</p>
                        <h4>Modern Chair</h4>
                    </div>
                </a>
            </div>

            <!-- Single Catagory -->
            <div class="single-products-catagory clearfix">
                <a href="shop.jsp">
                    <img src="../img/bg-img/4.jpg" alt="">
                    <!-- Hover Content -->
                    <div class="hover-content">
                        <div class="line"></div>
                        <p>From $180</p>
                        <h4>Night Stand</h4>
                    </div>
                </a>
            </div>

            <!-- Single Catagory -->
            <div class="single-products-catagory clearfix">
                <a href="shop.jsp">
                    <img src="../img/bg-img/5.jpg" alt="">
                    <!-- Hover Content -->
                    <div class="hover-content">
                        <div class="line"></div>
                        <p>From $18</p>
                        <h4>Plant Pot</h4>
                    </div>
                </a>
            </div>

            <!-- Single Catagory -->
            <div class="single-products-catagory clearfix">
                <a href="shop.jsp">
                    <img src="../img/bg-img/6.jpg" alt="">
                    <!-- Hover Content -->
                    <div class="hover-content">
                        <div class="line"></div>
                        <p>From $320</p>
                        <h4>Small Table</h4>
                    </div>
                </a>
            </div>

            <!-- Single Catagory -->
            <div class="single-products-catagory clearfix">
                <a href="shop.jsp">
                    <img src="../img/bg-img/7.jpg" alt="">
                    <!-- Hover Content -->
                    <div class="hover-content">
                        <div class="line"></div>
                        <p>From $318</p>
                        <h4>Metallic Chair</h4>
                    </div>
                </a>
            </div>

            <!-- Single Catagory -->
            <div class="single-products-catagory clearfix">
                <a href="shop.jsp">
                    <img src="../img/bg-img/8.jpg" alt="">
                    <!-- Hover Content -->
                    <div class="hover-content">
                        <div class="line"></div>
                        <p>From $318</p>
                        <h4>Modern Rocking Chair</h4>
                    </div>
                </a>
            </div>

            <!-- Single Catagory -->
            <div class="single-products-catagory clearfix">
                <a href="shop.jsp">
                    <img src="../img/bg-img/9.jpg" alt="">
                    <!-- Hover Content -->
                    <div class="hover-content">
                        <div class="line"></div>
                        <p>From $318</p>
                        <h4>Home Deco</h4>
                    </div>
                </a>
            </div>
        </div>
    </div>
    <!-- Product Catagories Area End -->

</div>
<!-- ##### Main Content Wrapper End ##### -->

<!-- ##### Newsletter Area Start ##### -->
<!-- <section class="newsletter-area section-padding-100-0">
    <div class="container">
        <div class="row align-items-center">
            Newsletter Text
            <div class="col-12 col-lg-6 col-xl-7">
               <div class="newsletter-text mb-100">
                    <h2>Subscribe for a <span>25% Discount</span></h2>
                    <p>Nulla ac convallis lorem, eget euismod nisl. Donec in libero sit amet mi vulputate consectetur. Donec auctor interdum purus, ac finibus massa bibendum nec.</p>
                </div>
            </div>
            <div class="col-md-3 text-center">
                <ul class="list-unstyled mb-0">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                        <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
                      </svg>
                        <p>Nam Từ Liêm, Hà Nội, Việt Nam </p>
                    </li>

                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                        <path d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                      </svg>
                        <p>+ 84 395 888 259</p>
                    </li>

                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
                        <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"/>
                      </svg>
                        <p>contact@Amado.com</p>
                    </li>
                </ul>
            </div> -->
<!-- Newsletter Form -->
<!-- <div class="col-12 col-lg-6 col-xl-5">
    <div class="newsletter-form mb-100">
        <form action="#" method="post">
            <input type="email" name="email" class="nl-email" placeholder="Your E-mail">
            <input type="submit" value="Subscribe">
        </form>
    </div>
</div> -->
<!-- </div>
</div>
</section> -->

<!-- ##### Newsletter Area End ##### -->

<!-- ##### Footer Area Start ##### -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- Area End ##### -->

<!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
<script src="../js/jquery/jquery-2.2.4.min.js"></script>
<!-- Popper js -->
<script src="../js/popper.min.js"></script>

<!-- Bootstrap js -->
<script src="../js/bootstrap.min.js"></script>
<!-- Plugins js -->
<script src="../js/plugins.js"></script>
<!-- Active js -->
<script src="../js/active.js"></script>
</body>

</html>
