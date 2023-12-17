<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="css/style-login.css">
</head>
<body>

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
    <h1>LOGIN</h1>
    <!-- Login Form -->
    <form>
      <input type="text" id="login" class="fadeIn second" name="login" placeholder="Username">
      <input type="text" id="password" class="fadeIn second" name="login" placeholder="Password">
      <input type="submit" class="fadeIn fourth" value="Log In">
      <br><a class="underlineHover" href="#">Forgot Password?</a>
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <h7>Bạn chưa có tài khoản? </h7><a class="underlineHover" href="#">Sign Up</a>
    </div>

  </div>
</div>
    
</body>
</html>