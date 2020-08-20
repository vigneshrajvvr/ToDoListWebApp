<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>

	<form:form action="${pageContext.request.contextPath}/register/processRegistrationForm" method="POST"
			   modelAttribute="userDetails">
		<p>	
			Username: <form:input path="username"/>
		</p>
		<p>	
			Email:<form:input path="email"/>
		</p>
		<p>	
			Password:<form:password path="password"/>
		</p>
		
		<p>	
			Matching Password:<form:password path="matchingPassword"/>
		</p>
		
		<p>
			<input type="submit" value="SignUp">
		</p>
		
	</form:form>	
	Return to signin: <a href="${pageContext.request.contextPath}/showLoginPage">Signin</a>
</body>
</html>