<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<table id="03"
			class="display table table-bordered table-hover table-blue">
			<thead>
				<tr class="head">
					<th scope="col">商店代號</th>
					<th scope="col">商店名稱</th>
					<th scope="col">地址</th>
					<th scope="col">連絡電話</th>
					<th scope="col">電子郵件</th>
					<!-- ===================== -->
					<th scope="col">預約</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${acShopsList != null}">
					<c:forEach items="${acShopsList}" var="acShopsList" varStatus="vs">
						<tr>
							<td>${acShopsList.shopId}</td>
							<td>${acShopsList.shopName}</td>
							<td>${acShopsList.address}</td>
							<td>${acShopsList.phone}</td>
							<td>${acShopsList.email}</td>
							<!-- 	======================= -->
							<td>
								<form method="post"
									action="<c:url value="/03/csr/reservation/createReservationDate.ctrl"/>">
									<button name="reserveButton" type="submit">預約</button>
									<Input type="hidden" name="memberId" value="${sessionScope.member.id}"> 
									<Input type="hidden" name="memberName" value="${sessionScope.member.name}"> 
									<Input type="hidden" name="shopId" value="${acShopsList.shopId}"> 
									<Input type="hidden" name="shopName" value="${acShopsList.shopName}">
									<Input type="hidden" name="intro" value="${acShopsList.intro}">
								</form>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
			<tfoot></tfoot>
		</table>
		<br>
		<c:if test="${acShopsSerachMsg != null}">
			<div align="center" style="font-size: larger">${acShopsSerachMsg}</div>
		</c:if>
	</div>
</div>
<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03').DataTable({});
	});
</script>
