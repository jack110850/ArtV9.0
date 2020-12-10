<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<br>
	<div class=title>
		<h3 align="center" style="margin-top: 20px;">行事曆管理</h3>
	</div>
	<div class="back" align="right">
		<form action="<c:url value='/03/cms/calendar/index.ctrl'/> "
			method="post">
			<div class="submitButton">
				<input type="submit" class="" name="submit" value="返回 預約行事曆管理">
			</div>
		</form>
	</div>
	<br>
	<div class=content>
		<table id="03A"
			class="display table table-bordered table-hover table-blue">
			<thead>
				<tr class="head">
					<th scope="col" >商店代號</th>
					<th scope="col" >商店名稱</th>
					<th scope="col" >簡介</th>
					<th scope="col" >地址</th>
					<th scope="col" >連絡電話</th>
					<th scope="col" >電子郵件</th>
					<th scope="col" >商店網頁網址</th>
				</tr>
			</thead>
			<tfoot></tfoot>
			<tbody>
				<tr>
					<td>${shop.shopId}</td>
					<td>${shop.shopName}</td>
					<td>${shop.intro}</td>
					<td>${shop.address}</td>
					<td>${shop.phone}</td>
					<td>${shop.email}</td>
					<td>${shop.website}</td>
				</tr>
		</table>
		<br>
		<c:if test="${acShopsSerachMsg != null}">
			<div align="center" style="font-size: larger">${acShopsSerachMsg}</div>
			<br>
		</c:if>
		<form method="post"
			action="<c:url value = "/03/cms/calendar/searchByYearMonth.ctrl"/>"
			>
			<table id="03B"
				class="display table table-bordered table-hover table-blue">
				<thead>
				</thead>
				<tbody>
					<tr>
						<td>請選擇年份:</td>
						<td><select id="year" name="year" required="required">
								<option selected value="2020">2020年</option>
								<option value="2021">2021年</option>
						</select></td>
						<td>請選擇月份:</td>
						<td><select id="month" name="month" required="required">
								<option value="01">1月</option>
								<option value="02">2月</option>
								<option value="03">3月</option>
								<option value="04">4月</option>
								<option value="05">5月</option>
								<option value="06">6月</option>
								<option value="07">7月</option>
								<option value="08">8月</option>
								<option value="09">9月</option>
								<option value="10">10月</option>
								<option value="11">11月</option>
								<option selected value="12">12月</option>
						</select></td>
						<td style="display: none"><input type="hidden" id="shopId" name="shopId"
							value="${shop.shopId}"></td>
						<td style="display: none"><input type="hidden" id="shopName" name="shopName"
							value="${shop.shopName}"></td>
						<td style="display: none"><input type="hidden" id="memberId" name="memberId"
							value="${shop.memberId}"></td>
						<td><input id='btn' type="button" value="查詢"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<br>
	<div class=content id="result"></div>
</div>


<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03A').DataTable({});
		$('#03B').DataTable({});
	});

	window.onload = function(){ 
		var btn = document.getElementById("btn"); //按鈕的事件處理函數

		btn.onclick = function(){
			var shopId = document.getElementById("shopId").value;
			var shopName = document.getElementById("shopName").value;
			var memberId = document.getElementById("memberId").value;
			var year = document.getElementById("year").value;
			var month = document.getElementById("month").value;
			var xhr = new XMLHttpRequest();
			
			xhr.open("POST","<c:url value='/03/cms/calendar/searchByYearMonth.ctrl' />",true);

			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xhr.send("shopId=" + shopId + "&year=" + year + "&month=" + month);

			xhr.onreadystatechange = function() {
				// 向伺服器提出的請求已經收到回應
				if (xhr.readyState == 4 && xhr.status == 200) {
					// status: HTTP通訊協定的狀態碼伺服器，
					// 200表示Server成功的處理請求
					// getResponseHeader: 取得回應內容的MIME Type

					var calendarList = JSON.parse(xhr.responseText);
					console.log("calendarList");
					console.log(calendarList);
					
					// 假如有預約資料
					if (calendarList.length > 0) {
						console.log("calendarList > 0");
						// 插入刪除預約的 From 表單
						var content = "<form method='post' action='<c:url value='/03/cms/calendar/deleteCalendar.ctrl'/>'><table id='03C' class='display table table-bordered table-hover table-blue'>";
						content += "<thead><tr><th>日期</th><th>當日預約許可</th><th>最大預約人數</th><th>營業開始時間</th><th>營業結束時間</th><th>備註</th></tr></thead><tbody>";

						// 迴圈印出預約資料
						for (var i = 0; i < calendarList.length; i++) {
							if (calendarList[i].permission == 0) {
								var p = "不可預約"
							} else {
								var p = "可預約";
							}

							content += "<tr><td>"
									+ calendarList[i].day
									+ "</td>"
									+ "<td>"
									+ p
									+ "</td>"
									+ "<td>"
									+ calendarList[i].maximum
									+ "人</td>"
									+ "<td>"
									+ calendarList[i].startTime
									+ "</td>"
									+ "<td>"
									+ calendarList[i].endTime
									+ "</td>"
									+ "<td><textarea style='width: 450px; height: 70px;'>"
									+ calendarList[i].note
									+ "</textarea></td> "
									+ "<td>"
									+ "<Input type='hidden' name='calendarNo' value=" + calendarList[i].calendarNo +">"
									+ "</td></tr>";
						}
						content += "</tbody></table><br><div class='submitButton'><button name='deleteButton' type='submit'>刪除行事曆</button></div></form><br>";

						// 插入更新預約的 From 表單
						content += "<div><form method='post' action='<c:url value='/03/cms/calendar/updateCalendarConfirm.ctrl'/>'> ";
						// 預約編號的迴圈
						for (var i = 0; i < calendarList.length; i++) {
							content += "<Input type='hidden' name='calendarNo' value=" + calendarList[i].calendarNo +">";
						}
						content += "<button name='updateButton' type='submit'>修改行事曆</button>"
								+ "</form></div>";
						var result = document.getElementById("result");
						result.innerHTML = content;
					} else {
						// 假如沒有預約資料
						// 新增的 From
						console.log("calendarList = 0");
						var content = "<form method='post' action='<c:url value='/03/cms/calendar/createCalendarConfirm.ctrl'/>' > "
								+ "<div>查無行事曆資料</div><br>"
								+ "<div class='submitButton'> "
								+ "<Input type='hidden' name='shopId' value=" + shopId +">"
								+ "<Input type='hidden' name='shopName' value=" + shopName +">"
								+ "<Input type='hidden' name='memberId' value=" + memberId +">"
								+ "<Input type='hidden' name='year' value=" + year +">"
								+ "<Input type='hidden' name='month' value=" + month +">"
								+ "<input type='submit' name='submit' value='建立預約行事曆'> "
								+ "</form></div> "
						var result = document.getElementById("result");
						result.innerHTML = content;
					}
				}
			}
		}
	}
</script>