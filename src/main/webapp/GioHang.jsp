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
								<button class="btn-success edit-button" style = "margin-left: 50%">Edit</button>
								    
								<button type="submit" class="btn-success save-button" style="display: none; margin-left: 60%"" onclick="submitForm()">Save</button>
								
								<form action="delete" method="post">
									<button type="submit"  style = "margin-left: 20px" class="btn-success delete-button" id="masp" name="masp"
										value="${gioHang.maSP}">Delete</button>
								</form>
							</label>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<script>
    document.addEventListener('DOMContentLoaded', function() {
        var editButtons = document.querySelectorAll('.edit-button');
        var saveButtons = document.querySelectorAll('.save-button');
        var deleteButtons = document.querySelectorAll('.delete-button');

        editButtons.forEach(function(button) {
            button.addEventListener('click', function() {
                var parentDiv = button.closest('.horizontal-label');
                var saveButton = parentDiv.querySelector('.save-button');
                var deleteButton = parentDiv.querySelector('.delete-button');

                button.style.display = 'none';
                saveButton.style.display = 'inline-block';
                deleteButton.style.display = 'none';
            });
        });

        saveButtons.forEach(function(button) {
            button.addEventListener('click', function() {
                var parentDiv = button.closest('.horizontal-label');
                var editButton = parentDiv.querySelector('.edit-button');
                var deleteButton = parentDiv.querySelector('.delete-button');

                button.style.display = 'none';
                editButton.style.display = 'inline-block';
                deleteButton.style.display = 'inline-block';
            });
        });
    });
	</script>
	<script>
	    function submitForm() {
	        var form = document.getElementById('updateForm');
	        form.submit();
	    }
	</script>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>