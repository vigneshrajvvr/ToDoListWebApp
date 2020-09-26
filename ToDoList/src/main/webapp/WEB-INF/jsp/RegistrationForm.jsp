<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>

	<form:form action="${pageContext.request.contextPath}/register/processRegistrationForm" 
			   method="POST"
			   modelAttribute="userDetails">
			   
		<c:if test="${registrationError != null}">
			${registrationError}
		</c:if>	   
		<p>	
			Username: <form:input path="username"/>
					  <form:errors path="username"/>
		</p>
		<p>	
			Email:<form:input path="email"/>
			      <form:errors path="username"/>
		</p>
		<p>	
			Password:<form:password path="password"/>
			         <form:errors path="password"/>
		</p>
		
		<p>	
			Matching Password:<form:password path="matchingPassword"/>
			                  <form:errors path="matchingPassword"/>
		</p>
		
		<p>
			<input type="submit" value="SignUp">
		</p>
		
	</form:form>	
	Return to signin: <a href="${pageContext.request.contextPath}/showLoginPage">Signin</a>
</body>
</html>