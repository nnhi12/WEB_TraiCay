<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>

<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
	<style><%@include file="/css/linklist.css"%></style>
</head>

<body>
		<a href="<%=request.getContextPath()%>/QuanLySanPhamServlet" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Quản lý sản phẩm</a>
		<a href="<%= request.getContextPath()%>/giamgia/listgg" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Quản lý giảm giá</a>
		<a href="<%= request.getContextPath()%>/khachhang/showlist" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Xem thông tin khách hàng</a>
		<a href="<%= request.getContextPath()%>/giaovan/showlist" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Quản lý đơn hàng</a>
</body>