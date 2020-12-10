<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<br>
	<div class=title>
		<h3 align="center" style="margin-top: 20px;">行事曆管理</h3>
	</div>
	<br>
	<div class="back" align="right">
		<form action="<c:url value='/03/csr/calendar/myCalendar.ctrl'/> "
			method="post">
			<div class="submitButton">
				<input type="submit" class="" name="submit" value="返回 我的商店行事曆">
			</div>
		</form>
	</div>
	<br>
	<div class=content>
		<table id="03B"
			class="display table table-bordered table-hover table-blue">
			<thead></thead>
			<tbody>
				<tr class="head">
					<th scope="col">商店代號</th>
					<th scope="col">商店名稱</th>
					<th scope="col">地址</th>
					<th scope="col">連絡電話</th>
					<th scope="col">電子郵件</th>
					<!-- ===================== -->
					<th scope="col">行事曆管理</th>
				</tr>
				<c:if test="${acShopsList != null}">
					<c:forEach items="${acShopsList}" var="acShopsList" varStatus="vs">
						<tr>
							<td>${acShopsList.shopId}</td>
							<td>${acShopsList.shopName}</td>
							<td>${acShopsList.address}</td>
							<td>${acShopsList.phone}</td>
							<td>${acShopsList.email}</td>
							<!-- ======================= -->
							<td>
								<form method="post"
									action="<c:url value="/03/csr/calendar/calendarManagement.ctrl"/>">
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
<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03').DataTable({});
	});
</script>