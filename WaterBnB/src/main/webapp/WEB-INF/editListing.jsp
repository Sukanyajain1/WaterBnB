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
		<div class = "container">
			<h4 class = "text-danger"><c:out value = "${logAlert}"></c:out></h4>
			<h4 class = "text-danger"><c:out value = "${reviewerAlert}"></c:out></h4>
			<div class="d-flex flex-row-reverse">
				<a href = "/dashboard" class="p-2">Dashbaord</a>
				<a href = "/logout" class="p-2">Logout</a>
			</div>
			<h1>Hey, <c:out value = "${loggedUser.firstName}"></c:out>!</h1><br/>
			<form:form action = "/updateListing/${listing.id}" method = "post" modelAttribute = "listing">
				<input type = "hidden" name = "_method" value = "put">
				<form:hidden path = "user" value = "${userId}" />
				<div>
					<div class = "row justify-content-around">
						<div class = "col-5 p-3 form-group" style="height: 200px;">
							<h4 style="height: 25%;"><c:out value="${listing.listingAddress}"></c:out></h4>
							<form:hidden path = "listingAddress" value = "${listing.listingAddress}" />
							<form:input path="listingDescription" class = "form-control" style="height: 75%;"/>
							<form:errors path="listingDescription" class = "text-danger"/>
						</div>
						<div class = "col-5 p-3 form-group" style="height: 200px;">
							<h4 class = "mh-25"><span  style="text-decoration: underline;">Email:</span> <c:out value="${listing.user.email}"></c:out></h4>
							<h4 class = "mh-25"><span  style="text-decoration: underline;">Name:</span>  <c:out value="${listing.user.firstName}"></c:out> <c:out value="${listing.user.lastName}"></c:out></h4>
							<div class = "form-group">
								<label>Pool Size: </label>
								<form:select path = "poolSize" class = "form-control">
									<option value="" disabled selected>Select a pool size!</option>
									<form:option value="Small">Small</form:option>
									<form:option value="Medium">Medium</form:option>
									<form:option value="Large">Large</form:option>
								</form:select>
							</div>
							<div class = "form-group">
								<label>Cost Per Night: $</label>
								<form:input type = "number" min="1" path = "costPerNight" class = "form-control"/>
								<form:errors class = "text-danger"/>
							</div>					
						</div>
					</div><br/>
						<input type = "submit" value = "Save Changes" class = "btn btn-success mt-2" />
				</div>
			</form:form><br/>
			
			<div class = "container border">
				<div class = "d-flex justify-content-between">
					<h4>Reviews (<c:out value="${listing.averageRating}">0</c:out>/5)</h4>
					
					<a href = "/newReview" class="p-2">Leave a Review</a>
				</div>	
				
				<!-- forEach loop for all ratings with foreign id matching the listing.id -->
				<c:forEach var="review" items="${listing.reviews}">
					<div class = "border-bottom mb-3">
						<strong><c:out value="${review.user.firstName}"></c:out> <c:out value="${review.user.lastName}"></c:out></strong><br/>
						Rating: <c:out value="${review.rating}"></c:out>/5<br/>
						<c:out value="${review.reviewContent}"></c:out>
					</div>
				</c:forEach>
						<!-- <a href = "/show/${listing.id}"> <c:out value="${listing.listingAddress}"></c:out></a> -->
			</div>
		</div>
	</body>
</html>