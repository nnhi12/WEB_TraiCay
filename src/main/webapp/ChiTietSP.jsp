<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<title>13FRUITS</title>
<style><%@include file="/css/chitietsp.css"%></style>
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	
	<section class = "mt-25">
		<div class = "container">
		<form action = "<%=request.getContextPath()%>/giohang/insert" method = "post">
			<div class="row">
				<div class="col-md-5">
					<div class="card">
						<div class="card-body">
							<div class="card-img-actions img-book">
								<img src="data:image/jpeg;base64,${base64Image}" class="card-img img-fluid"
									alt="">
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-7">
					
					<table>
						<tbody>
							<tr>
								<td> </td>
							</tr>
							<tr>
								<td> 
									<h1>${sanpham.tenSP}</h1>
								</td>
							</tr>
							<tr>
								<td> 
									<h2>Số lượng:</h2>
								</td>
								<td> 
									<input type="number" min="0" max="${sanpham.soLuong}" value = "0" step="1" class="numeric-up-down" id = "soluong" name = "soluong">
								</td>
							</tr>
							<tr>
								<td> 
									<h2>Giá sản phẩm:</h2>
								</td>
								<td> 
									<h2><c:out value = "${sanpham.gia}"> </c:out></h2>
								</td>
							</tr>
							<tr>
								<td>
									<button type = "submit" class = "btn1 btn-success" id = "maSP" name = "maSP" value = "${sanpham.maSP}">Thêm vào giỏ hàng</button>
								</td>
							</tr>
						</tbody>
					</table>
					
				</div>
			</div>
			</form>
		</div>
		
	</section>

	<section class="mt-25">
		<div class="container">
			<div class="row">
				<h2 class="section-title" onclick="toggleDescription()">MÔ TẢ</h2>
				<div class="description">
					<h3 class="subtitle">Dâu tây của chúng tôi được trồng với tình
						yêu và chăm sóc tận tâm để đảm bảo chất lượng và hương vị tuyệt
						vời. Với màu sắc rực rỡ, hình dạng tròn đẹp và hương thơm tự
						nhiên, dâu tây của chúng tôi sẽ làm hài lòng cả những khách hàng
						khó tính nhất. Chúng tôi cam kết chỉ cung cấp dâu tây tươi ngon,
						chín mọng và giàu dinh dưỡng. Chúng tôi đặt mục tiêu mang đến cho
						quý khách trải nghiệm mua sắm tuyệt vời. Đội ngũ nhân viên chúng
						tôi luôn sẵn lòng tư vấn và chăm sóc quý khách hàng, giúp quý
						khách chọn lựa những quả dâu tây phù hợp với nhu cầu và sở thích
						của mình.</h3>
				</div>
			</div>
		</div>
	</section>

	<script>
		function toggleDescription() {
			var description = document
					.querySelector('.description h3.subtitle');
			description.classList.toggle('show');
		}
	</script>
	<section class = "mt-25">
	</section>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>