<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix ="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Marc Jacobs</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<style>
<%@include file="css/Main.css"%>
</style>
</head>

<body>	
<header><jsp:include page="./header.jsp"></jsp:include>	</header>
    <div class="top-bar">
	    <a href="#" class="logo">13 Fruits<span></span></a>	
	    <div class="icons">
	        <a href="#" class="fas fa-truck"></a> <!-- Vận chuyển -->
	        <a href="#" class="fas fa-shopping-cart"></a> <!-- Giỏ hàng -->
	        <a href="#" class="fas fa-user"></a> <!-- Thông tin người dùng -->
	        <a href="#">Login</a>
	    </div>
	</div>
    

    <!-- header end-->
    <!--home-->
    <section id="home" class="home">
	    <div class="content">	        
	    </div>
	</section>


<!--home end-->   

    <section class="products" id="products">
        <h1 class="heading"> VIEW ALL <span>FRUITS</span></h1>

        <div class="box-container">
        <c:forEach items="${listSP}" var="sp">
            <div class="box">                
                <div class="image">
                    <img src="data:image/jpeg;base64, ${sp.hinhAnh}" alt="">
                    <div class="icons">
                        <a href="#" class="fas fa-heart"></a>
                        <a href="#" >Chi tiết</a> <!-- Chi tiết sản phẩm -->
                    </div>
                </div>

                <div class="content">
                    <h3><c:out value="${sp.tenSP}" /></h3>
                    <div class="price"><c:out value="${sp.gia}" /></div>
                </div>
            </div>
            </c:forEach>            
        </div>
    </section>

    <jsp:include page="./footer.jsp"></jsp:include>
    <!-- jQery -->
  <script src="js/jquery-3.4.1.min.js"></script>
  <!-- bootstrap js -->
  <script src="js/bootstrap.js"></script>
  <!-- custom js -->
  <script src="js/custom.js"></script>
</body>

</html>