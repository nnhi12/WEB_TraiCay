<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>Edgecut</title>


  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet" />

  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />

  
<style>
	.navbar-nav {
	  background-color: white;
	  padding: 10px;
	  width: 400px; /* Chiều rộng tùy chỉnh */
	  height: 400px; /* Chiều dài tùy chỉnh */
	  overflow-y: auto; /* Hiển thị thanh cuộn dọc nếu nội dung vượt quá chiều dài */
	  margin-left: -80px;
	  margin-right: 30px;
	}
	.nav-link {
	  border-bottom: 1px solid #888;
	  padding: 5px;
	  font-size: 25px;
	  margin-bottom: 20px;
	  margin-top: 20px;
	}
</style>

</head>

<body>

  <div class="hero_area">
  
    <!-- header section strats -->
    <header class="header_section long_section px-0">
      <nav class="navbar navbar-expand-lg custom_nav-container ">
        <a class="navbar-brand" href="index.html" style="font-size: 25px;">
          <span>
            13 FRUITS
          </span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class=""> </span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <div class="d-flex mx-auto flex-column flex-lg-row align-items-center">
            <form class="form-inline">
				<input type="text" name="searchQuery" class="form-control" placeholder="Tìm kiếm sản phẩm" style="width: 500px; margin-right: 30px;">
				<div class="quote_btn-container">
		            <a href="">
		              <i class="fa fa-search" aria-hidden="true" style="font-size: 25px;"></i>
		            </a>
		          </div>
            </form>
          </div>
          <div class="quote_btn-container">
            <a href="" style="font-size: 25px;">
              <span>
                Login
              </span>
              <i class="fa fa-user" aria-hidden="true"></i>
              <i class="fa fa-shopping-cart" aria-hidden="true"></i>
            </a>
            
          </div>
        </div>
      </nav>
    </header>
    <!-- end header section -->
    
    <!-- slider section -->
    <section class="slider_section long_section">
      <div id="customCarousel" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container ">
              <div class="row">
                <div class="col-md-5">
                  <div class="detail-box">
                    <h1>
                      For All Your <br>
                      Furniture Needs
                    </h1>
                    
                  </div>
                </div>
                <div class="col-md-7">
                  <div class="img-box">
                    <img src="images/fruit-1.jfif" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="container ">
              <div class="row">
                <div class="col-md-5">
                  <div class="detail-box">
                    <h1>
                      For All Your <br>
                      Furniture Needs
                    </h1>
                    
                  </div>
                </div>
                <div class="col-md-7">
                  <div class="img-box">
                    <img src="images/fruit-2.jpg" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="container ">
              <div class="row">
                <div class="col-md-5">
                  <div class="detail-box">
                    <h1>
                      For All Your <br>
                      Furniture Needs
                    </h1>
                    
                  </div>
                </div>
                <div class="col-md-7">
                  <div class="img-box">
                    <img src="images/fruit-3.jpg" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <ol class="carousel-indicators">
          <li data-target="#customCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#customCarousel" data-slide-to="1"></li>
          <li data-target="#customCarousel" data-slide-to="2"></li>
        </ol>
      </div>
    </section>
    <!-- end slider section -->
  </div>
  
    <!-- about section -->

	  <section class="about_section layout_padding long_section">
	    <div class="container">
	      <div class="row">
	        <div class="col-md-6">
	          <div class="img-box">
	            <img src="images/about-img.png" alt="">
	          </div>
	        </div>
	        <div class="col-md-6">
	          <div class="detail-box">
	            <div class="heading_container">
	              <h2>
	                About Us
	              </h2>
	            </div>
	            <p>
	              ...
	            </p>
	            
	          </div>
	        </div>
	      </div>
	    </div>
	  </section>
	
	  <!-- end about section -->

  <!-- furniture section -->

  <section class="furniture_section layout_padding">
	<div class="container">
	  <div class="row">
	    <div class="col-lg-3 d-flex" style="margin-top: 40px; margin-left: -20px;">
	      <ul class="navbar-nav flex-column">
	        <li class="nav-item active">
	          <a class="nav-link" href="">Trái cây tươi <span class="sr-only">(current)</span></a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="">Trái cây sấy lạnh</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="">Giỏ quà</a>
	        </li>
	        
	      </ul>
	    </div>
	    <div class="col-lg-9">
	      <div class="row">
	      <c:forEach items="${listSP}" var="sp">
	        <div class="col-md-6">
	          <div class="box">
	            <div class="img-box">
	              <img src="images/chomchom.PNG" alt="">
	            </div>
	            <div class="detail-box">
	              <h5>
	                <c:out value="${sp.tenSP}" />
	              </h5>
	              <div class="price_box">
	                <h6 class="price_heading">
	                  <span>$</span> <c:out value="${sp.gia}" />
	                </h6>
	                <a href="">
	                  Buy Now
	                </a>
	              </div>
	            </div>
	            </c:forEach>
	          </div>
	        </div>
	        <div class="col-md-6">
	          <div class="box">
	            <div class="img-box">
	              <img src="images/xoai.PNG" alt="">
	            </div>
	            <div class="detail-box">
	              <h5>
	                Xoài cát Hòa Lộc
	              </h5>
	              <div class="price_box">
	                <h6 class="price_heading">
	                  <span>$</span> 200.00
	                </h6>
	                <a href="">
	                  Buy Now
	                </a>
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
	      <div class="row">
	        <div class="col-md-6">
	          <div class="box">
	            <div class="img-box">
	              <img src="images/thanhlong.PNG" alt="">
	            </div>
	            <div class="detail-box">
	              <h5>
	                Thanh Long
	              </h5>
	              <div class="price_box">
	                <h6 class="price_heading">
	                  <span>$</span> 100.00
	                </h6>
	                <a href="">
	                  Buy Now
	                </a>
	              </div>
	            </div>
	          </div>
	        </div>
	        <div class="col-md-6">
	          <div class="box">
	            <div class="img-box">
	              <img src="images/mangcut.PNG" alt="">
	            </div>
	            <div class="detail-box">
	              <h5>
	                Măng cụt
	              </h5>
	              <div class="price_box">
	                <h6 class="price_heading">
	                  <span>$</span> 200.00
	                </h6>
	                <a href="">
	                  Buy Now
	                </a>
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>
	  </section>
	
	  <!-- end furniture section -->

  

  <!-- start footer -->
  	
  <!-- end footer -->

  <!-- jQery -->
  <script src="js/jquery-3.4.1.min.js"></script>
  <!-- bootstrap js -->
  <script src="js/bootstrap.js"></script>
  <!-- custom js -->
  <script src="js/custom.js"></script>
</body>

</html>