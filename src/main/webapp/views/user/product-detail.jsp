<%--
  Created by IntelliJ IDEA.
  User: MR. NEN
  Date: 11/22/2022
  Time: 6:12 PM
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
  <title>Amado - Furniture Ecommerce Template | Product Details</title>

  <!-- Favicon  -->
  <link rel="icon" href="../img/core-img/favicon.ico">

  <!-- Core Style CSS -->
  <link rel="stylesheet" href="../css/core-style.css">
  <link rel="stylesheet" href="../scss/style.scss">
  <link rel="stylesheet" href="../css/comment.css">

</head>

<body>
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
  <header class="header-area clearfix">
    <!-- Close Icon -->
    <div class="nav-close">
      <i class="fa fa-close" aria-hidden="true"></i>
    </div>
    <!-- Logo -->
    <div class="logo">
      <a href="home.jsp"><img src="../img/core-img/logo.png" alt=""></a>
    </div>
    <!-- Amado Nav -->
    <nav class="amado-nav">
      <ul>
        <li><a href="home.jsp">Home</a></li>
        <li><a href="shop.jsp">Shop</a></li>
        <li class="active"><a href="product-detail.jsp">Product</a></li>
        <!-- <li><a href="cart.html">Cart</a></li> -->
        <!-- <li><a href="checkout.html">Checkout</a></li> -->
      </ul>
    </nav>
    <!-- Button Group -->
    <!-- <div class="amado-btn-group mt-30 mb-100">
        <a href="#" class="btn amado-btn mb-15" style="background-image: linear-gradient(
            to right,
            #25aae1,
            #40e495,
            #30dd8a,
            #2bb673
            );border-radius: 30px;
        box-shadow: 0 4px 15px 0 rgba(8, 233, 225, 0.75)">Discount</a>
        <a href="#" class="btn amado-btn active" style="background-image: linear-gradient(
            to right,
            #25aae1,
            #40e495,
            #30dd8a,
            #2bb673
            );border-radius: 30px;
        box-shadow: 0 4px 15px 0 rgba(8, 233, 225, 0.75)">New this week</a>
    </div> -->
    <!-- Cart Menu -->
    <div class="cart-fav-search mb-100">
      <a href="cart.jsp" class="cart-nav"><img src="../img/core-img/cart.png" alt=""> Cart <span>(0)</span></a>
      <a href="#" class="fav-nav"><img src="../img/core-img/favorites.png" alt=""> Favourite</a>
      <a href="#" class="search-nav"><img src="../img/core-img/search.png" alt=""> Search</a>
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

  <!-- Product Details Area Start -->
  <div class="single-product-area section-padding-100 clearfix">
    <div class="container-fluid">

      <div class="row">
        <div class="col-12">
          <nav aria-label="breadcrumb">
            <ol class="breadcrumb mt-50">
              <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
              <!-- <li class="breadcrumb-item"><a href="#">Furniture</a></li>
              <li class="breadcrumb-item"><a href="#">Chairs</a></li> -->
              <!-- <li class="breadcrumb-item active" aria-current="page">white modern chair</li> -->
            </ol>
          </nav>
        </div>
      </div>

      <div class="row">
        <div class="col-12 col-lg-7">
          <div class="single_product_thumb">
            <div id="product_details_slider" class="carousel slide" data-ride="carousel">
              <ol class="carousel-indicators">
                <li class="active" data-target="#product_details_slider" data-slide-to="0" style="background-image: url(../img/product-img/pro-big-1.jpg);">
                </li>
                <li data-target="#product_details_slider" data-slide-to="1" style="background-image: url(../img/product-img/pro-big-2.jpg);">
                </li>
                <li data-target="#product_details_slider" data-slide-to="2" style="background-image: url(../img/product-img/pro-big-3.jpg);">
                </li>
                <li data-target="#product_details_slider" data-slide-to="3" style="background-image: url(../img/product-img/pro-big-4.jpg);">
                </li>
              </ol>
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <a class="gallery_img" href="../img/product-img/pro-big-1.jpg">
                    <img class="d-block w-100" src="../img/product-img/pro-big-1.jpg" alt="First slide">
                  </a>
                </div>
                <div class="carousel-item">
                  <a class="gallery_img" href="../img/product-img/pro-big-2.jpg">
                    <img class="d-block w-100" src="../img/product-img/pro-big-2.jpg" alt="Second slide">
                  </a>
                </div>
                <div class="carousel-item">
                  <a class="gallery_img" href="../img/product-img/pro-big-3.jpg">
                    <img class="d-block w-100" src="../img/product-img/pro-big-3.jpg" alt="Third slide">
                  </a>
                </div>
                <div class="carousel-item">
                  <a class="gallery_img" href="../img/product-img/pro-big-4.jpg">
                    <img class="d-block w-100" src="../img/product-img/pro-big-4.jpg" alt="Fourth slide">
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-12 col-lg-5">
          <div class="single_product_desc">
            <!-- Product Meta Data -->
            <div class="product-meta-data">
              <div class="line"></div>
              <p class="product-price">$180</p>
              <a href="product-detail.jsp">
                <h6>White Modern Chair</h6>
              </a>
              <!-- Ratings & Review -->
              <div class="ratings-review mb-15 d-flex align-items-center justify-content-between">
                <div class="ratings">
                  <i class="fa fa-star" aria-hidden="true"></i>
                  <i class="fa fa-star" aria-hidden="true"></i>
                  <i class="fa fa-star" aria-hidden="true"></i>
                  <i class="fa fa-star" aria-hidden="true"></i>
                  <i class="fa fa-star" aria-hidden="true"></i>
                </div>
              </div>
              <!-- Avaiable -->
              <p class="avaibility"><i class="fa fa-circle"></i> In Stock</p>
            </div>

            <div class="short_overview my-5">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid quae eveniet culpa officia quidem mollitia impedit iste asperiores nisi reprehenderit consequatur, autem, nostrum pariatur enim?</p>
            </div>

            <!-- Add to Cart Form -->
            <form class="cart clearfix" method="post">
              <div class="cart-btn d-flex mb-50">
                <p>Qty</p>
                <div class="quantity">
                  <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i class="fa fa-caret-down" aria-hidden="true"></i></span>
                  <input type="number" class="qty-text" id="qty" step="1" min="1" max="300" name="quantity" value="1">
                  <span class="qty-plus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-caret-up" aria-hidden="true"></i></span>
                </div>
              </div>
              <a href="cart.jsp">
                <button type="submit" name="addtocart" value="5" class="btn amado-btn">Add to cart</button>
              </a>
            </form>
          </div>
        </div>
      </div>
    </div>

  </div>
  <!-- Product Details Area End -->
