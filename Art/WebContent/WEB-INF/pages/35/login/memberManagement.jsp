<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資訊管理</title>
<style>
.post {
	display: none;
}
</style>
</head>
<body>
	<br>
	<div class="title">
		<h1 align="center">會員資料列表</h1>
	</div>
	<div class="back" align="right">
		<form action="<c:url value='/35/returnHomePageF'/> " method="get">
			<div class="submitButton">
				<input type="submit" class="" name="submit" value="返回後台管理系統首頁">
			</div>
		</form>
	</div>
	<br>
	<div class="add" align="right">
		<input type="button" value="新增會員資料" onclick="add()">
		<div class="post">
			<table class="display table">
				<thead>
					<tr>
						<th class="table-secondary">名稱</th>
						<th class="table-warning">地址</th>
						<th class="table-light">E-mail</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class=""><input type="text" id="name"></td>
						<td class=""><input type="text" id="address"></td>
						<td class=""><input type="text" id="email"></td>
					</tr>
				</tbody>
			</table>
			<table class="display table">
				<thead>
					<tr>
						<th class="table-secondary">電話</th>
						<th class="table-success">會員類型</th>
						<th class="table-primary">偏好</th>
						<th class="table-danger">購買上限</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class=""><input type="text" id="tel"></td>
						<td class=""><input type="text" id="memberType"></td>
						<td class=""><input type="text" id="preference"></td>
						<td class=""><input type="text" id="purchaseLimit"></td>
					</tr>
					<tr>
						<td><input type="button" value="確認新增" onclick="post()"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div align="center">
		<h2 id="insertResult"></h2>
		<br>
	</div>
	<div align="center">
		<h2 id="deleteResult"></h2>
		<br>
	</div>
	<div align="center">
		<div class="submitButton">
			<label>輸入會員名稱查詢</label> 
			<input type="text" name="select" id="singleQuery" value="123">
			<input type="button" value="送出" onclick="get(singleQuery)">
		</div>
	</div>
	<br>
	<div class="content">
		<table id="35"
			class="display table table-bordered table-hover table-blue">
			<thead>
				<tr class="">
					<th class="table-secondary">名稱</th>
					<th class="table-warning">地址</th>
					<th class="table-light">E-mail</th>
					<th class="table-secondary">電話</th>
					<th class="table-success">會員類型</th>
					<th class="table-danger">個人照片</th>
					<th class="table-primary">偏好</th>
					<th class="table-info">註冊日期</th>
					<th class="table-danger">購買上限</th>
					<th class="table-info">修改會員資訊</th>
					<th class="table-success">刪除此會員</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="counter" value="0" />
				<c:forEach var="list" items="${membersList}">
					<c:set var="counter" value="${counter+1}" />
					<tr>
						<td class="">${list.name}</td>
						<td class="">${list.address}</td>
						<td class="">${list.email}</td>
						<td class="">${list.tel}</td>
						<td class="">${list.memberType}</td>
						<td class="">${list.memberPic}</td>
						<td class="">${list.preference}</td>
						<td class="">${list.registerTime}</td>
						<td class="">${list.purchaseLimit}</td>
						<td class="update">
							<div>
								<input type="button" value="修改" id="${list.name}" onclick="put(this.id)">
							</div>
						</td>
						<td class="delete">
							<div>
								<input type="button" value="刪除" id="${list.name}" onclick="delete(this.id)">
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
$(document).ready( function () {
    $('#35').DataTable( {
        scrollY: 400
    } );
});

let postDiv = document.querySelector(".post");
	
let add = () =>{
	postDiv.style.display= "block";
}

let singleQuery = document.getElementById("singleQuery").value;
let get = (singleQuery) => {
	console.log(singleQuery);
}

let post = () => {
	let name = document.getElementById("name").value;
	let address = document.getElementById("address").value;
	let email = document.getElementById("email").value;
	let tel = document.getElementById("tel").value;
	let memberType = document.getElementById("memberType").value;
	let preference = document.getElementById("preference").value;
	let purchaseLimit = document.getElementById("purchaseLimit").value;
	let jsonMember = {
			"name": name, 					
			"address": address, 	
			"email": email,
			"tel": tel,
			"memberType": memberType,
			"preference": preference,
			"purchaseLimit": purchaseLimit
   		}
	postDiv.style.display= "none";
	fetch("<c:url value='/35/members.ctrl' />", {
		method:"post",
		headers : {
     		'Content-Type' : 'application/json; charset=UTF-8'
 		},
//  	物件變json
		body: JSON.stringify(jsonMember)
		}
	).then(
		response => {
			if (response.ok){
				response.json().then(
					object => {
						
						if(object.hasOwnProperty('success')){
							document.getElementById("insertResult").innerText= "新增成功";
						}else {
							document.getElementById("insertResult").innerText= "新增失敗";
						}
						setTimeout(() => {
							window.location.reload();
						}, 500);
					}
				).catch();
			}
			document.getElementById("insertResult").innerText= "新增失敗";
			setTimeout(() => {
				window.location.reload();
			}, 500);
		}
	).catch();
	
}

// let put = (name) => {
	
// }

// let delete = (name) => {
	
// }
</script>
</body>
</html>