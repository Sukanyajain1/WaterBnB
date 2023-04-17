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
		<title>Search - WaterBnB</title>
		  <!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
		      rel="stylesheet" 
		      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
		      crossorigin="anonymous">
	</head>
	<body>
		Find Your Pool!
		<!--  -->
		Home hyperlink
		Logout hyperlink
		<!--  -->
		new search box
		submit button
		<!--  -->
		
		
		
		
		Table (forEach loop)
		Address
		<!-- Insert details of the address (model model variables) -->
		
		Pool Size
		<!-- Insert details of the pool size (model model variables) -->
		
		Cost Per Night
		<!-- Insert details of the price (model model variables) -->
		
		Details
		<!-- Insert details of the of the average rating and link to the edit page (model model variables) -->
		
	</body>
</html>