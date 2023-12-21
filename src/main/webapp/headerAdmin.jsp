<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>
<%@ page session="true" %>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style><%@include file="/css/headerAdmin.css"%></style>

</head>

<!-- HEADER -->
<section>
	<nav class="navbar navbar-expand-lg px-0 py-3">
	  <div class="container-fluid">
	    <p class="navbar-brand">13Fruits</p>
	    <div class="collapse navbar-collapse" id="navbarNav">
          <a class="nav-link" aria-current="page" href="<%=request.getContextPath()%>/TrangChuAdminController">Home</a>
          <a class="nav-link" href="<%=request.getContextPath()%>/logout">Đăng xuất</a>
          <a class="nav-link disable" aria-disabled="true">ADMIN</a>
	    </div>
	  </div>
	</nav>
</section>
<!-- Header -->