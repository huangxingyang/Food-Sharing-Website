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




</style>

</head>


<div class="col-xs-4">
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>


<div class="panel panel-custom">
  <!-- Default panel contents -->
  <div class="panel-heading"><font color="#FFFFFF">Finding Your Friend Here!      </font></div>

  <!-- Table -->
   <div class="panel-body">
      <form:form method="post" commandName="user" action="loginPage">

      <table class="table">
        <thead>
            <tr><td></td><tr/>
        </thead>
        <tbody>
          <tr>
           
            <td><font COLOR="#800517"><small>UserName: </small></font></td>
            <td><form:input path="name" size="9"/>
                <form:errors path="name" cssStyle="color: #ff0000;"/>
            </td>
            
          </tr>
          <tr>
          
          <td><font COLOR="#800517"><small>Password:</small> </font></td>
          <td> <form:password path="password"  size="9"/>
               <form:errors path="password" cssStyle="color: #ff0000;"/>
          
          </td>
            
          </tr>
          <tr>
       
            <td><input  name="submit" type="submit" class="btn btn-default" value="Register"/></td>
            <td><input  name="submit" type="submit" class="btn btn-default" value="Login"/></td>
          </tr>
        </tbody>
      </table>
      </form:form>
</div>

</div>
</div>


 <div class="col-xs-8" >
<br/>
<br/>
<br/>


              <div id="carousel-example-generic" class="carousel slide" data-ride="carousel"  align="center">
                <ol class="carousel-indicators">
                  <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                  <div class="item active">
                     <img src="<c:url value="/resources/imgs/page1_picture1"/>" class="img-circle" alt="Cinque Terre" width="300" height="600" alt="img1">
                  </div>
                  <div class="item">
                     <img src="<c:url value="/resources/imgs/page1_picture2"/>" class="img-circle" alt="Cinque Terre" width="300" height="600" alt="img1">
                  </div>
                  <div class="item">
                      <img src="<c:url value="/resources/imgs/page1_picture3"/>" class="img-circle" alt="Cinque Terre" width="300" height="600" alt="img1">
                  </div>
                </div>
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                  <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                  <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>

 <%-- <img src="<c:url value="/resources/imgs/apple.jpg"/>" class="img-circle" alt="Cinque Terre" width="580" height="500" alt="img1"> > --%>



 </div>

</html>
