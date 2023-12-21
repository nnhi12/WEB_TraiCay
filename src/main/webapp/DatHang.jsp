<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page session="true" %>
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
<style>
<%@include file="/css/giohang.css"%>
<%@include file="/css/chitietsp.css"%></style>
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<form method="post" action="insert">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="row" style="margin-top: 5%">
					<table>
						<tr>
							<td> Tên khách hàng: 
							</td>
							<td> <input type = "text" value = "${khachhang.hoTen}">
							</td>
						</tr>
						<tr>
							<td> Số điện thoại: 
							</td>
							<td> <input type = "text"  value = "${khachhang.sDT}">
							</td>
						</tr>
						<tr>
							<td> Địa chỉ: 
							</td>
							<td> <input type = "text"  value = "${khachhang.diaChi}">
							</td>
						</tr>
					</table>
				</div>
				<c:forEach var="gioHang" items="${listGH}" varStatus="status">
					<div class="row">
						<div class="horizontal-label">
							<label> 
								<img src="data:image/jpeg;base64,${base64Image[status.index]}" alt="Image" class="label-image"> 
								<span class="label-text">
									<a><p>${listTen[status.index]}</p>
										<p>Số lượng: <input type="text" name="soluong" value="${gioHang.soLuong}"></p>
										<p>Giá: ${listGia[status.index]}</p>
										<p>Giá khi giảm: ${giagiam[status.index]}</p>
									</a>
								</span>
							</label>
						</div>
					</div>
				</c:forEach>
				<div class="row" style="margin-top: 5%">
					<table>
						<tr>
							<td> Phương thức thanh toán: 
							</td>
							<td>
								<select name="paymentMethod">
						            <option value="Momo">Momo</option>
						            <option value="VNPay">VNPay</option>
						            <option value="ZaloPay">ZaloPay</option>
						        </select>
							</td>
						</tr>
					</table>
				</div>
				<div class="row" style="margin-top: 3%; margin-bottom: 2%" >
					 <span>Thành tiền: <input type="text" name="tongTien" value = "${tongtien}"></span>
				</div>
				<div class="row" style="margin-top: 3%; margin-bottom: 5%" >
					 <button type = "submit" class = "btn1 btn-success">Xác nhận thanh toán</button>
				</div>
			</div>
		</div>
	</div>
	</form>
	
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>