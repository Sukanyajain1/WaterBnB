<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome! - WaterBnB </title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
	<div class="container"> <!-- Beginning of Container -->
		<a href = "/logout" class = "btn btn-danger mt-2 float-end">Logout</a>
		<h2>Find places to swim and sleep on WaterBnB!</h2>
		<form:form action = "/search" method = "post" modelAttribute = "searchEntry">
			<div class = "float-center">
				<form:input path="color" class = "form-control" placeholder ="Location"/>
			</div>
			<input type = "submit" value = "Search" class = "btn btn-secondary mt-2" />
		</form:form>
	</div>
</body>
</html>








											
									