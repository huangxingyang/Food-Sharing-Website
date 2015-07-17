<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Profile Page</title>

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
<body>


   <div class="panel-body">
      <form action="uploadprofile" method="post" enctype="multipart/form-data">
      <table class="table">
        <thead>
            <tr><td><font color="#FF0000">${message}</font></td><tr/>
        </thead>
        <tbody>
          <tr>
          
          <td><img class="img-circle"
							src="<c:url value="/resources/imgs/${url}"/>" width="84"
							height="56" alt="Generic placeholder image"></td>
          <td><input type="file" name="file" size="50" /></td>
       
            
          </tr>


          <tr>
            <td><input  name="submit" type="submit" class="btn btn-default" value="Change"/></td>
          </tr>
        </tbody>
      </table>
      </form>
</div>




</body>
</html>