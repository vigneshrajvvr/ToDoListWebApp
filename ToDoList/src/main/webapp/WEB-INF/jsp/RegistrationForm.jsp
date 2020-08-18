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

	<form:form action="${pageContext.request.contextPath}/register/showRedirectedHomePage" method="GET">
		<p>	
			Username: <input type="text" name="username">
		</p>
		<p>	
			Email:<input type="email" name="email">
		</p>
		<p>	
			Password:<input type="text" name="password">
		</p>
		
		<p>
			<input type="submit" value="SignUp">
		</p>
		
	</form:form>	
	Return to signin: <a href="${pageContext.request.contextPath}/showLoginPage">Signin</a>
</body>
</html>