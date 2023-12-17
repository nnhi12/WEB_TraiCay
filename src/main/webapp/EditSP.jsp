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
<title>Cập Nhật Sản Phẩm</title>
<style><%@include file="/css/InsertSP.css"%></style>
</head>
<body>
	<jsp:include page="./headerAdmin.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./linklistAdmin.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
				<div class="row">
					<!-- Thông tin sản phẩm -->
					<div class="col-lg-6">
						<table class="table">
							<thead>
								<tr>
									<th colspan="2" class="h3">Thông tin sản phẩm</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label for="TenSP" class="h4">Tên sản phẩm:</label></td>
									<td><input type="text" id="TenSP" name="TenSP"
										class="form-control" value="${sv.getHoTen()}"></td>
								</tr>
								<tr>
									<td><label for="MaLoaiSP" class="h4">Loại sản phẩm:</label></td>
									<td><select class="form-control" id="MaLoaiSP" name="MaLoaiSP" required>
										<option value="LSP01"> Tươi</option>
									</select></td>
								</tr>
								<tr>
									<td><label for="SoLuong" class="h4">Số lượng:</label></td>
									<td><input type="text" id="SoLuong" name="SoLuong"
										class="form-control" value="${sv.getHoTen()}"></td>
								</tr>
								<tr>
									<td><label for="DonViTinh" class="h4">Đơn vị tính:</label></td>
									<td><select class="form-control" id="DonViTinh" name="DonViTinh" required>
										<option value="kg">kg</option>
										<option value="túi">túi</option>
										<option value="hộp">hộp</option>
									</select></td>
								</tr>
								<tr>
									<td><label for="Gia" class="h4">Giá:</label></td>
									<td><input type="text" id="Gia" name="Gia"
										class="form-control" value="${sv.getCCCD()}"></td>
								</tr>
								<tr>
									<td><label for="MaGG" class="h4">Giảm giá:</label></td>
									<td><select class="form-control" id="MaGG" name="MaGG" required>
										<option value="GG001"> Giảm giá</option>
									</select></td>
								</tr>
								<tr>
									<td><label for="MaNCC" class="h4">Nhà cung cấp:</label></td>
									<td><select class="form-control" id="MaNCC" name="MaNCC" required>
										<option value="CC001"> Nhà cung cấp</option>
									</select></td>
								</tr>
							</tbody>
						</table>
						<div class="text-center mt-3">
							<button class="btn btn-primary mr-3">Save</button>
						</div>
						<div style="margin-top: 40px;"></div>
					</div>
					<div class="col-lg-2 d-flex justify-content-center" style="height: 200px;">
							<img id="image" src="data:image/jpeg;base64,${encodedImage}"
		                 alt="Hình ảnh" class="img-fluid mx-auto d-block mw-100 mh-100">
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footerAdmin.jsp"></jsp:include>
</body>