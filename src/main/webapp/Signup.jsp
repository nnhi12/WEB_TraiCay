<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="css/style-login.css">
</head>
<body>

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
    <h1>SIGN UP</h1>
    <!-- Login Form -->
    <form action="<%= request.getContextPath() %>/taikhoan/ThemTaiKhoan" method="post">
    <div class="thongtindangky">
	  <div>
	    <input type="text" id="TaiKhoan" class="fadeIn second" name="TaiKhoan" placeholder="Username">
	    <input type="text" id="MatKhau" class="fadeIn second" name="MatKhau" placeholder="Password">
	  </div>
	  <div>
	    <input type="text" id="HoTen" class="fadeIn second" name="HoTen" placeholder="Name">
	    <input type="text" id="SDT" class="fadeIn second" name="SDT" placeholder="Phone">
	  </div>
	  <div class="field-group">
	    <div class="field">
	    <label for="GioiTinh">Gender</label>
	      <select id="GioiTinh" class="fadeIn third" name="GioiTinh">
	        <option value="Nam">Nam</option>
	        <option value="Nu">Nu</option>
	      </select>
	    </div>
	    <div class="field">
	    <label for="NgaySinh">Birthday</label>
	      <input type="date" id="NgaySinh" class="fadeIn third" name="NgaySinh">
	    </div>
	  </div>
	  <input type="text" id="DiaChi" class="fadeIn fourth" name="DiaChi" placeholder="Address">
	  <input type="submit" class="fadeIn fourth" value="Sign Up">
	</div>
  
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <h7>Bạn đã có tài khoản? </h7><a class="underlineHover" href="<%= request.getContextPath() %>/Login.jsp">Login</a>
    </div>

  </div>
</div>
    
</body>
</html>