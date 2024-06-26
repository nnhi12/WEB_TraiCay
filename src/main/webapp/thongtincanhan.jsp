<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>thongtincanhan</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        input[type="text"]
        {
        border: none;
        outline: none;
        }
        .inf-content {
            border: 1px solid #DDDDDD;
            -webkit-border-radius: 10px;
            -moz-border-radius: 10px;
            border-radius: 10px;
            box-shadow: 7px 7px 7px rgba(0, 0, 0, 0.3);
           
        }
        .custom-date-input {
        border: none;
        width: 100px;
        height: 25px;
    }
    </style>
</head>

<body>
<button class="btn btn-success" onclick="goBack()">Quay lại</button>
	<script>
	    function goBack() {
	        window.history.back();
	    }
	</script>
    <div class="container bootstrap snippets bootdey">
        <div class="panel-body inf-content">
            <div class="row">
                
			<div class="col-md-12">
			<div>
                    <img alt style="width:80px;" title class="img-circle img-thumbnail isTooltip"
                        src="https://i.pinimg.com/564x/df/d5/d0/dfd5d043dfb17b9070fcc7db8e3d5eac.jpg"
                        data-original-title="Usuario">
                    <ul title="Ratings" class="list-inline ratings text-center">
                        <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                    </ul>
                </div>
                <div class="col-md-6">
                    <strong>Thông Tin Của Bạn</strong><br>
                    <div class="table-responsive">
                        <table class="table table-user-information">
                            <tbody>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-user  text-primary"></span>
                                        Họ & Tên
                                        </strong>
                                    </td>
                                    <td class="text-primary">
                                        <input readonly type="text" border: none outline: none value="${khachhang.hoTen }">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-user  text-primary"></span>
                                        Giới Tính
                                        </strong>
                                    </td>
                                    <td class=" text text-primary">                                      
                                        <input readonly type="text" name="gender" value="${khachhang.gioiTinh}">                                     
                                                                             
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-envelope text-primary"></span>
                                        Số Điện Thoại
                                        </strong>
                                    </td>
                                    <td class="text-primary">
                                        <input readonly type="text" border: none outline: none value="${khachhang.sDT}">
                                    </td>
                                </tr>               
                                <tr>
                                    <td>
                                        <strong>
                                            <span class="glyphicon glyphicon-eye-open text-primary"></span>
                                            Vai trò
                                        </strong>
                                    </td>
                                    <td class="text-primary">
                                        Khách hàng
                                    </td>
                                </tr>             
                                <tr>
                                    <td>
                                        <strong>
                                            <span class="glyphicon glyphicon-calendar text-primary"></span>
                                            Ngày sinh
                                        </strong>
                                    </td>
                                    <td class="text-primary">
                                        <input readonly type="date" value='${khachhang.ngaySinh}' class ="custom-date-input" >
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>
                                            <span class="glyphicon glyphicon-map-marker text-primary"></span>
                                            Địa Chỉ
                                        </strong>
                                    </td>
                                    <td class="text-primary">
                                        <input readonly type="text"  value="${khachhang.diaChi}" border: none outline: none>
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
    <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    <jsp:include page="./footerAdmin.jsp"></jsp:include>
    </script>
</body>

</html>