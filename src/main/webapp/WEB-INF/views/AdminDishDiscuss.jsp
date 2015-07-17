<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Static Top Navbar Example for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>


<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>


<style>
.carousel {
	background: url(./background.pic.jpg);
	position: relative;
	padding: 0px;
	width: 600px;
	height: 260px;
	margin: 0px;
}

.navbar-custom {
	background-color: #FF6633;
	color: #ffffff;
	border-radius: 0;
}

.navbar-custom .navbar-nav>li>a {
	color: #fff;
}

.navbar-custom .navbar-nav>.active>a, .navbar-nav>.active>a:hover,
	.navbar-nav>.active>a:focus {
	color: #ffffff;
	background-color: transparent;
}

.navbar-custom .navbar-brand {
	color: #eeeeee;
}
</style>

<script>
$(document).ready(
        function () {
            $('#x').hide()
        });



function likeFuncation(str)
{
	//alert("the id of dish is"+str);
var xmlhttp; 
var message=document.getElementsByName("message")[0].value;

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
/* 	alert(xmlhttp.responseText); */
	var arr=xmlhttp.responseText.split(",");
/* 	alert("size+"+arr.length);
	alert(arr[0]);
	alert(arr[1]);
	alert(arr[2]); */
	$('#x').show();
	
	document.getElementById('div1').innerHTML=arr[0];
	document.getElementById('div2').innerHTML=arr[1];
	document.getElementById('div3').innerHTML=arr[2];
	
   // document.getElementById("1").value=xmlhttp.responseText;
    }
  }
/*   alert("1"); */
 xmlhttp.open("GET","newDiscuss?id="+str+"&text="+message,true);
 xmlhttp.send();
/*  alert("2"); */
}
</script>

</head>
<body>
<nav class="navbar navbar-custom  navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="mainPage">Food.com</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">





				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Brose<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="broseByHot">Sort By Hot</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">My
						Home<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="goToHome">My Home</a></li>

						<li class="divider"></li>
						<li><a href="changeProfile">Change My Profile</a></li>
						<li><a href="logout">Log Out</a></li>

					</ul></li>





				<form method="post" action="search" class="navbar-form navbar-left"
					role="search">
					<div class="form-group">
						<input type="text" name="name" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</ul>

		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<div class="container">


		<div class="media">

			<div class="media-body">
				<h4 class="media-heading">${dish.name} </h4>



				<div class="media">


					<div class="media-body">
						<div class="panel panel-custom">


							<div class="panel-body">
								<div class="row">
									<c:forEach items="${dishPictures}" var="p">
										<div class="col-xs-6 col-md-3">
											<a href="#" class="thumbnail"> <img
												src="<c:url value="/resources/imgs/${p.url}"/>"
												alt="Generic placeholder thumbnail">
											</a>
										</div>
									</c:forEach>



								</div>
								<div align="right">
									<small> Category:${dish.category.name}
										Price:${dish.price} Date:${dish.updateDate} </small>

								</div>

							</div>
						</div>

					</div>
				</div>
			</div>

		</div>

		<table>
			<c:forEach items="${discussList}" var="d">
				<tr>
					<td width="100px" height="100px">${ d.user.name}</td>
					<td width="600px" bgcolor=#F8F8F8>${d.text}</td>
				</tr>
				<tr>
					<td align="right" colspan="2">${d.date}</td>
					<td>
					<form method="post" action="deleteDiscuss">
					<input type="hidden" name="id" value="${d.id}">
					<input type="submit" name="submit" value="Delete"  class="btn btn-default">
					</form>
		
					</td>
				</tr>
				
		</c:forEach>
			<tr id="x">

				<td width="100px" height="100px" ><div id="div1"></div></td>
				<td width="600px" bgcolor=#F8F8F8><div id="div2"></div></td>
			</tr>
		    <tr>
					<td align="right"  colspan="2"><div id="div3"></div></td>
		   </tr>


			
		</table>
		

        <br/>
         <br/>
		<table>
			<tr>
				<td><textarea name="message" rows="10" cols="100"></textarea></td>
			</tr>
			<tr>
				<td align="right"><input type="button" name="button"
					onclick="likeFuncation(${dish.id})" value="join" class="btn btn-default"></td>
			</tr>
		</table>

	</div>



</body>
</html>