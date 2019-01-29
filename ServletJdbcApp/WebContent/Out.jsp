<%@page import="com.bridgelabz.config.dbutil.model.details.RegistrationDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bridgelabz.config.dbutil.model.details.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		RegistrationDetails usr = new RegistrationDetails();
		String email = null;
		String sessID = null;
		if (session.getAttribute("RegistrationDetails") == null) {
			response.sendRedirect("login.html");
		} else
		{
				usr =(RegistrationDetails)(session.getAttribute("RegistrationDetails"));
		}
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("email"))
					email = cookie.getValue();
			}
		}
	%>
	<h3>
		You've Checked Out
	</h3>
	
	<a href="<%=response.encodeURL("welcome.jsp") %>">Go Back</a>
	<form action="<%=response.encodeURL("Update.jsp")%>" method="post">
	<input type="submit" value="edit">
	</form>
</body>
</html>