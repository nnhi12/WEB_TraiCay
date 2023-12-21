<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin chi tiết</title>
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
					<h2 style="margin-top:30px;"><b>Tài khoản</b></h2>
				</div>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-2">
						<div class="row">
							<label for="taikhoan" style="margin-top: 20px; font-size: 20px;">Tài khoản</label>
						</div>
						<div class="row">
							<label for="matkhau" style="margin-top: 18px; font-size: 20px;">Mật khẩu</label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<input readonly style="margin-top: 15px; font-size: 20px; border:1px solid;"
								name="taikhoan" id="taikhoan"
								value="${taikhoan.taiKhoan}">
						</div>
						<div class="row">
							<input readonly style="margin-top: 15px; font-size: 20px; border:1px solid;"
								name="matkhau" id="matkhau"
								value="${taikhoan.matKhau}">
						</div>
					</div>
				</div>
				<div class="row">
					<h2 style="margin-top:30px;"><b>Thông tin chi tiết</b></h2>
				</div>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-2">
						<div class="row">
							<label for="tenkh" style="margin-top: 20px; font-size: 20px;">Tên khách hàng</label>
						</div>
						<div class="row">
							<label for="gioitinh" style="margin-top: 18px; font-size: 20px;">Giới tính</label>
						</div>
						<div class="row">
							<label for="ngaysinh" style="margin-top: 18px; font-size: 20px;">Ngày sinh</label>
						</div>
						<div class="row">
							<label for="diachi" style="margin-top: 18px; font-size: 20px;">Địa chỉ</label>
						</div>
						<div class="row">
							<label for="sdt" style="margin-top: 18px; font-size: 20px;">Số điện thoại</label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<input readonly style="margin-top: 15px; font-size: 20px; border:1px solid;"
								name="tenkh" id="tenkh"
								value="${khachhang.hoTen}">
						</div>
						<div class="row">
							<input readonly style="margin-top: 15px; font-size: 20px; border:1px solid;"
								name="gioitinh" id="gioitinh"
								value="${khachhang.gioiTinh}">
						</div>
						<div class="row">
							<input readonly style="margin-top: 15px; font-size: 20px; border:1px solid;"
								name="ngaysinh" id="ngaysinh"
								value="<fmt:formatDate value='${khachhang.ngaySinh}' pattern='dd/MM/yyyy'/>">
						</div>
						<div class="row">
							<input readonly style="margin-top: 15px; font-size: 20px; border:1px solid;"
								name="diachi" id="diachi"
								value="${khachhang.diaChi}">
						</div>
						<div class="row">
							<input readonly style="margin-top: 15px; font-size: 20px; border:1px solid;"
								name="sdt" id="sdt"
								value="${khachhang.sDT}">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="./footerAdmin.jsp"></jsp:include>
</body>
</html>