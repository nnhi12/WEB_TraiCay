<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý khách hàng</title>
</head>
<body>
	<jsp:include page="./headerAdmin.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./linklistAdmin.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
				<table class="table table-bordered" style = "margin-top:10px;">
		        <thead>
		          <tr>
		          	<th>Mã khách hàng</th>
		            <th>Tên khách hàng</th>
		            <th>Số điện thoại</th>
		            <th>Chi tiết</th>
		          </tr>
		        </thead>
		        <tbody>
		           	<c:forEach var="KH" items="${listKH}">
		            <tr>
		              <td><c:out value="${KH.maKH}" /></td>
		              <td><c:out value="${KH.hoTen}" /></td>
		              <td><c:out value="${KH.sDT}" /></td>
		              <td>
		              	<form action="showinfo" method="post">
		              		<input type="hidden" id="makh" name="makh" value="${KH.maKH}">
		              		<button type="submit"
		              			onmouseover="this.style.color='red'"
								onmouseout="this.style.color='blue'"
								style="text-decoration: underline; color:blue; cursor:pointer;
										background:none; border:none;">Chi tiết</button>
		              	</form>
		              </td>
		            </tr>
		            </c:forEach>   
		        </tbody>
		      </table>
			</div>
		</div>
	</div>
	
	<jsp:include page="./footerAdmin.jsp"></jsp:include>
</body>
</html>