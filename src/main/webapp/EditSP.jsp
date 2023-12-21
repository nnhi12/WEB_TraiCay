<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
			<form action="<%=request.getContextPath()%>/EditSPController" method="post" enctype='multipart/form-data'>
				<div class="row">
					<!-- Thông tin sản phẩm -->
					<div class="col-lg-6">
						<table class="table">
							<thead>
								<tr>
									<th colspan="2" class="h4" style = "font-size: 24px; color: #2D6A4F;
									font-family: Playball, sans-serif;">Thông tin sản phẩm</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label for="MaSP" class="h4">Mã sản phẩm:</label></td>
									<td><input type="text" id="maSP" name="maSP"
										class="form-control" value="${sanpham.maSP}" readonly></td>
								</tr>
								<tr>
									<td><label for="TenSP" class="h4">Tên sản phẩm:</label></td>
									<td><input type="text" id="tenSP" name="tenSP"
										class="form-control" value="${sanpham.tenSP}"></td>
								</tr>
								<tr>
									<td><label for="MaLoaiSP" class="h4">Loại sản phẩm:</label></td>
									<td><select class="form-control" id="maLoaiSP" name="maLoaiSP" required>
										<c:forEach items="${listLSP}" var="lsp">
									        <option value="${lsp.maLoaiSP}" ${lsp.maLoaiSP == sanpham.maLoaiSP ? 'selected' : ''}>${lsp.tenLoai}</option>
									    </c:forEach>
									</select></td>
								</tr>
								<tr>
									<td><label for="SoLuong" class="h4">Số lượng:</label></td>
									<td><input type="text" id="soLuong" name="soLuong"
										class="form-control" value="${sanpham.soLuong}"></td>
								</tr>
								<tr>
									<td><label for="DonViTinh" class="h4">Đơn vị tính:</label></td>
									<td><select class="form-control" id="donViTinh" name="donViTinh" required>
										<option value="kg" ${'kg'.equalsIgnoreCase(sanpham.donViTinh) ? 'selected' : ''}>kg</option>
										<option value="túi" ${'túi'.equalsIgnoreCase(sanpham.donViTinh) ? 'selected' : ''}>túi</option>
										<option value="hộp" ${'hộp'.equalsIgnoreCase(sanpham.donViTinh) ? 'selected' : ''}>hộp</option>
									</select></td>
								</tr>
								<tr>
									<td><label for="Gia" class="h4">Giá:</label></td>
									<td><input type="text" id="gia" name="gia"
										class="form-control" value="<c:out value='${sanpham.gia}'/>"></td>
								</tr>
								<tr>
									<td><label for="MaGG" class="h4">Giảm giá:</label></td>
									<td><select class="form-control" id="maGG" name="maGG" required>
										<c:forEach items="${listGG}" var="gg">
									        <option value="${gg.maGG}" ${gg.maGG == sanpham.maGG ? 'selected' : ''}>${gg.giaTri}%</option>
									    </c:forEach>
									</select></td>
								</tr>
								<tr>
									<td><label for="MaNCC" class="h4">Nhà cung cấp:</label></td>
									<td><select class="form-control" id="maNCC" name="maNCC" required>
										<c:forEach items="${listNCC}" var="ncc">
									        <option value="${ncc.maNCC}" ${ncc.maNCC == sanpham.maNCC ? 'selected' : ''}>${ncc.tenNCC}</option>
									    </c:forEach>
									</select></td>
								</tr>
							</tbody>
						</table>
						<div class="text-center mt-3">
							<button class="btn btn-primary mr-3">Save</button>
						</div>
						<div style="margin-top: 40px;"></div>
					</div>
					<div class="col-lg-5 d-flex justify-content-center" style="height: 200px; margin-top: 10px; margin-left: 10px">	
							<input type="file" name="hinhanh" accept="image/jpeg, image/png" onchange="previewImage(this);"><br>
							<input type="hidden" id="base64ImageInput" name="base64Image" value="${base64Image}">
							<img id="imageOld" src="data:image/jpeg;base64,${base64Image}" style="max-width: 560px; max-height: 560px;">
							<img id="imageNew" src="" style="max-width: 560px; max-height: 560px; display: none;">
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	<script>
    function previewImage(input) {
        const imageOld = document.getElementById('imageOld');
        const imageNew = document.getElementById('imageNew');

        if (input.files && input.files[0]) {
            const reader = new FileReader();

            reader.onload = function (e) {
                imageNew.src = e.target.result;
                imageNew.style.display = 'block';
                imageOld.style.display = 'none';
            };

            reader.readAsDataURL(input.files[0]);
        } else {
            // Nếu không có ảnh mới, hiển thị ảnh cũ
            imageNew.src = '';
            imageNew.style.display = 'none';
            imageOld.style.display = 'block';
        }
    }
    function prepareBase64Image() {
       
        var base64ImageValue = document.getElementById('imageOld').getAttribute('src').split(',')[1];

        document.getElementById('base64ImageInput').value = base64ImageValue;
    }
</script>
	<jsp:include page="./footerAdmin.jsp"></jsp:include>
</body>