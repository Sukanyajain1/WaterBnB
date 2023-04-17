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
		<title>Dash board - WaterBnB </title>
		  <!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
		      rel="stylesheet" 
		      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
		      crossorigin="anonymous">
	</head>
	<body>
		<div class="container"> <!-- Beginning of Container -->
		<h4 class = "text-danger"><c:out value = "${logAlert}"></c:out></h4>
		<h4 class = "text-danger"><c:out value = "${reviewerAlert}"></c:out></h4>
			<a href = "/logout" class = "float-end">Logout</a>
			<h2>Current Listings</h2>
			
			<table class="table table-striped">
				<thead>
					<tr>
					<th scope="col">Address</th>
					<th scope="col">Pool Size</th>
					<th scope="col">Cost Per Night</th>
					<th scope="col">Details</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listing" items="${listings}">
						<tr>
							<td><a href = "/showListing/${listing.id}"> <c:out value="${listing.listingAddress}"></c:out></a></td>
						
							<td><c:out value="${listing.poolSize}"></c:out></td>
							<td>$<c:out value="${listing.costPerNight}"></c:out></td>
							<td>
								<a href = "/edit/${listing.id}" class = "btn btn-primary"><c:out value="${listing.userReviews.size()}"></c:out>/5 - Edit</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div>
				<h2>New Listing</h2>
				
				<form:form action = "/create" method = "post" modelAttribute = "listing">
					<form:hidden path = "user" value = "${userId}" />
					<div class = "form-group">
						<label>Address: </label>
						<form:input path = "listingAddress" class = "form-control"/>
						<form:errors class = "text-danger"/>
					</div>
					<div class = "form-group">
						<label>Description: </label>
						<form:input path = "listingDescription" class = "form-control"/>
						<form:errors class = "text-danger"/>
					</div>
					<div class = "form-group">
						<label>Cost Per Night: $</label>
						<form:input path = "costPerNight" class = "form-control"/>
						<form:errors class = "text-danger"/>
					</div>					
					<div class = "form-group">
						<label>Pool Size: </label>
						<form:select path = "poolSize" class = "form-control">
							<form:option value="Small">Small</form:option>
							<form:option value="Medium">Medium</form:option>
							<form:option value="Large">Large</form:option>
						</form:select>
					</div>	
					<input type = "submit" value = "Add New Listing" class = "btn btn-success mt-2" />
				</form:form>
			</div>
		</div>
	</body>
</html>






<%-- <div class = "form-group">
						<spring:bind path="listingAddress.houseNumber">
							<label>House Number: </label>
							<input type = "text" value= "<c:out value="${status.value}"/>" name="<c:out value="${status.expression}"/>" class = "form-control"/>
							<c:if test="${status.error}">
				                Error codes:
				                <c:forEach items="${status.errorMessages}" var = "error">
				                    <c:out value="${error}"/>
				                </c:forEach>
				            </c:if>
						</spring:bind>
					</div>
					<div class = "form-group">
						<spring:bind path="listingAddress.street">
							<label>Street: </label>
							<input type = "text" class = "form-control"/>
							<form:errors class = "text-danger"/>
						</spring:bind>
					</div>
				
					<div class = "form-group">
						<spring:bind path="listingAddress.city">
							<label>City: </label>
							<input type = "text" class = "form-control"/>
							<form:errors class = "text-danger"/>
						</spring:bind>
					</div>
					
					<div class = "form-group">
						<spring:bind path="listingAddress.state">
							<label>State: </label>
							<input type = "text" class = "form-control"/>
							<form:errors class = "text-danger"/>
						</spring:bind>
					</div>

					<div class = "form-group">
						<spring:bind path="listingAddress.zipCode">
							<label>Zip Code: </label>
							<input type = "text" class = "form-control"/>
							<form:errors class = "text-danger"/>
						</spring:bind>
					</div> --%>















