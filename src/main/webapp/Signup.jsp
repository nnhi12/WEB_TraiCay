<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="css/style-login.css">
</head>
<body>

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
    <h1>SIGN UP</h1>
    <!-- Login Form -->
    <form>
    <div class="thongtindangky">
	  <div>
	    <input type="text" id="username" class="fadeIn second" name="login" placeholder="Username">
	    <input type="text" id="password" class="fadeIn second" name="login" placeholder="Password">
	  </div>
	  <div>
	    <input type="text" id="name" class="fadeIn second" name="login" placeholder="Name">
	    <input type="text" id="phone" class="fadeIn second" name="login" placeholder="Phone">
	  </div>
	  <div class="field-group">
	    <div class="field">
	    <label for="gender">Gender</label>
	      <select id="gender" class="fadeIn third" name="gender">
	        <option value="male">Male</option>
	        <option value="female">Female</option>
	      </select>
	    </div>
	    <div class="field">
	    <label for="dob">Birthday</label>
	      <input type="date" id="dob" class="fadeIn third" name="dob">
	    </div>
	  </div>
	  <input type="text" id="address" class="fadeIn fourth" name="login" placeholder="Address">
	  <input type="submit" class="fadeIn fourth" value="Sign Up">
	</div>
  
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <h7>Bạn đã có tài khoản? </h7><a class="underlineHover" href="#">Login</a>
    </div>

  </div>
</div>
    
</body>
</html>