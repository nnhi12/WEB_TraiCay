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
<button class="btn btn-success" onclick="goBack()">Quay lại</button>
	<script>
	    function goBack() {
	        window.history.back();
	    }
	</script>
	<div class="container">
		<div class="row">
		
			<div class="col-md-12">
				<table class="table table-bordered" style = "margin-top:10px;">
		        <thead>
		          <tr>		          	
		            <th>Họ tên</th>
		            <th>Địa chỉ</th>
		            <th>SDT</th>
		             <th>Tên Sản phẩm</th>
		            <th>Tổng Tiền</th>
		            <th>Tình Trạng</th>
		          </tr>
		        </thead>
		        <tbody> 
		        <c:forEach var="gg" items ="${listcthd}">
		            <tr>		       
		            
					  <td>${gg.khachHang.hoTen}</td>
					  <td>${gg.khachHang.diaChi}</td>
					  <td>${gg.khachHang.sDT}</td>
					  <td>${gg.sanPham.tenSP}</td>
					  <td>${gg.tongTien}</td>
					  <td><c:choose>
					        <c:when test="${'CB' eq gg.giaoVan.tinhTrang}">
					            Chuẩn bị đóng gói
					        </c:when>
					        <c:when test="${'DG' eq gg.giaoVan.tinhTrang}">
					            Đang giao hàng
					        </c:when>
					        <c:when test="${'DT' eq gg.giaoVan.tinhTrang}">
					            Đã nhận hàng
					        </c:when>
					        <c:otherwise>
					            Trạng thái không xác định
					        </c:otherwise>
					    </c:choose></td>
		              <td><a href="viewcthd?mahd=${gg.maHD}"> <i class="material-icons" data-toggle="tooltip" title="Edit" style="font-color: #F49608">chi tiết</i></a>
		              </td>
		            </tr>
		            </c:forEach>
		        </tbody>
		      </table>
			</div>
		</div>
	</div>
	
	
</body>