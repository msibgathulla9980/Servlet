<%@page import="com.bridgelabz.config.dbutil.model.details.RegistrationDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bridgelabz.config.dbutil.model.details.RegistrationDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
</head>
<body>
	<%
	RegistrationDetails	user =(RegistrationDetails)(session.getAttribute("RegistrationDetails"));
	%>
	<div class="container">
	<h3>Your details are:</h3><br>
	<div>
	First Name:
	<%=user.getFirstName() %>	</div>
	<div>
		Last Name:
		<%=user.getLastName() %>	</div>
		<div>
		Email:
		<%=user.getEmail() %>
		</div>
	<div>
	Password:
	<%=user.getPassword() %>
	</div>
	<div>
	Phone Number:
	<%=user.getPhoneNumber() %>
	</div>
	<div align="center">
	<form action="<%=response.encodeURL("Update.jsp") %>" method="post">
	<button type="submit" value="submit">Edit</button>
	</form>
	<form action="<%=response.encodeURL("Welcome.jsp")%>" method="post">
			<button type="submit" value="submit">Back</button>
		</form>	
	</div>
	</div>
</body>
</html>