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
<title>Thêm Sản Phẩm</title>
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
			<form action="<%=request.getContextPath()%>/InsertSPController" method="post" enctype='multipart/form-data'>
				<div class="row">
					<!-- Thông tin sản phẩm -->
					<div class="col-lg-6">
						<table class="table" style = "margin-top:10px;">
							<thead>
								<tr>
									<th colspan="2" class="h4" style = "font-size: 24px; color: #2D6A4F;
									font-family: Playball, sans-serif;">Thông tin sản phẩm</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label for="TenSP" class="h4">Tên sản phẩm:</label></td>
									<td><input type="text" id="TenSP" name="TenSP" class="form-control"></td>
								</tr>
								<tr>
									<td><label for="MaLoaiSP" class="h4">Loại sản phẩm:</label></td>
									<td><select class="form-control" id="MaLoaiSP" name="MaLoaiSP" required>
										<c:forEach items="${listLSP}" var="lsp">
									        <option value="${lsp.maLoaiSP}">${lsp.tenLoai}</option>
									    </c:forEach>
									</select></td>
								</tr>
								<tr>
									<td><label for="SoLuong" class="h4">Số lượng:</label></td>
									<td><input type="text" id="SoLuong" name="SoLuong" class="form-control"></td>
								</tr>
								<tr style = "margin-top:10px;">
									<td><label for="DonViTinh" class="h4">Đơn vị tính:</label></td>
									<td><select class="form-control" id="DonViTinh" name="DonViTinh" required>
										<option value="kg">kg</option>
										<option value="túi">túi</option>
										<option value="hộp">hộp</option>
									</select></td>
								</tr>
								<tr>
									<td><label for="Gia" class="h4">Giá:</label></td>
									<td><input type="text" id="Gia" name="Gia" class="form-control"></td>
								</tr>
								<tr>
									<td><label for="MaGG" class="h4">Giảm giá:</label></td>
									<td><select class="form-control" id="MaGG" name="MaGG" required>
										<c:forEach items="${listGG}" var="gg">
									        <option value="${gg.maGG}">${gg.giaTri}%</option>
									    </c:forEach>
									</select></td>
								</tr>
								<tr>
									<td><label for="MaNCC" class="h4">Nhà cung cấp:</label></td>
									<td><select class="form-control" id="MaNCC" name="MaNCC" required>
										<c:forEach items="${listNCC}" var="ncc">
									        <option value="${ncc.maNCC}">${ncc.tenNCC}</option>
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
					
					<div class="col-lg-5 d-flex justify-content-center" style="height: 200px; margin-left:10px; margin-top:10px;'">
						<input type="file" name="hinhAnh" accept="image/jpeg, image/png"><br>
       					<img id="preview" style="max-width: 200px; max-height: 200px;"><br>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	<script>
    document.querySelector('input[name="hinhAnh"]').addEventListener('change', function(event) {
        const input = event.target;
        const preview = document.getElementById('preview');

        const file = input.files[0];

        if (file) {
            const reader = new FileReader();

            reader.onload = function(e) {
                const img = new Image();
                img.src = e.target.result;

                img.onload = function() {
                    const maxWidth = 400; 
                    const maxHeight = 400;

                    let width = img.width;
                    let height = img.height;
                    if (width > maxWidth || height > maxHeight) {
                        const ratio = Math.min(maxWidth / width, maxHeight / height);

                        width *= ratio;
                        height *= ratio;
                    }

                    const canvas = document.createElement('canvas');
                    const ctx = canvas.getContext('2d');

                    canvas.width = width;
                    canvas.height = height;

                    ctx.drawImage(img, 0, 0, width, height);

                    preview.src = canvas.toDataURL('image/jpeg'); 
                };
            };

            reader.readAsDataURL(file);
        }
    });
</script>

	<jsp:include page="./footerAdmin.jsp"></jsp:include>
</body>