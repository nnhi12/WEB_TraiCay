<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Giỏ hàng</title>
<style><%@include file="/css/giohang.css"%>
<%@include file="/css/chitietsp.css"%></style>
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="row" style="margin-top: 2%">
					<div class="form-group personal-info-form">
						<label for="id">Giỏ hàng của bạn</label>
					</div>
				</div>
				<div class="row">
					<div class="horizontal-label">
						<label> 
							<input type="checkbox" style = "margin-right: 20px">
							<img src="assets/contain_straw.jpg" alt="Image" class="label-image"> 
							<span class="label-text">
								<a><p>Dâu tây Đà Lạt</p>
									<p>Số lượng:</p>
									<p>Đơn giá: </p>
								</a>
							</span>
							<button class="btn-success" style = "margin-left: 50%">Edit</button>
        					<button style = "margin-left: 20px" class="btn-success">Delete</button>
						</label>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>