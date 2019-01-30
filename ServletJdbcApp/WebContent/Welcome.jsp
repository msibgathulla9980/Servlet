<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.bridgelabz.config.dbutil.model.details.RegistrationDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
RegistrationDetails user = new RegistrationDetails();
String email = null;
String sessID = null;
if (session.getAttribute("RegistrationDetails") == null) {
	response.sendRedirect("login.html");
} else
{
		user =(RegistrationDetails)(session.getAttribute("RegistrationDetails"));
}
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("RegistrationDetails"))
			email = cookie.getValue();
		if(cookie.getName().equals("JSESSIONID")){
			sessID=cookie.getValue();
			}
		}
}
	
%>
<h3>Hi
<%=user.getEmail() %> You've loggedin successfully and Session ID:<%=sessID %>
</h3>
<div align="center">
		<form action="<%=response.encodeURL("Out.jsp")%>"
			method="post">
			<button type="submit" value="Details">Details</button>
		</form>
		<form action="<%=response.encodeURL("login.html")%>" method="post">
			<button type="submit" value="submit">Logout</button>
		</form>
</div>
</body>
</html>