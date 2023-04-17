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
		<title>Review - WaterBnB</title>
		  <!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
		      rel="stylesheet" 
		      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
		      crossorigin="anonymous">
	
	</head>
	<body>
		<div class = "container">
			<h4 class = "text-danger"><c:out value = "${logAlert}"></c:out></h4>
			<h4 class = "text-danger"><c:out value = "${reviewerAlert}"></c:out></h4>
			<div class="d-flex flex-row-reverse">
				<a href = "/dashboard" class="p-2">Dashbaord</a>
				<a href = "/logout" class="p-2">Logout</a>
			</div>
			
			<h4>Review of <c:out value="${listing.listingAddress}"></c:out></h4>
			
			
			Text box for the review input
			Rating (from 1 to 5 drop down option)
			Submit button
			
			<form:form action = "/createReview/${listingId}" method = "post" modelAttribute = "review">

				<div class = "form-group">
					<form:input type = "text-area" path="reviewContent" class = "form-control"/>
					<form:errors path="reviewContent" class = "text-danger"/>
				</div>
				<div class = "form-group">
					<label>Rating: </label>
					<form:select path="rating" class = "form-control">
						<form:option value="1">1</form:option>
						<form:option value="2">2</form:option>
						<form:option value="3">3</form:option>
						<form:option value="4">4</form:option>
						<form:option value="5">5</form:option>
					</form:select>
				</div>
				<input type = "submit" value = "Add Review" class = "btn btn-success mt-2" />
			</form:form>
		</div>
	</body>
</html>











