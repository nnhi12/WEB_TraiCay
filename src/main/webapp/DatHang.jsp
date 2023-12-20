<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--BIEU TUONG-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<title>Đặt hàng</title>
<style><%@include file="/css/giohang.css"%>
<%@include file="/css/chitietsp.css"%></style>
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="row" style="margin-top: 2%">
					<table>
						<tr>
							<td> Tên khách hàng: 
							</td>
							<td> <input type = "text">
							</td>
						</tr>
						<tr>
							<td> Số điện thoại: 
							</td>
							<td> <input type = "text">
							</td>
						</tr>
						<tr>
							<td> Địa chỉ: 
							</td>
							<td> <input type = "text">
							</td>
						</tr>
					</table>
				</div>
				<c:forEach var="gioHang" items="${listGH}" varStatus="status">
					<div class="row">
						<div class="horizontal-label">
							<label> 
								
								<input type="checkbox" style = "margin-right: 20px" value = "${gioHang.maSP}">
								<img src="assets/contain_straw.jpg" alt="Image" class="label-image"> 
								<span class="label-text">
									<a><p>${listTen[status.index]}</p>
									<form id="updateForm" action="update" method="post">
										<input type = "hidden"  id="masp" name="masp" value="${gioHang.maSP}">
										<p>Số lượng: <input type="text" name="soluong" value="${gioHang.soLuong}"></p>
									</form>
										<p>Giá: ${listGia[status.index]}</p>
									</a>
								</span>
							</label>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>