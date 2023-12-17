<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--BIEU TUONG-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<title>Trang chủ</title>
<style><%@include file="/css/trangchuAdmin.css"%></style>
</head>
<body>
	<jsp:include page="./headerAdmin.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./linklistAdmin.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
				<table class="table table-bordered" style = "margin-top:10px;">
		        <thead>
		          <tr>
		            <th>Tên sản phẩm</th>
		            <th>Số lượng</th>
		            <th>Đơn vị tính</th>
		            <th>Giá</th>
		          </tr>
		        </thead>
		        <tbody>

		            <tr>
		              <td><c:out value="${sanpham.tenSanPham}" /></td>
		              <td><c:out value="${sanpham.soLuong}" /></td>
		              <td><c:out value="${sanpham.donViTinh}" /></td>
		              <td><c:out value="${sanpham.gia}" /></td>
		            </tr>
		        </tbody>
		      </table>
			</div>
		</div>
	</div>
	<jsp:include page="./footerAdmin.jsp"></jsp:include>
</body>
</html>