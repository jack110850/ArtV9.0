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
.ellipsis {
	/* 行數設定 */
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 5;
	-webkit-box-orient: vertical;
	white-space: normal;
}
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
						<a href="<c:url value='/03/index/shop/index.ctrl' />">
							Creative Shop</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<div class="container">
		<br>
		<div class=title>
			<h3 align="center" style="margin-top: 20px;">藝文商店詳細資訊</h3>
		</div>
		<br>
		<!-- 		<div class="back" align="right"> -->
		<!-- 		</div> -->
		<br>
		<div class=content>
			<table id="03"
				class="display table table-bordered table-hover table-blue">
				<thead></thead>
				<tfoot></tfoot>
				<tbody>
					<tr>
						<td>商店編號</td>
						<td>${shop.shopId}</td>
					</tr>
					<tr>
						<td>商店名稱</td>
						<td>${shop.shopName}</td>
					</tr>
					<tr>
						<td>會員帳號</td>
						<td>${shop.memberId}</td>
					</tr>
					<tr>
						<td>代表圖示 (icon)</td>
						<td>${shop.image}</td>
					</tr>
					<tr>
						<td>簡介</td>
						<td>${shop.intro}</td>
					</tr>

					<!-- ====================================================== -->

					<tr>
						<td>縣市名</td>
						<td>${shop.cityName}</td>
					</tr>
					<tr>
						<td>地址</td>
						<td>${shop.address}</td>
					</tr>
					<tr>
						<td>營業時間</td>
						<td>${shop.openTime}</td>
					</tr>
					<tr>
						<td>連絡電話</td>
						<td>${shop.phone}</td>
					</tr>
					<tr>
						<td>傳真號碼</td>
						<td>${shop.fax}</td>
					</tr>

					<!-- ====================================================== -->

					<tr>
						<td>電子郵件</td>
						<td>${shop.email}</td>
					</tr>
					<tr>
						<td>Facebook連結網址</td>
						<td>${shop.facebook}</td>
						<td></td>
					</tr>
					<tr>
						<td>商店網站連結網址</td>
						<td>${shop.website}</td>
					</tr>
					<tr>
						<td><span class="lnr lnr-heart"></span> 熱門度</td>
						<td>${shop.clicks}</td>
					</tr>
					<tr>
						<td>是否使用預約系統</td>
						<td><div id="result"></div></td>
					</tr>
					<tr style="display: none">
						<td><input type="hidden" name="reservation" id="reservation"
							value="${shop.reservation}"></td>
					</tr>
					<!-- ====================================================== -->
				</tbody>
			</table>
			<br>
			<form method="post"
				action="<c:url value="/03/front/reservation/createReservationDate.ctrl"/>">
				<button name="reserveButton" type="submit">預約</button>
				<Input type="hidden" name="memberId" value="${sessionScope.member.id}"> 
				<Input type="hidden" name="memberName" value="${sessionScope.member.name}"> 
				<Input type="hidden" name="shopId" value="${shop.shopId}">
				<Input type="hidden" name="shopName" value="${shop.shopName}">
				<Input type="hidden" name="intro" value="${shop.intro}">
			</form>
			<c:if test="${acShopsSerachMsg != null}">
				<div align="center" style="font-size: larger">${acShopsSerachMsg}</div>
				<br>
			</c:if>
			<br>
		</div>
	</div>
</body>
<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03').DataTable({});
	});

	window.onload = function() {
		var reservation = document.getElementById("reservation").value;
		if (reservation == 0) {
			var content = "不使用預約系統";
		} else {
			var content = "使用預約系統";
		}
		var result = document.getElementById("result");
		result.innerHTML = content;
	}
</script>