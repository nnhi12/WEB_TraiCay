<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <title>chitiethoadon</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
            margin-top: 20px;
            background-color: #eee;   
            color: black;       
        }
        .card {
            box-shadow: 0 20px 27px 0 rgb(0 0 0 0);
        }
        .card {
            position: relative;
            display: flex;
            flex-direction: column;
            min-width: 0;
            word-wrap: break-word;
            background-color: #fff;
            background-clip: border-box;
            border: 0 solid rgba(0, 0, 0, 0);
            border-radius: 1rem;
           
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css"
        integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />
</head>

<body>
    <jsp:include page="./headerAdmin.jsp"></jsp:include>
    <div class="container">
        <div class="row">
         
            <div class="col-md-3">
				<jsp:include page="./linklistAdmin.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
                <div class="card">
                    <div class="card-body">
                        <div class="invoice-title">                            
                            <div class="mb-4">
                           
                                <h2 class="mb-1 ">CHI TIẾT ĐƠN HÀNG</h2>
                            </div>
                           
                                <td><c:choose>
					        <c:when test="${'CB' eq chitiet.giaoVan.tinhTrang}">
					            Chuẩn bị đóng gói
					        </c:when>
					        <c:when test="${'DG' eq chitiet.giaoVan.tinhTrang}">
					            Đang giao hàng
					        </c:when>
					        <c:when test="${'DT' eq chitiet.giaoVan.tinhTrang}">
					            Đã nhận hàng
					        </c:when>
					        <c:otherwise>
					            Trạng thái không xác định
					        </c:otherwise>
					    </c:choose></td>
                           
                        </div>
                        <hr class="my-4">
                        <div class="row">
                            <div class="col-sm-6">
                                            
                                    <h5 class="font-size-16 mb-3">Thông tin giao hàng:</h5>                                   
                                    <h5 class="font-size-15 mb-2">Tên khách hàng</h5>
                                    <input class="font-size-15 mb-2" type = "text" id ="hoten" value ="<c:out value='${chitiet.khachHang.hoTen}'/>">                                 
                                    <h5 class="font-size-15 mt-2">Địa chỉ</h5>    
                                     <input class="font-size-15 mb-2" type = "text" id ="hoten" value ="<c:out value='${chitiet.khachHang.diaChi}'/>">                                 
                                    <h5 class="font-size-15 mt-2">Số Điện Thoại</h5>                              
                                     <input class="font-size-15 mb-2" type = "text" id ="hoten" value ="<c:out value='${chitiet.khachHang.sDT}'/>">                                                                                                         
                                    <h5 class="font-size-15 mt2">Ngày đặt</h5>
                                     <input class="font-size-15 mb-2" type = "text" id ="hoten" value ="<c:out value='${chitiet.HD.ngayDatHang}'/>">                                                                                                         
                                
                                </div>
                            </div>                
                        </div>

                        <div class="py-2">
                            <h5 class="font-size-15">  Đơn Hàng</h5>
                            <div class="table-responsive">
                                <table class="table align-middle table-nowrap table-centered mb-0">
                                    <tbody>
                                        <tr>
                                            <td>
                                                <div class="col-xs-6 col-sm-3 col-md-3 col-lg-2">
                                                    <img class="img-responsive" width="200px" height="200px" src="https://i.pinimg.com/564x/82/e9/c8/82e9c89effc4597d6d23cd55319b4143.jpg"
                                                        alt>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="col-xs-6 col-sm-9 col-md-9 col-lg-10 title">
                                                    <input class="font-size-15 style="  mb-2" type = "text" id ="hoten" value ="<c:out value='${chitiet.sanPham.tenSP}'/>"style="font-size: 20px;" >                                                                                                         
                                
                                                    <td> 
                                                         <div class="font-size-15 mb-2">
                                                         
														    <p>Số lượng: </p>
														<input type="text" id="hoten" value="<c:out value='${chitiet.soLuong} ${chitiet.sanPham.donViTinh}' />">	   
														</div>

                                                    </td>
                                                                                                                   
                                                </div>
                                            </td>
                                        </tr>                                                                        
                                        <tr>
                                            <th scope="row" colspan="4" class="border-0 text-end">Thành Tiền :</th>
                                            <td class="border-0 text-end">
                                             
										    <input class="font-size-15 mb-2" type="text" id="hoten" value="<c:out value='${chitiet.tongTien}'/> ">
											
                                            </td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>                          
                        </div>
                    </div>
                    </div>
                
            </div>
        </div>
    </div>
    <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">

    </script>
    <jsp:include page="./footerAdmin.jsp"></jsp:include>
</body>

</html>