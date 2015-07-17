<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Food.com login</title>

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





<script>


var nErr="";
var pswErr="";
var aErr="";
var lErr="";

function getLocation() {

    if (navigator.geolocation) {
    	
        navigator.geolocation.getCurrentPosition(success);
        document.getElementById("button1").value="Waiting...";
      //  alert("a");
    } else { 
       alert("Geolocation is not supported by this browser.");
    }
}

function success(position) {
	
	var latlon = position.coords.latitude + "," + position.coords.longitude;
	
	var location=document.createElement("input");
	
 	location.setAttribute("type", "hidden");
	location.setAttribute("name", "location");
	location.setAttribute("value", latlon);
	document.getElementById("button1").appendChild(location);
	alert(location.value);
	document.getElementById("button1").value="Success!";

	
	 }


</script>

<script>



</script>

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
<div class="panel panel-custom">
  <!-- Default panel contents -->
  <div class="panel-heading"><font color="#FFFFFF">This is great!     </font></div>

  <!-- Table -->
   <div class="panel-body">
     
       
      <form method="post" action="add"  >
      <table class="table">

        <tbody>
          <tr>
           
            <td><font COLOR="#800517"><small>name: </small></font></td>
            <td><input id="dishname" type="text" name="dishname" size="9"/><font color="#FF0000"><script>nErr</script></font></td>
            
          </tr>
          
          <tr>
           
            <td><font COLOR="#800517"><small>Flavor: </small></font></td>
        <td><select name="flavor">
           <c:forEach items ="${fls}" var="flavor">
           
           <option value =${ flavor.name} >${flavor.name}</option>

           </c:forEach>
           </select>
         </td>
            
          </tr>
          <tr>
           
            <td><font COLOR="#800517"><small>Category: </small></font></td>
          <td><select name="category">
           <c:forEach items ="${cls}" var="category">
           
           <option value =${ category.name} >${category.name}</option>

           </c:forEach>
           </select>
         </td>
            
          </tr>
          
          <tr>
          
          <td><font COLOR="#800517"><small>Price:</small> </font></td>
          <td><input id="price" type="text" name="price" size="9"/><font color="#FF0000"><script>aErr</script></font></td>
            
          </tr>
          
          <tr>
          
          <td><font COLOR="#800517"><small>Location:</small> </font></td>
          <td><input id="button1" type="button" name="button" value="Get Location" class="btn btn-default" onclick="getLocation()"/><font color="#FF0000"><script>lErr</script></font></td>
            
          </tr>
          

          <tr>
          
          <td><font COLOR="#800517"><small>Add Pictures:</small> </font></td>
          <td>
          <c:forEach items ="${pictures}" var="p">
           
           ${p}
      

           </c:forEach>
          </td>
            
          </tr>
          <tr>



          <tr>
       
            <td><input  name="submit" type="submit" class="btn btn-default" value="Finish!"/></td>
          </tr>
        </tbody>
      </table>
      </form>
</div>



</div>


</body>
</html>