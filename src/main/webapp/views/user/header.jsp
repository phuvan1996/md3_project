<%--
  Created by IntelliJ IDEA.
  User: MR. NEN
  Date: 11/22/2022
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <li class="active"><a href="home.jsp">Home</a></li>
            <li><a href="shop.jsp">Shop</a></li>
            <li><a href="product-detail.jsp">Product</a></li>
            <!-- <li><a href="checkout.html">Checkout</a></li> -->
        </ul>
    </nav>
    <!-- Button Group -->
    <div class="amado-btn-group mt-30 mb-100">
        <a href="register.jsp" class="btn amado-btn mb-15" style="background-image: linear-gradient(
                    to right,
                    #25aae1,
                    #40e495,
                    #30dd8a,
                    #2bb673
                    );border-radius: 30px;
                box-shadow: 0 4px 15px 0 rgba(8, 233, 225, 0.75)">Register</a>
        <a href="login.jsp" class="btn amado-btn active" style="background-image: linear-gradient(
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
