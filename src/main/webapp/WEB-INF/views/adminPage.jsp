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

<style>
.panel-custom>.panel-heading {
	background-color: #F8F8F8;
}

.panel-custom>.panel-body {
	background: #F8F8F8;
}
</style>

<script>
function likeFuncation(str)
{
	alert("the id of dish is"+str);
var xmlhttp;    

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
	alert("the id of dish is"+str);
	alert(document.getElementsByName(str)[0].value);
	document.getElementsByName(str)[0].value=xmlhttp.responseText;
   // document.getElementById("1").value=xmlhttp.responseText;
    }
  }
  alert("1");
xmlhttp.open("GET","liked?id="+str,true);
xmlhttp.send();
alert("2");
}
</script>
</head>

<body>

	<!-- Static navbar -->
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
		<table>
			<tr>
				<td>

					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img src="<c:url value="/resources/imgs/1.pic.jpg"/>"
									class="img-circle" width="600" height="260" alt="img1">
							</div>
							<div class="item">
								<img src="<c:url value="/resources/imgs/2.pic.jpg"/>"
									class="img-circle" width="600" height="260" alt="img1">
							</div>
							<div class="item">
								<img src="<c:url value="/resources/imgs/3.pic.jpg"/>"
									class="img-circle" width="600" height="260" alt="img1">
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							role="button" data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"
							aria-hidden="true"></span> <span class="sr-only">Next</span>
						</a>
					</div>
				</td>
				<td align="right">


					<p align="right">
						<FONT COLOR="#800517"><h2>What to eat</h2>
							<h3>today?</h3></FONT>
					</p>
				</td>
			</tr>
		</table>
	</div>
	<!-- /container -->


	<div class="container">
		<div>
			<p align="right">
				</br> </br>
				<form action="addNewDish" method="post" > 
                <input type="submit" name="submit" value="Add New Dish" class="btn btn-default">
        
                </form>
			</p>

		</div>


		<div class="container">
			<c:forEach items="${dishList}" var="da">

				<div class="media" >

					<div class="media-left">
						<a href="otherPage?dish=${da.dish.id}"> <img class="img-circle"
							src="<c:url value="/resources/imgs/${da.url}"/>" width="84"
							height="56" alt="Generic placeholder image">
						</a>
					</div>
					<div class="media-body">
						<h4 class="media-heading">${da.dish.name} </h4>



						<div class="media">


							<div class="media-body">
								<div class="panel panel-custom">


									<div class="panel-body">
										<div class="row">
											<c:forEach items="${da.apd}" var="p">
												<div class="col-xs-6 col-md-3">
													<a href="#" class="thumbnail"> <img
														src="<c:url value="/resources/imgs/${p.url}"/>"
														alt="Generic placeholder thumbnail">
													</a>
												</div>
											</c:forEach>




										</div>
									</div>
								</div>
								<div align="left">
									<small> Category:${da.dish.category.name} 
										Price:${da.dish.price}  Date:${da.dish.updateDate} </small>
										<form method="post" action="adminAction">
									<p align="right">
									   <input type="submit" class="btn btn-default" name="submit" value="delete">

									
										<input type="submit" class="btn btn-default" name="submit" value="discuss">
										<input type="hidden" name="discussDish" value="${da.dish.id}">
						
										
									
									</p>
									</form>
								</div>
							</div>
						</div>
					</div>

				</div>



			</c:forEach>
		</div>

	</div>



	<!-- Bootstrap core JavaScript
      ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>