</div>
<!-- comment  -->
<div class="container mt-5">
  <div class="d-flex justify-content-center row">
    <div class="col-md-8">
      <div class="d-flex flex-column comment-section">
        <div class="bg-white p-2">
          <div class="d-flex flex-row user-info"><img class="rounded-circle" src="../img/product-img/z3900760444766_b0cf6b0e0db65df679424deca5b998eb.jpg" width="40">
            <div class="d-flex flex-column justify-content-start ml-2"><span class="d-block font-weight-bold name">Jonny Dang</span><span class="date text-black-50">Shared publicly - Jan 2020</span></div>
          </div>
          <div class="mt-2">
            <p class="comment-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
          </div>
        </div>
        <div class="bg-white">
          <div class="d-flex flex-row fs-12">
            <div class="like p-2 cursor"><i class="fa fa-thumbs-o-up"></i><span class="ml-1">Like</span></div>
            <div class="like p-2 cursor"><i class="fa fa-commenting-o"></i><span class="ml-1">Comment</span></div>
            <div class="like p-2 cursor"><i class="fa fa-share"></i><span class="ml-1">Share</span></div>
          </div>
        </div>
        <div class="bg-light p-2">
          <div class="d-flex flex-row align-items-start"><img class="rounded-circle" src="../img/product-img/z3900760452405_cd2daf5800ada12ec3a1b14b8d33fa5b.jpg" width="40"><textarea class="form-control ml-1 shadow-none textarea"></textarea></div>
          <div class="mt-2 text-right"><button class="btn btn-primary btn-sm shadow-none" type="button">Post comment</button><button class="btn btn-outline-primary btn-sm ml-1 shadow-none" type="button">Cancel</button></div>
        </div>
      </div>
    </div>
  </div>
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
            Newsletter Form
            <div class="col-12 col-lg-6 col-xl-5">
                <div class="newsletter-form mb-100">
                    <form action="#" method="post">
                        <input type="email" name="email" class="nl-email" placeholder="Your E-mail">
                        <input type="submit" value="Subscribe">
                    </form>
                </div>
            </div>
        </div>
    </div>
</section> -->
<!-- ##### Newsletter Area End ##### -->

<!-- ##### Footer Area Start ##### -->
<footer class="footer_area clearfix">
  <div class="container">
    <div class="row align-items-center">
      <!-- Single Widget Area -->
      <div class="col-12 col-lg-4">
        <div class="single_widget_area">
          <!-- Logo -->
          <div class="footer-logo mr-50">
            <a href="home.jsp"><img src="../img/core-img/logo2.png" alt=""></a>
          </div>
          <!-- Copywrite Text -->
          <p class="copywrite"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a> & Re-distributed by <a href="https://themewagon.com/" target="_blank">Themewagon</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
        </div>
      </div>
      <!-- Single Widget Area -->
      <div class="col-12 col-lg-8">
        <div class="single_widget_area">
          <!-- Footer Menu -->
          <div class="footer_menu">
            <nav class="navbar navbar-expand-lg justify-content-end">
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#footerNavContent" aria-controls="footerNavContent" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
              <div class="collapse navbar-collapse" id="footerNavContent">
                <ul class="navbar-nav ml-auto">
                  <li class="nav-item active">
                    <a class="nav-link" href="home.jsp">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="shop.jsp">Shop</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="product-detail.jsp">Product</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="cart.jsp">Cart</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="checkout.jsp">Checkout</a>
                  </li>
                </ul>
              </div>
            </nav>
          </div>
        </div>
      </div>
    </div>
  </div>
</footer>
<!-- ##### Footer Area End ##### -->

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
