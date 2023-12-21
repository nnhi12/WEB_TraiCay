<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>
<%@ page session="true" %>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<style>
<%@include file="css/Main.css"%>
</style>
</head>

<!-- HEADER -->
<div class="top-bar">
      <a href="<%= request.getContextPath()%>/Sanpham/ListSP" class="logo">13 Fruits<span></span></a>	
	    <div class="icons">
	        <a href="<%= request.getContextPath()%>/chitiethoadon/listcthd" class="fas fa-truck"></a> <!-- Vận chuyển -->
	        <a href="<%= request.getContextPath()%>/giohang/load" class="fas fa-shopping-cart"></a> <!-- Giỏ hàng -->
	        <a href="<%= request.getContextPath()%>/thongtinkhachhang/profile" class="fas fa-user"></a> <!-- Thông tin người dùng -->
	        <a href="<%= request.getContextPath() %>/logout">Logout</a>
	    </div>
    </div>
<!-- Header -->
</html>