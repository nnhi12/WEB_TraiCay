<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<%@include file="css/style-login.css"%>
</style>
</head>
<body>

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
    <h1>LOGIN</h1>
    <!-- Login Form -->
    <form id="loginForm" method="post" action="<%= request.getContextPath() %>/taikhoan/Login" >
      <input type="text" id="TaiKhoan" class="fadeIn second" name="TaiKhoan" placeholder="Username">
      <input type="password" id="MatKhau" class="fadeIn second" name="MatKhau" placeholder="Password">
      <input type="submit" class="fadeIn fourth" value="Log In">      
    </form>
    <!-- Remind Passowrd -->
    <div id="formFooter">
      <h7>Bạn chưa có tài khoản? </h7>
      <a class="underlineHover" href="<%= request.getContextPath() %>/Signup.jsp">Sign Up</a>
    </div>

  </div>
</div>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</body>
</html>