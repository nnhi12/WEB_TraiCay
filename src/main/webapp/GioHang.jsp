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
				<c:set var="tongTien" value="0" scope="page" />
				<c:set var="selectedProducts" value="" scope="page" />
				<c:forEach var="gioHang" items="${listGH}" varStatus="status">
					<div class="row">
						<div class="horizontal-label">
							<label> 
								<input type="checkbox" id="maspCheckbox" style="margin-right: 20px" value="${gioHang.maSP}">
								<img src="data:image/jpeg;base64,${base64Image[status.index]}" alt="Image" class="label-image"> 
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
				<label for="tongTienLabel">Tổng số tiền: </label>
				<span id="tongTienLabel">${tongTien}</span>
				
				<form id="paymentForm" action="dathang" method="post">
				    <input type="hidden" name="selectedProducts" value="${selectedProducts}">
				    <button class="btn-success" style="margin-top: 20px" onclick="goToPayment()">Thanh toán</button>
				</form>
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
	
	<script>
    function updateTotal(checkbox, gia) {
        //float gia = ${listGia[status.index]};
        //int soluong = ${gioHang.soLuong};
        float tongTien = (float) document.getElementById("tongTienLabel").textContent;
        
        if (checkbox.checked) {
            tongTien += gia;
        } else {
            tongTien -= gia;
        }
        
        document.getElementById("tongTienLabel").textContent = tongTien.toFixed(2);
    }
    
    function updateSelectedProducts(checkbox) {
        var selectedProducts = "${selectedProducts}";
        var maSP = checkbox.value;
        
        if (checkbox.checked) {
            selectedProducts += maSP + ",";
        } else {
            selectedProducts = selectedProducts.replace(maSP + ",", "");
        }
        
        document.getElementById("selectedProductsField").value = selectedProducts;
        "${selectedProducts}" = selectedProducts;
    }
    
    function goToPayment() {
    	var checkboxes = document.querySelectorAll('#maspCheckbox:checked');
        
        // Tạo một mảng để lưu trữ các mã sản phẩm được chọn
        var selectedProducts = [];
        
        // Lặp qua từng checkbox và thêm mã sản phẩm vào mảng
        checkboxes.forEach(function(checkbox) {
            selectedProducts.push(checkbox.value);
        });
        
        // Gán danh sách masp đã được chọn vào input trong form thanh toán
        var paymentForm = document.getElementById('paymentForm');
        var selectedProductsInput = document.createElement('input');
        selectedProductsInput.type = 'hidden';
        selectedProductsInput.name = 'selectedProducts';
        selectedProductsInput.value = selectedProducts.join(',');
        paymentForm.appendChild(selectedProductsInput);
        // Submit form thanh toán
        document.getElementById("paymentForm").submit();
    }
	</script>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>