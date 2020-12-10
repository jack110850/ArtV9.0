<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="<c:url value="/18/cUpdate.ctrl"/>" method="POST" enctype="multipart/form-data">
	<div class="form-row" style="text-align: center;">
		<div class="form-group">
			<label>課程編號</label> <input type="text" class="form-control"
				name="coId" value="${coId}">
		</div>
		<div class="form-group">
			<label>課程名稱</label> <input type="text" class="form-control"
				name="coTitle" value="${coTitle}">
		</div>
		<div class="form-group">
			<label>上課地址</label> <input type="text" class="form-control"
				name="coAct_Location" value="${coAct_Location}">
		</div>
		<div class="form-group">
			<label>場地名稱</label> <input type="text" class="form-control"
				name="coLocation_Name" value="${coLocation_Name}">
		</div>
		<div class="form-group">
			<label>課程售價</label> <input type="text" class="form-control"
				name="coPrice" value="${coPrice}">
		</div>
		<div class="form-group">
			<label>開始時間</label> <input type="text" class="form-control"
				name="coAct_Time" value="${coAct_Time}">
		</div>
		<div class="form-group">
			<label>結束時間</label> <input type="text" class="form-control"
				name="coEnd_Time" value="${coEnd_Time}">
		</div>
		<div class="form-group">
			<label>簡介說明</label> <input type="text" class="form-control"
				name="coAct_Description" value="${coAct_Description}">
		</div>
		<div class="form-group">
			<label>名額</label> <input type="text" class="form-control"
				name="coNum" value="${coNum}">
		</div>
		<div class="form-group">
			<label>課程圖片</label> <input type="file" accept="image/*"
				onchange="loadFile(event)" class="form-control" name="coAct_Image"
				value="${coAct_Image}"> <img id="output" />
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