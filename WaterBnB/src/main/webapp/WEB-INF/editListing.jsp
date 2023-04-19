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
		<title>Edit - WaterBnB</title>
		  <!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
		      rel="stylesheet" 
		      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
		      crossorigin="anonymous">
		
	</head>
	<body>
		<h4 class = "text-danger"><c:out value = "${logAlert}"></c:out></h4>
		<a href = "/dashboard" class="p-2">Dashbaord</a>
		<h1>Hey, <c:out value = "${loggedUser.firstName}"></c:out>!</h1>
			Full Address
			<!--  -->
			Home hyperlink
			Logout hyperlink
			<!--  -->
			
			(SUBMISSION FORM FOR CHANGING THE LISTING DETAILS---- PREPOPULATED WITH ALL DATA)
			Description of the listing
			Information of the listing owner (Email:, Name:, Pool Size:, Cost: $)
			Save Changes (submit button)
			<!--  -->
	
			Reviews (average rating out of 5 to the 1st decimal place)
			<!-- forEach loop for all ratings with foreign id matching the listing.id -->
			name
			Rating: something out of 5
			rating content
	</body>
</html>