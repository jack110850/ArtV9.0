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
			<h3 align="center" style="margin-top: 20px;">我的商店行事曆</h3>
		</div>
		<br>
<!-- 		<div class="back" align="right"> -->
<%-- 			<form action="<c:url value='/index.html'/> " method="get"> --%>
<!-- 				<div class="submitButton"> -->
<!-- 					<input type="submit" class="" name="submit" value="返回 會員專區"> -->
<!-- 				</div> -->
<!-- 			</form> -->
<!-- 		</div> -->
<!-- 		<br> -->
		<div class=content>
			<form method="post"
				action="<c:url value="/03/front/calendar/searchShopByShopNameAndReservation.ctrl"/>">
				<div class="submitButton">
					商店搜尋: <input type="text" placeholder="請輸入藝文商店名稱 " name="shopName"><input
						type="submit" name="submit" value="查詢">
				</div>
				<br>
			</form>
		</div>
		<br>
		<div class=content>
			<table id="03"
				class="display table table-bordered table-hover table-blue">
				<thead>
					<tr class="head">
						<th scope="col" width="150px">商店代號</th>
						<th scope="col" width="150px">商店名稱</th>
						<th scope="col" width="150px">商店地址</th>
						<th scope="col" width="150px">連絡電話</th>
						<th scope="col" width="150px">行事曆</th>
					</tr>
				</thead>
				<tfoot></tfoot>
				<tbody>
					<c:if test="${acShopsList != null}">
						<c:forEach items="${acShopsList}" var="acShopsList" varStatus="vs">
							<tr>
								<td>${acShopsList.shopId}</td>
								<td>${acShopsList.shopName}</td>
								<td>${acShopsList.address}</td>
								<td>${acShopsList.phone}</td>
								<td>
									<form method="post"
										action="<c:url value="/03/front/calendar/calendarManagement.ctrl"/>">
										<button name="deleteButton" type="submit">行事曆管理</button>
										<Input type="hidden" name="shopId"
											value="${acShopsList.shopId}">
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<br>
			<c:if test="${acShopsSerachMsg != null}">
				<div align="center" style="font-size: larger">${acShopsSerachMsg}</div>
			</c:if>
		</div>
	</div>
</body>
<!-- ====================================================== -->
<script>
// 	$(document).ready(function() {
// 		$('#03').DataTable({});
// 	});
</script>