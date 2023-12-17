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
</head>

<body>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css"
        integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="invoice-title">                            
                            <div class="mb-4">
                                <h2 class="mb-1 ">CHI TIẾT ĐƠN HÀNG</h2>
                            </div>
                           
                                <p class="mb-1">Đang chuẩn bị</p>
                           
                        </div>
                        <hr class="my-4">
                        <div class="row">
                            <div class="col-sm-6">
                                            
                                    <h5 class="font-size-16 mb-3">Thông tin giao hàng:</h5>                                   
                                    <h5 class="font-size-15 mb-2">Tên khách hàng</h5>
                                    <h6 class="font-size-12 mb-2">(Tên khách hàng)</h6>
                                    <h5 class="font-size-15 mt-2">Địa chỉ</h5>    
                                    <h6 class="font-size-12 mb-2">(Địa chỉ)</h6>
                                    <h5 class="font-size-15 mt-2">Số Điện Thoại</h5>                              
                                    <h6 class="font-size-12 mb-2">001-234-5678</h6>                                                                                  
                                    <h5 class="font-size-15 mt2">Ngày đặt</h5>
                                    <p>05/12/2023</p>
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
                                                    <h3>Tên sản phẩm</h3>
                                                    <td> 
                                                         <p>Số lượng : 1</p>
                                                    </td>
                                                    <td> 
                                                        <p>kg/hộp</p>
                                                   </td>                                                                
                                                </div>
                                            </td>
                                        </tr>                                    
                                        <tr>
                                            <th scope="row" colspan="4" class="text-end">Tổng</th>
                                            <td class="text-end">38.000 vnd</td>
                                        </tr>

                                        <tr>
                                            <th scope="row" colspan="4" class="border-0 text-end">
                                               Giảm giá :</th>
                                            <td class="border-0 text-end"> -5.000 vnd</td>
                                        </tr>
                                        <tr>
                                            <th scope="row" colspan="4" class="border-0 text-end">Thành Tiền :</th>
                                            <td class="border-0 text-end">
                                                <h4 class="m-0 fw-semibold">32.000 vnd</h4>
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
</body>

</html>