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
				action="<c:url value = "/03/front/reservation/createReservationConfirm.ctrl"/>">
				<table id="03"
					class="display table table-bordered table-hover table-blue">
					<thead></thead>
					<tfoot></tfoot>
					<tbody>
						<tr style="display: none">
						<tr>
							<td>會員帳號:</td>
							<td><input type="hidden" name="memberId" value="${memberId}">${memberId}</td>
						</tr>
						<tr>
							<td>會員姓名:</td>
							<td><input type="hidden" name="memberName"
								value="${memberName}">${memberName}</td>
						</tr>
						<tr>
							<td>商店代號:</td>
							<td><input type="hidden" name="shopId" value="${shopId}">${shopId}</td>
						</tr>
						<tr>
							<td>商店名稱:</td>
							<td><input type="hidden" name="shopName" value="${shopName}">${shopName}</td>
						</tr>
						<tr>
							<td>商店簡介:</td>
							<td><input type="hidden" name="shopName" value="${intro}">${intro}</td>
						</tr>
					</tbody>
				</table>
				<br>
				<!-- ====================================================== -->
				<table>
					<thead></thead>
					<tbody>
						<tr>
							<td>預約日期:</td>
							<td><input type="date" name="dateTime" id="dateTime"
								value="2020-12-25" min="2020-12-25" max="2020-1-24"
								required="required"></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<br>
				<div class="submitButton" align="center" style="font-size: larger">
					<input type="submit" name="submit" value="下一步">
				</div>
				<br>
			</form>
		</div>
	</div>
</body>
<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03').DataTable({});
	});
</script>