<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý giao vận</title>
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
		          	<th>Mã giao vận</th>
		            <th>Mã hóa đơn</th>
		            <th>Tình trạng</th>
		            <th>Chi tiết</th>
		          </tr>
		        </thead>
		        <tbody>
		        	<c:forEach var="GV" items="${listGV}">
		            <tr>
		              <td><c:out value="${GV.maGV}" /></td>
		              <td><c:out value="${GV.maHD}" /></td>
		              <td>
							<c:if test="${GV.tinhTrang eq 'CB'}">
										<c:out value="Đang chuẩn bị" />
									</c:if> <c:if test="${GV.tinhTrang eq 'DG'}">
										<c:out value="Đang giao" />
									</c:if> <c:if
										test="${GV.tinhTrang ne 'CB' && GV.tinhTrang ne 'DG'}">
										<c:out value="Đã giao" />
									</c:if>
					 </td>
		              <td>
		              	<form action="showinfo" method="post">
		              		<input type="hidden" id="magv" name="magv" value="${GV.maGV}">
		              		<input type="hidden" id="mahd" name="mahd" value="${GV.maHD}">
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