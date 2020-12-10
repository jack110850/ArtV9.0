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
			<h3 align="center" style="margin-top: 20px;">更新藝文商店</h3>
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
				action="<c:url value = "/03/front/shop/updateShop.ctrl"/>">
				<table id="03"
					class="display table table-bordered table-hover table-blue">
					<thead></thead>
					<tbody>
						<c:if test="${acShopsList != null}">
							<c:forEach items="${acShopsList}" var="acShopsList"
								varStatus="vs">
								<tr>
									<td>商店編號</td>
									<td><input type="hidden" name="shopId" required="required"
										value="${acShopsList.shopId}">${acShopsList.shopId}</td>
									<td></td>
								</tr>
								<tr>
									<td>會員帳號</td>
									<td><input type="hidden" name="memberId"
										required="required" value="${acShopsList.memberId}">${acShopsList.memberId}</td>
									<td></td>
								</tr>
								<tr>
									<td>商店名稱*</td>
									<td><input type="text" placeholder="請輸入商店名稱 "
										name="shopName" required="required"
										value="${acShopsList.shopName}"></td>
									<td></td>
								</tr>
								<tr>
									<td>代表圖示 (icon)*</td>
									<td><input type="text" placeholder="請輸入圖片網址" name="image"
										value="${acShopsList.image}" required="required"></td>
									<td></td>
								</tr>
								<tr>
									<td>簡介*</td>
									<td><textarea placeholder="請輸入簡介內容" name="intro"
											style="width: 400px; height: 70px;" required="required">${acShopsList.intro}</textarea></td>
									<td style="width: 200px;"></td>
								</tr>
								<!-- ====================================================== -->
								<tr>
									<td>縣市名*</td>
									<td><input type="text" placeholder="請輸入縣市名"
										name="cityName" required="required"
										value="${acShopsList.cityName}"></td>
									<td>範例:台北市</td>
								</tr>
								<tr>
									<td>地址*</td>
									<td><input type="text" placeholder="請輸入地址" name="address"
										required="required" value="${acShopsList.address}"></td>
									<td>範例:臺北市信義區市府路45號</td>
								</tr>
								<tr>
									<td>營業時間*</td>
									<td><input type="text" placeholder="請輸入營業時間"
										name="openTime" required="required"
										value="${acShopsList.openTime}"></td>
									<td>無格式要求</td>
								</tr>
								<tr>
									<td>連絡電話*</td>
									<td><input type="text" placeholder="請輸入連絡電話" name="phone"
										required="required" value="${acShopsList.phone}"></td>
									<td>無格式要求</td>
								</tr>
								<tr>
									<td>電子郵件*</td>
									<td><input type="text" placeholder="請輸入電子郵件" name="email"
										required="required" value="${acShopsList.email}"></td>
									<td></td>
								</tr>
								<tr>
									<td>傳真號碼</td>
									<td><input type="text" placeholder="請輸入傳真號碼" name="fax"
										value="${acShopsList.fax}"></td>
									<td></td>
								</tr>

								<!-- ====================================================== -->

								<tr>
									<td>Facebook連結網址</td>
									<td><input type="text" placeholder="請輸入facebook 網址"
										name="facebook" value="${acShopsList.facebook}"></td>
									<td></td>
								</tr>
								<tr>
									<td>商店網站連結網址</td>
									<td><input type="text" placeholder="請輸入網址" name="website"
										value="${acShopsList.website}"></td>
									<td></td>
								</tr>
								<tr>
									<td>點擊次數</td>
									<td><input type="text" placeholder="請輸入點擊次數" name="clicks"
										value="${acShopsList.clicks}"></td>
									<td></td>
								</tr>
								<tr>
									<td>是否允許使用預約系統</td>
									<td><select name="reservation" required="required">
											<option selected value="0">否</option>
											<option value="1">是</option>
									</select></td>
									<td></td>
								</tr>
								<!-- ====================================================== -->
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<br>
				<c:if test="${acShopsSerachMsg != null}">
					<div align="center" style="font-size: larger">${acShopsSerachMsg}</div>
					<br>
				</c:if>
				<div class="submitButton" align="center" style="font-size: larger">
					<input type="submit" name="submit" value="更新商店">
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