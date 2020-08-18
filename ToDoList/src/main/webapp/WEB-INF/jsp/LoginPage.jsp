<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Oodo - Login</title>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/Login.css"/>
</head>
<body>


	
<div class = "signin">
	<h3>Sign in</h3>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
	
		<p>
			User name: <input type="text" name="username" />
		</p>
		
		<p>
			Password: <input type="text" name="password" />
		</p>
		
		<p>
			<input type="submit" name="Sigin"/>
		</p>
		
	</form:form>
	
	<a href="${pageContext.request.contextPath}/register/showRegistrationForm" role="button" >Sign Up</a>
	
	<c:if test="${param.logout != null}">
		You have been logged out
	</c:if>
	
	<p>${registerMessage}</p>
	
</div>	
</body>
</html>