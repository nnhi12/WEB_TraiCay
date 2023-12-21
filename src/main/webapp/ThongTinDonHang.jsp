<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin đơn hàng</title>
</head>
<body>
	<jsp:include page="./headerAdmin.jsp"></jsp:include>
	<form action="update" method="post">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./linklistAdmin.jsp"></jsp:include>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-8">
				<div class="row">
					<h2 style="margin-top:30px;"><b>Giao vận</b></h2>
				</div>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-3">
						<div class="row">
							<label for="magv" style="margin-top: 20px; font-size: 20px;">Mã giao vận</label>
						</div>
						<div class="row">
							<label for="tinhtrang" style="margin-top: 18px; font-size: 20px;">Trạng thái</label>
						</div>
						<div class="row">
							<label for="ten" style="margin-top: 18px; font-size: 20px;">Tên người nhận</label>
						</div>
						<div class="row">
							<label for="diachi" style="margin-top: 18px; font-size: 20px;">Địa chỉ</label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<input readonly style="margin-top: 15px; font-size: 20px; border:1px solid;"
							name="magv" id="magv"
							value="<c:out value="${giaovan.maGV}" />">
						</div>
						<div class="row">
							<select id="tinhtrang" name="tinhtrang" style="margin-top:20px; height:35px; border:1px solid;">
								<c:if test="${giaovan.tinhTrang eq 'CB'}">
									<option value="CB">Đang chuẩn bị</option>
									<option value="DG">Đang giao</option>
									<option value="DT">Đã giao</option>
								</c:if>
								<c:if test="${giaovan.tinhTrang eq 'DG'}">
									<option value="DG">Đang giao</option>
									<option value="DT">Đã giao</option>
								</c:if>
								<c:if test="${giaovan.tinhTrang eq 'DT'}">
									<option value="DT">Đã giao</option>
								</c:if>
							</select>
						</div>
						<div class="row">
							<input readonly style="margin-top: 15px; font-size: 20px; border:1px solid;"
							name="ten" id="ten"
							value="<c:out value="${khachhang.hoTen}" />">
						</div>
						<div class="row">
							<input readonly style="margin-top: 15px; font-size: 20px; border:1px solid;"
							name="diachi" id="diachi"
							value="<c:out value="${khachhang.diaChi}" />">
						</div>
					</div>
				</div>
				<div class="row">
					<h2 style="margin-top:30px;"><b>Thông tin chi tiết</b></h2>
				</div>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-3">
						<div class="row">
							<label for="mahd" style="margin-top: 20px; font-size: 20px;">Mã hóa đơn</label>
						</div>
						
					</div>
					<div class="col-md-4">
						<div class="row">
							<input readonly style="margin-top: 15px; font-size: 20px; border:1px solid;"
							name="mahd" id="mahd"
							value="<c:out value="${hoadon.maHD}" />">
						</div>
					</div>	
				</div>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-9">
					<table class="table table-bordered" style="margin-top:20px; width:80%;">
						<thead>
							<tr>
								<th style="width:300px;">Tên sản phẩm</th>
								<th style="width:50px;">Số lượng</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="chitiet" items="${chitiethoadon}" varStatus="loop">
							<tr>
								<td><c:out value="${listSP.get(loop.index).tenSP}"/></td>
								<td><c:out value="${chitiet.soLuong}"/></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
				</div>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-3">
						<div class="row">
							<label for="tong" style="margin-top: 20px; font-size: 20px;">Tổng tiền</label>
						</div>
						
					</div>
					<div class="col-md-4">
						<div class="row">
							<input readonly style="margin-top: 15px; font-size: 20px; border:1px solid;"
							name="tong" id="tong"
							value="<c:out value="${hoadon.tongTien}" />">
						</div>
					</div>	
				</div>
				<div class="row">
					<button class="btn-primary" type="submit"
					style="margin-left:55%; width:80px; height:35px; margin-top:30px;">Update</button>
				</div>
			</div>
		</div>
	</div>
	</form>
	
	<jsp:include page="./footerAdmin.jsp"></jsp:include>
</body>
</html>