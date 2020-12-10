<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my reservation</title>
<style>
/* p, div { */

/* } */
</style>

</head>
<body>

	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">AAART Shop</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="<c:url value='/14/shopListController.ctrl' />"> Shop</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<div class="container">
		<br>
		<div class=title>
			<h3 align="center" style="margin-top: 20px;">預約商店</h3>
		</div>
		<br>
		<div class="back" align="right">
			<form action="<c:url value='/index.html'/> " method="get">
				<div class="submitButton">
					<input type="submit" class="" name="submit" value="返回 會員專區">
				</div>
			</form>
		</div>
		<br>
		<div class=content>
			<form method="post"
				action="<c:url value="/03/csr/reservation/searchShopByShopName.ctrl"/>">
				<table id="03A"
					class="display table table-bordered table-hover table-blue">
					<thead>
						<tr>
							<th>搜尋可預約藝文商店</th>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" placeholder="請輸入商店名稱 "
								name="shopName"></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</form>
			<br>
			<form method="post"
				action="<c:url value="/03/csr/reservation/searchAllShops.ctrl"/>">
				<table id="03B"
					class="display table table-bordered table-hover table-blue">
					<thead>
						<tr>
							<th>查詢所有可預約藝文商店</th>
					</thead>
					<tbody>
						<tr>
							<td>
								<button name="searchButton" type="submit">查詢</button>
							</td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03A').DataTable({});
		$('#03B').DataTable({});
	});
</script>