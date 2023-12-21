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
			<form action="<%=request.getContextPath()%>/giamgia/updategg" method="post" >
				<div class="row">
					<!-- Thông tin sản phẩm -->
					<div class="col-lg-6">
						<table class="table">
							<thead>
								<tr>
									<th colspan="2" class="h3">Thông tin giảm giá</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td> <label for="MaGG" class="hidden-label"></label> </td>
									  <!-- Input liên kết với nhãn bị ẩn -->
									<td>  <input type="text" id="magiamgia" name="magiamgia" value="<c:out value='${giamgia.maGG}' />"readonly > </td>
								</tr>
								<tr>
									<td><label for="Phamtram" class="h4">Phần trăm giảm giá:</label></td>
									<td><input type="number" id="phantram" name="phantram"
										class="form-control" value="<c:out value='${giamgia.giaTri}' />"></td>
								</tr>
								<tr>
									<td><label for="Ngayhethan" class="h4">Ngày hết hạn:</label></td>
									<td> <input  class="form-control" type="date" name ="ngayhethan"  id ="ngayhethan" value="${giamgia.ngayHetHan}" class ="custom-date-input" >
									</td>
								</tr>							
							</tbody>
						</table>
						<div class="text-center mt-3">
							<button type="submit" class="btn btn-success">Save</button>
						</div>						
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="./footerAdmin.jsp"></jsp:include>
</body>