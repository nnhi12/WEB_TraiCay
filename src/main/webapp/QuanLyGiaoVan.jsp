<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý giao vận</title>
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
		          	<th>Mã giao vận</th>
		            <th>Mã hóa đơn</th>
		            <th>Tình trạng</th>
		            <th>Chi tiết</th>
		            <th></th>
		          </tr>
		        </thead>
		        <tbody>
		        	<!--
		            <tr>
		              <td><c:out value="${sanpham.maSanPham}" /></td>
		              <td><c:out value="${sanpham.tenSanPham}" /></td>
		              <td><c:out value="${sanpham.soLuong}" /></td>
		              <td><c:out value="${sanpham.donViTinh}" /></td>
		              <td><c:out value="${sanpham.gia}" /></td> 
		              <td><a href="edit?id=<c:out value='${sanpham.maSanPham}' />">Edit</a></td>
		            </tr>
		            -->
		        </tbody>
		      </table>
			</div>
		</div>
	</div>
	
	<jsp:include page="./footerAdmin.jsp"></jsp:include>
</body>
</html>