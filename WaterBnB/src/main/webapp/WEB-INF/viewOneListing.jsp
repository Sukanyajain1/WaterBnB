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
		<title>View Listing - WaterBnB </title>
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
			<h1>Hey, <c:out value = "${loggedUser.firstName}"></c:out>!</h1>
			<div class = "row">
				<div class = "col">
					<h4><c:out value="${listing.listingAddress}"></c:out></h4><br/>
					<h4><c:out value="${listing.listingDescription}"></c:out></h4>
				</div>
				<div class = "col">
					<h4><span  style="text-decoration: underline;">Email:</span> <c:out value="${listing.user.email}"></c:out></h4>
					<h4><span  style="text-decoration: underline;">Name:</span>  <c:out value="${listing.user.firstName}"></c:out> <c:out value="${listing.user.lastName}"></c:out></h4>
					<h4><span  style="text-decoration: underline;">Pool Size:</span> <c:out value="${listing.poolSize}"></c:out></h4>
					<h4><span  style="text-decoration: underline;">Cost Per Night:</span> $<c:out value="${listing.costPerNight}"></c:out></h4>
				</div>
			</div>
			
		</div>
		<!-- 
<c:out value="${listing.id}"></c:out> -->
		<br/>
		<div class = "container border">
			<div class = "d-flex justify-content-between">
				<h4>Reviews (<c:out value="${listing.averageRating}"></c:out>/5)</h4>
				
				<a href = "/newReview" class="p-2">Leave a Review</a>
			</div>	
			
			<!-- forEach loop for all ratings with foreign id matching the listing.id -->
			<c:forEach var="review" items="${listing.reviews}">

				<c:out value="${review.user.firstName}"></c:out> <c:out value="${review.user.lastName}"></c:out><br/>
				Rating: <c:out value="${review.rating}"></c:out>/5<br/>
				<p><c:out value="${review.reviewContent}"></c:out></p>
			</c:forEach>
					
					
					
					<!-- <a href = "/show/${listing.id}"> <c:out value="${listing.listingAddress}"></c:out></a> -->
		</div>
	</body>
</html>



















