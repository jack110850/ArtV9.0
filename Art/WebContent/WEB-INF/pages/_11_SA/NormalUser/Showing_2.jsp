<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
<head>
<style>
	span{
		margin: 10px;
		padding: 5px;
	}
	body {
		background-color: rgb(204,204,137);
	}
	
</style>
<script>
	$(document).ready(function() {
		console.log("hi");
		$('#table11').DataTable();
	});
</script>
</head>

<!-- 黑底起點 -->
<section class="banner-area relative" id="home">	
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">
					街頭藝人一覽
				</h1>	
				<p class="text-white link-nav"><a href="index.html">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href='<c:url value="/userStreetArtistPage.ctrl"/>'> 總覽</a></p>
			</div>											
		</div>
	</div>
</section>
<!-- 黑底終點 -->
<div>
<form action="searchSA2.ctrl" method="POST">
	<span style="text-align: center;display: block;">
		依樂器或分類查詢：
		<input type="text" name="word">
		<input type="submit" name="submit" value="送出">
	</span>
</form>
</div>

 <section class="upcoming-event-area section-gap" id="events">
 	<div class="container">
 		<div class="row">
 		<c:forEach var="userView" varStatus="stat" items="${BeanList_SA}">
 			<div class="single-events">
				<img class="img-fluid" src="data:image/jpg;base64, ${userView.pic2_SA}" alt="" width=250px height=250px;>
				<a href="#"><h4>Street Artist</h4></a>
				<h6><span>姓名：</span> ${userView.name_SA }</h6>
				<p>
					Somebody show their skill to other perple in the street.
				</p>
				<a href='<c:url value="/ToWeb.ctrl"/>' class="primary-btn text-uppercase">View Details</a>
				<h6> </h6>
			</div>
		</c:forEach>
 		</div>
 	</div>
 </section>
<!-- 
<table id="table11" class="display">
	<thead>
		<tr>
			<th style="text-align: center;">藝名</th>
			<th style="text-align: center;">來自</th>
			<th style="text-align: center;">表演項目</th>
			<th style="text-align: center;">分類</th>
			<th style="text-align: center;">圖片</th>
			<th style="text-align: center;">動作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="userView" varStatus="stat" items="${BeanList_SA}">
		<tr>
			<td style="text-align: center;">${userView.name_SA } </td>
			<td style="text-align: center;">${userView.country_SA }</td>
			<td style="text-align: center;">${userView.theme_SA }</td>
			<td style="text-align: center;">${userView.classification_SA }</td>
			<td style="text-align: center;">
				<img style="display: block; width: 50px;height: 50px;" src="data:image/jpg;base64, ${userView.pic2_SA}">
			</td>
			<td style="text-align: center;">
				<form action="ToWeb.ctrl">
					<input type="hidden" value="${userView.id_SA}"  name="id_SA"/>
					<input type="submit" name="submit" value="了解更多" id="aaa"/>
				</form>
				<form action="ToDonate.ctrl">
					<input type="hidden" value="${userView.id_SA}"  name="id_SA"/>
					<input type="submit" name="submit" value="支持他" id="bbb"/>
				</form>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
 -->