<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
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
		            <th>Tổng Tiền</th>
		            <th>Phương thức thanh toán</th>
		            <th>Tình Trạng</th>
		          </tr>
		        </thead>
		        <tbody> 
		        <c:forEach var="gg" items ="${listcthd}" varStatus="status">
		            <tr>		       
					  <td>${khachhang.hoTen}</td>
					  <td>${khachhang.diaChi}</td>
					  <td>${khachhang.sDT}</td>
					  <td>${gg.tongTien}</td>
					  <td>${gg.phuongThucTT}</td>
					  <td>
					  		<c:set var="tinhTrang" value="${giaovan[status.index]}"/>
					  		<c:if test="${tinhTrang.equals('CB')}">
						        Chuẩn bị đóng gói
						    </c:if>
						    <c:if test="${tinhTrang.equals('DG')}">
						        Đang giao hàng
						    </c:if>
						    <c:if test="${tinhTrang.equals('DT')}">
						        Đã nhận hàng
						    </c:if>
						    </td>
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