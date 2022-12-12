<%--
  Created by IntelliJ IDEA.
  User: MR. NEN
  Date: 11/22/2022
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="mot" id="login">
  <section id="inner-wrapper" class="login">
    <article>
      <form action="<%=request.getContextPath()%>/UserServlet" method="post">
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"> </i></span>
            <input type="text" class="form-control" placeholder="Name" name="username" required>
          </div>
        </div>
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-envelope"> </i></span>
            <input type="email" class="form-control" placeholder="Email Address" name="email" required>
          </div>
        </div>
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-key"> </i></span>
            <input type="password" class="form-control" placeholder="Password" name="password" required>
          </div>
        </div>
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-key"> </i></span>
            <input type="password" class="form-control" placeholder="Confirm Password" name="confirmpass" required>
          </div>
        </div>
        <a href="<%=request.getContextPath()%>/views/user/login.jsp">
          <button type="submit" class="btn btn-success btn-block" name="action" value="register">Submit</button>
        </a>
      </form>
    </article>
  </section></div>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Animated</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
  <script src="main.js"></script>

  <style>
    .hai{
      position: absolute;
      top: 70%;
      left: 50%;
      transform: translate(-50%,-50%);
    }

    body{
      margin: 0;
      padding: 0;
      background-color: #ccc;
    }
    ul{
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      margin: 0;
      padding: 0;
      display: flex;

    }
    ul li{
      list-style: none;
      margin: 0 40px;

    }
    ul li .fa{
      font-size: 40px;
      color: #262626;
      line-height: 80px;
      transition: .5s;

    }
    ul li a{
      position: relative;
      display: block;
      width: 80px;
      height: 80px;
      background-color: #fff;
      text-align: center;
      transform: perspective(100px) rotate(-30deg) skew(25deg) translate(0,0);
      transition: .5s;
      box-shadow: -20px 20px 10px rgb(0, 0, 0, 0.5);
    }
    ul li a::before{
      content: "";
      position: absolute;
      top: 10px;
      left: -20px;
      height: 100%;
      width: 20px;
      background: #b1b1b1;
      transition: .5s;
      transform: rotate(0deg) skewY(-45deg);
    }
    ul li a::after{
      content: "";
      position: absolute;
      top: 80px;
      left: -11px;
      height: 20px;
      width: 100%;
      background: #b1b1b1;
      transition: .5s;
      transform: rotate(0deg) skewX(-45deg);
    }
    ul li a:hover{
      transform: perspective(1000px) rotate(-30deg) skew(25deg) translate(20px, -20px);
      box-shadow: -50px 50px 50px rgb(0, 0, 0, 0.5);
    }
    ul li:hover .fa{
      color: #fff;
    }
    ul li a:hover{
      transform: perspective(1000px) rotate(-30deg) skew(25deg) translate(20px, -20px);
      box-shadow: -50px 50px 50px rgb(0, 0, 0, 0.5);
    }
    ul li:hover:nth-child(1) a{
      background: #3b5999;
    }

    ul li:hover:nth-child(1) a:before{
      background: #2e4a86;
    }
    ul li:hover:nth-child(1) a:after{
      background: #4a69ad;
    }
    ul li:hover:nth-child(2) a{
      background: #55acee;
    }
    ul li:hover:nth-child(2) a:before{
      background: #4184b7;
    }
    ul li:hover:nth-child(2) a:after{
      background: #4d9fde;
    }
    ul li:hover:nth-child(3) a{
      background: #dd4b39;
    }

    ul li:hover:nth-child(3) a:before{
      background: #c13929;
    }
    ul li:hover:nth-child(3) a:after{
      background: #e83322;
    }

    ul li:hover:nth-child(4) a{
      background: #0077B5;
    }

    ul li:hover:nth-child(4) a:before{
      background: #036aa0;
    }
    ul li:hover:nth-child(4) a:after{
      background: #0d82bf;
    }

    ul li:hover:nth-child(5) a{
      background: linear-gradient(#400080, transparent), linear-gradient(200deg, #d047d1, #ff0000, #ffff00);
    }

    ul li:hover:nth-child(5) a:before{
      background: linear-gradient(#400080, transparent), linear-gradient(200deg, #d047d1, #ff0000, #ffff00);
    }
    ul li:hover:nth-child(5) a:after{
      background: linear-gradient(#400080, transparent), linear-gradient(200deg, #d047d1, #ff0000, #ffff00);
    }
    /* style form login */
    body {
      background:#333;
    }
    #login {
      -webkit-perspective: 1000px;
      -moz-perspective: 1000px;
      perspective: 1000px;
      margin-top:50px;
      margin-left:30%;
    }
    .login {
      font-family: 'Josefin Sans', sans-serif;
      -webkit-transition: .3s;
      -moz-transition: .3s;
      transition: .3s;
      -webkit-transform: rotateY(40deg);
      -moz-transform: rotateY(40deg);
      transform: rotateY(40deg);
    }
    .login:hover {
      -webkit-transform: rotate(0);
      -moz-transform: rotate(0);
      transform: rotate(0);
    }
    .login article {

    }
    .login .form-group {
      margin-bottom:17px;
    }
    .login .form-control,
    .login .btn {
      border-radius:0;
    }
    .login .btn {
      text-transform:uppercase;
      letter-spacing:3px;
    }
    .input-group-addon {
      border-radius:0;
      color:#fff;
      background:#f3aa0c;
      border:#f3aa0c;
    }
    .forgot {
      font-size:16px;
    }
    .forgot a {
      color:#333;
    }
    .forgot a:hover {
      color:#5cb85c;
    }

    #inner-wrapper, #contact-us .contact-form, #contact-us .our-address {
      color: #1d1d1d;
      font-size: 19px;
      line-height: 1.7em;
      font-weight: 300;
      padding: 50px;
      background: #fff;
      box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
      margin-bottom: 100px;
    }
    .input-group-addon {
      border-radius: 0;
      border-top-right-radius: 0px;
      border-bottom-right-radius: 0px;
      color: #fff;
      background: #f3aa0c;
      border: #f3aa0c;
      border-right-color: rgb(243, 170, 12);
      border-right-style: none;
      border-right-width: medium;
    }
    .mot{
      position: absolute;
      top: 30%;
      left: 20%;
      transform: translate(-50%,-50%);
    }
  </style>
</head>
<body>
<div class="hai">
  <ul>
    <li><a href="https://www.facebook.com/"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
    <li><a href="https://twitter.com/home?lang=vi"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
    <li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
    <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
    <li><a href="https://www.instagram.com/"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
  </ul>
</div>
</body>
</html>
