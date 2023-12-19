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
<title>Quản Lý Sản Phẩm</title>
<style><%@include file="/css/QLSP.css"%></style>
</head>
<body>
	<jsp:include page="./headerAdmin.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./linklistAdmin.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
    			<button type="submit" class="btn btn-primary" onclick="window.location.href='<%=request.getContextPath()%>/LoadDataInsertController'" >Insert</button>
				<table class="table table-bordered" style = "margin-top:10px;">
		        <thead>
		          <tr>
		          	<th>Mã sản phẩm</th>
		            <th>Tên sản phẩm</th>
		            <th>Số lượng</th>
		            <th>Đơn vị tính</th>
		            <th>Giá</th>
		            <th>Edit</th>
		            <th>Delete</th>
		          </tr>
		        </thead>
		        <tbody>
		        <c:forEach var="sanpham" items="${listSP}">
		            <tr>
		              <td><c:out value="${sanpham.maSP}" /></td>
		              <td><c:out value="${sanpham.tenSP}" /></td>
		              <td><c:out value="${sanpham.soLuong}" /></td>
		              <td><c:out value="${sanpham.donViTinh}" /></td>
		              <td><c:out value="${sanpham.gia}" /></td> 
		              <td><a href="edit?id=<c:out value='${sanpham.maSP}' />">Edit</a></td>
		              <td><a href="delete?id=<c:out value='${sanpham.maSP}' />">Delete</a></td>
		            </tr>
		            </c:forEach>
		        </tbody>
		      </table>
			</div>
		</div>
	</div>
	<jsp:include page="./footerAdmin.jsp"></jsp:include>
</body>