<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>請輸入欲新增的課程資訊</div>
<form action="<c:url value="/18/cInsert.ctrl"/>" method="POST"
	enctype="multipart/form-data">
	<div class="form-row" style="text-align: center;">


		<div class="form-group">
			<label>課程名稱</label> <input type="text" class="form-control"
				name="coTitle" value="國畫L2-彩墨山水(中級)">
		</div>

		<div class="form-group">
			<label>課程類型</label>
			<p>
				<select name="coAct_Type">
					<option value="">國畫書法</option>
					<option value="languages">語文</option>
					<option value="gardening">園藝</option>
					<option value="culture">風俗信仰</option>
					<option value="handmade">手工製作</option>
					<option value="calligraphy">國畫書法</option>
					<option value="sports">運動</option>
					<option value="appreciation">藝術鑑賞</option>
					<option value="arts">美術</option>
					<option value="drama">戲劇</option>
				</select>
			</p>
		</div>

		<div class="form-group">

			<label>上課地址</label> <input type="text" class="form-control"
				name="coAct_Location" value="臺北市中正區中山南路21號">
		</div>

		<div class="form-group">
			<label>場地名稱</label> <input type="text" class="form-control"
				name="coLocation_Name" value="國立中正紀念堂 W314教室">
		</div>

		<div class="form-group">
			<label>售價</label> <input type="number" class="form-control"
				name="coPrice" value="2400">
		</div>

		<div class="form-group">
			<label>開始日期</label> <input type="Date" class="form-control"
				name="coAct_Date" value="2021-01-01">
		</div>

		<div class="form-group">
			<label>開始時間</label> <input type="time" class="form-control"
				name="coAct_Time" value="09:00">
		</div>

		<div class="form-group">
			<label>結束日期</label> <input type="Date" class="form-control"
				name="coEnd_Date" value="2021-01-31">
		</div>

		<div class="form-group">
			<label>結束時間</label> <input type="time" class="form-control"
				name="coEnd_Time" value="16:30">
		</div>

		<div class="form-group">
			<label>簡介說明</label>
			<textarea id="te" name="coAct_Description" rows="4" cols="50">山石變化多端，取勢聚合，穿插、用筆、用墨皆表現不同之精神與趣味。山石靜態，因有浮雲流水方顯生命，雲水型態因自然條件不同各有所異，勾、染、留白…各種技法交互運用。</textarea>		
		</div>
		
		<div class="form-group">
			<label>名額</label> <input type="number" class="form-control"
				name="coNum" value="50">
		</div>

		<div class="form-group">
			<label>課程圖片</label> <input type="file" accept="image/*"
				onchange="loadFile(event)" class="form-control" name="coAct_Image">
			<img id="output" />
			<script>
				var loadFile = function(event) {
					var output = document.getElementById('output');
					output.src = URL.createObjectURL(event.target.files[0]);
					output.onload = function() {
						URL.revokeObjectURL(output.src)
					}
				};
			</script>
		</div>

	</div>

	<button type="submit" class="btn btn-primary">送出</button>
</form>