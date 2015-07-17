<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />

<style type="text/css">
    html { height: 100% }
    body { height: 100%; margin: 0; padding: 0 }
    #map { height: 90%; width: 90% }



</style>

	<title>Move the Marker</title>
	

  <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">

  <!-- 可选的Bootstrap主题文件（一般不用引入） -->
  <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>


  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>


<style>

.panel-custom > .panel-heading {
  background-color:#FF6633;
}
.panel-custom > .panel-body {
background:#FFF5F5;
}


.carousel {
    background: url(./background.pic.jpg);
    position: relative;
    padding: 0px;
    width: 600px;
    height: 260px;
    margin: 0px ;
}

  .navbar-custom {
    background-color:#FF6633;
    color:#ffffff;
    border-radius:0;
  }

  .navbar-custom .navbar-nav > li > a {
    color:#fff;
  }
  .navbar-custom .navbar-nav > .active > a, .navbar-nav > .active > a:hover, .navbar-nav > .active > a:focus {
    color: #ffffff;
    background-color:transparent;
  }
  .navbar-custom .navbar-brand {
    color:#eeeeee;
  }





</style>



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
        
        
        <div class="page-header">
            <h1><font color="#CC6600">Hello! ${user.name}, you are visiting ${visit.name} </font> <small>Join his discuss right now!ε٩(๑> ₃ <)۶з</small></h1>
   
       </div>
        <p align="right">
        <form action="addNewDish" method="post" > 
        <input type="submit" name="submit" value="Add New Dish" class="btn btn-default">
        
        </form>
        </p>
        
        
 		<div class="container">
			<c:forEach items="${dishList}" var="da">

				<div class="media" >

					<div class="media-left">
						<a href="#"> <img class="img-circle"
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
										<form method="post" action="discuss">
									<p align="right">
										<input type="button" class="btn btn-default" name="${da.dish.id}"
											onclick="likeFuncation(${da.dish.id})" value="Like (${da.hl.size()})"/>
									
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
        
        
        
        
</body>
</html>