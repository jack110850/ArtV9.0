<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%request.setCharacterEncoding("UTF-8");%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>購物車</title>
    <style>
        td {
            width: 100px;
        }

       .halfnum {
            width: 30px;
        }
        .adultnum {
            width: 30px;
        }
                .title{
         width:200px;
        }
        .total1{
        width: 120px;
        }
        .total2{
        width: 120px;
        }
        .totalprice{
        width: 120px;
        }
        
        .price2{
        width:200px;
        }
        #1{
        float:right;
        }
       

    </style>

</head>

<body>

<!-- start banner Area -->
			<section class="banner-area relative" id="home">	
				<div class="overlay overlay-bg"></div>
				<div class="container">
					<div class="row d-flex align-items-center justify-content-center">
						<div class="about-content col-lg-12">
							<h1 class="text-white">
								AAART Shop
							</h1>	
							<p class="text-white link-nav"><a href="index.html">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="<c:url value='/14/shopListController.ctrl' />"> Shop</a></p>
						</div>											
					</div>
				</div>
			</section>
	<!-- End banner Area -->

<form name="order2" action="<c:url value='/04/shoppingcart2.ctrl'/> " method="get">


<div class="container">

<br><br><table>
	<tr >
		<td class="progressbar">Step 1</td>
		<td class="progressbar">Step 2</td>
		<td class="progressbar">Step 3</td>
		<td class="progressbar">Step 4</td>
	</tr>
	<tr>
	<td  colspan="4" style="width: 50%">
		<div class="progress">
<!-- 		28  -->
		<a class="process-wizard-dot"></a>
  		<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 53%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
	</td>

	</tr>
	<tr>
		<td>區域/張數</td>
		<td>劃位</td>
		<td>購票確認</td>
		<td>完成訂購</td>
	</tr>
	</table><br>


    <H1>訂購人資訊</H1>
 <table class= "table table-bordered">
 

        
        <tr>
            <td>訂購人姓名 
            </td>
            <td>
             <input type="text" name="name" value="">
             <td>
        </tr>
        <tr>
            <td>電子郵件
            </td>
            <td>
             <input type="text" name="email" value="">
             </td>
        </tr>
        <tr>
            <td>電話
            </td>
            <td>
             <input type="text" name="tel">
            </td>
        </tr>
        <tr>
            <td>地址
            </td>
            <td>
             <input type="text" name="add">
            </td>
        </tr>
     </table><br><br> <br>  
		
	<H2>訂購票券</H2>
		<table class="table table-bordered">
		<tr> 
				<td>節目名稱</td>
				<td>票種</td>
				<td>座位</td>
				<td>票價</td>
				<td>操作</td>

			</tr>
			<tr> 
				<td class="title">${sessionScope.shoppingcart.TITLE}</td>
				<td>半票</td>
				<td></td>
				<td>NT$1000</td>
				<td><input type="button" value="刪除" name="" class="" id=""> 				
				</td>
			</tr>
						<tr> 
				<td class="title">${sessionScope.shoppingcart.TITLE}</td>
				<td>全票</td>
				<td></td>
				<td>NT$2000</td>
				<td><input type="button" value="刪除" name="" class="" id=""> 						
				</td>
			</tr>
		</table>	

          <input type="submit" value="繼續購票" name="1" class="btn btn-outline-info" id="1">  
    	 </form>
   		<form name="order" action="<c:url value='/_04_ShopCart/ClearCart'/>" method="POST">
          <br><input type="submit" value="全部清除" name="clear" class="btn btn-outline-info" id="clear"> 
    	 </form>


</div>   

 <script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>


</body>

</html>