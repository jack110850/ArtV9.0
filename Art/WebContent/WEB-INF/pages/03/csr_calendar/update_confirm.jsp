<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<br>
	<div class=title>
		<h3 align="center" style="margin-top: 20px;">更新行事曆</h3>
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
		<form method="post"
			action="<c:url value = "/03/csr/calendar/createCalendar.ctrl"/>">
			<table id="03A"
				class="display table table-bordered table-hover table-blue">
				<thead>
				</thead>
				<tbody>
					<tr style="display: none">
						<td>會員帳號:</td>
						<td><input type="hidden" name="memberId"
							value="${calendarList[0].day}"></td>
						<td></td>
					</tr>
					<tr style="display: none">
						<td>商店代號:</td>
						<td><input type="hidden" name="shopId"
							value="${calendarList[0].shopId}"></td>
						<td style="width: 200px;"></td>
					</tr>
					<tr style="font-size: large;">
						<td>商店名稱:</td>
						<td><input type="hidden" name="shopName"
							value="${calendarList[0].shopName}">${calendarList[0].shopName}</td>
						<td></td>
					</tr>
					<tr style="display: none">
						<td><input type="hidden" name="year"
							value="${calendarList[0].year}"></td>
					</tr>
					<tr style="display: none">
						<td><input type="hidden" name="month"
							value="${calendarList[0].month}"></td>
					</tr>
			</table>
			<br>
			<!-- ====================================================== -->
			<div align="center" style="font-size: large;">${calendarList[0].year}年
				${calendarList[0].month}月</div>
			<br>
			<table id="03B"
				class="display table table-bordered table-hover table-blue">
				<thead>
					<tr>
						<th>日期</th>
						<th>當日預約許可</th>
						<th>最大預約人數</th>
						<th>營業開始時間</th>
						<th>營業結束時間</th>
						<th>備註</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${calendarList}" var="calendarList"
						varStatus="vs">
						<tr>
							<td><input type="hidden" name="day"
								value="${calendarList.day}">${calendarList.day}</td>
							<td><select name="permission">
									<optgroup label="請設定預約許可">
										<option value="${calendarList.permission}" selected>先前設定</option>
										<option value="0">不可預約</option>
										<option value="1">可預約</option>
									</optgroup>
							</select></td>
							<td><input type="number" name="maximum" min="1" max="100"
								value="${calendarList.maximum}" step="1" required></td>

							<td><input type="time" name="startTime" min="00:00"
								value="${calendarList.startTime}" max="24:00" required></td>

							<td><input type="time" name="endTime" min="00:00"
								value="${calendarList.endTime}" max="24:00" required></td>

							<td><textarea placeholder="備註內容最多150字，可不填寫" name="note"
									maxlength="150" style="width: 400px; height: 70px;">${calendarList.note}</textarea></td>

							<td style="display: none"><input type="hidden"
								name="calendarNo" value="${calendarList.calendarNo}"></td>
							<td style="display: none"><input type="hidden"
								name="dateTime" value="${calendarList.dateTime}"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- ====================================================== -->
			<br>
			<div class="submitButton" align="center" style="font-size: larger">
				<input type="submit" name="submit" value="資料送出">
			</div>
			<br>
		</form>
	</div>
</div>
<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03A').DataTable({});
		$('#03B').DataTable({});
	});
</script>