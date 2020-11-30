<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢離我最近的活動</title>
<style>
div {
	text-align: center;
}
</style>
</head>
<body>
	<br>
	<div>
		<h1>請輸入您的位置</h1>
		<br>
		<form action="<c:url value='/35/findNear.ctrl'/> " method="get">
			<div class="searchBox">
				<input type="text" name="userLocation" value="">
			</div>
			<BR>
			<div class="submitButton">
				<input type="submit" class="" name="submit" value="確認送出">
			</div>
		</form>
	</div>
	<br>
	<br>
	<div>
		<h1>猜您喜歡</h1>
	</div>
	<c:forEach var="recommend" items="${recommend}">
		<c:set var="addr"
			value="${recommend.city.concat(recommend.district).concat(recommend.address)}" />
		<h3>${recommend.title}</h3>
		<iframe width="100%" height="250" frameborder="0"
			src="https://www.google.com/maps?q=${addr}&output=embed"></iframe>
		<%-- 		${addr}前兩條斜線，中間是使用者位置 --%>
		<%-- 		<a href="https://www.google.com.tw/maps/dir//${addr}">導航網頁版</a> --%>
		<input type="button" onclick="navigate(this.id)" id="${addr}"
			value="幫我導航">
	</c:forEach>
	<script type="text/javascript">

// 	宣告一個名為navigete的箭頭函式，傳入參數是addr
// 	單一參數，參數括號可省略，命名是為了button onclick 要有function名稱
	let navigate = addr => {
		fetch("<c:url value='/35/navigate/' />"+addr, {
			method: 'GET'}
// 		promise.then(success, failure)		
		).then(
// 			response是箭頭函式參數，橫槓內代表成功時之處理
// 			----------------------------------------
			response => {
				if (response.ok){
// 					message是箭頭函式參數
					response.text().then(
						message => {	
	// 						message就是回傳後轉形成text的回應內容，這時候創元素變數名稱
							let navigateButton = document.getElementById(addr);
							let navigateImg = document.createElement('img');
	// 						Button後方插入元素
							navigateButton.insertAdjacentElement("afterend", navigateImg);
	// 						插入圖片屬性
							navigateImg.src="data:image/png;base64, " + message;
							navigateImg.style.display = "block";
							navigateImg.style.width = "400px";
							navigateImg.style.height = "400px";							
						},
						noMessage => {
		
						}
					);	
				}
			},
// 			----------------------------------------
// 			沒收到正確回應之處理
			noResponse => { 
	
			}
// 		第一個.then沒預期回傳promise物件會跳到此catch
		).catch();
	}

</script>
</body>
</html>