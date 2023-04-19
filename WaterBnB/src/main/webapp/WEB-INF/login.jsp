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
<title>Login|Register - WaterBnB </title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
	<div class = "container">
		<h4 class = "text-danger"><c:out value = "${logAlert}"></c:out></h4>
		<h1>Welcome to WaterBnB!</h1>
		<p>Find A Pool For Your Next Vacation!</p>
			<div class = "row justify-content-around">
				<div class = "col-5 border p-3">
					<h2>Register</h2>
					<form:form action = "/register" method = "post" modelAttribute = "newUser">
						<div class = "row">
							<div class = "col">
								<p>
									<form:label path="firstName">First Name: </form:label>
									<form:errors class = "text-danger" path="firstName"/>
								</p>
								<p>
									<form:label path="lastName">Last Name: </form:label>
									<form:errors class = "text-danger" path="lastName"/>
								</p>
								<p>
									<form:label path="email">Email: </form:label>
									<form:errors class = "text-danger" path="email"/>
								</p>
								<p>
									<form:label path="password">Password</form:label>
									<form:errors class = "text-danger" path="password"/>
								</p>
								<p>
									<form:label path="confirm">Confirm Password:</form:label>
									<form:errors class = "text-danger" path="confirm"/>
								</p>
							</div>
							<div class = "col">
								<p>
									<form:input path="firstName"/>
								</p>
								<p>
									<form:input path="lastName"/>
								</p>
								<p>
									<form:input path="email"/>
								</p>
								<p>
									<form:input type = "password" path="password"/>
								</p>
								<p>
									<form:input type = "password" path="confirm"/>
								</p>
							</div>
						</div>
						<input type = "submit" value = "Submit">
					</form:form>
				</div>
				
				
				<div class = "col-5 border p-3">
					<h2>Login</h2>
					<form:form action = "/login" method = "post" modelAttribute = "newLogin">
						<div class = "row">
							<div class = "col">
								<p>
									<form:label path="email">Email: </form:label>
									<form:errors class = "text-danger" path="email"/>
								</p>
								<p>
									<form:label path="password">Password</form:label>
									<form:errors class = "text-danger" path="password"/>
								</p>

							</div>
							<div class = "col">
								<p>
									<form:input path="email"/>
								</p>
								<p>
									<form:input type = "password" path="password"/>
								</p>
							</div>
						</div>
						<input type = "submit" value = "Submit">
					</form:form>
				</div>
			</div>
	</div>
</body>
</html>