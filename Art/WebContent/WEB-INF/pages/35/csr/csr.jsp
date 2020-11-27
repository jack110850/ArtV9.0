<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
   <HEAD>
      <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8"/>
      <TITLE>CSR</TITLE>
      <style>
      h1, form {
      	text-align:center
      }
      </style>
   </HEAD>
<BODY BGCOLOR="#FFFFFF">
	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">企業租借場地與贊助</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/35/csr' />">企業租借場地與贊助</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
<c:set var="funcName" value="CSR" scope="session"/>
	<br>
	<H1>贊助偏鄉孩童參加藝文活動</H1>
	<br>
 	<form action="<c:url value='/35/founding.ctrl'/> " method="get">
		<div class="searchBox">
			<input type="text" class="" name="kidsLocation" value="">
		</div>
    	<br>
		<div class="submitButton">
			<input type="submit" class="" name="submit" value="以地點搜尋有媒合需求的偏鄉孩童"> 
		</div>
	</form>
</BODY>
</HTML>