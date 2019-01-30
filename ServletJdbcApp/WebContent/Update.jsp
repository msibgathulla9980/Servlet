<%@page
	import="com.bridgelabz.config.dbutil.model.details.RegistrationDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="com.bridgelabz.config.dbutil.model.details.RegistrationDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
</head>
<body>
	<form action="edit" method="post">

		<% RegistrationDetails user=new RegistrationDetails();
String EmailId = null;
String sessID = null;
if(session.getAttribute("RegistrationDetails") == null){
    response.sendRedirect("login.html");
}else
     user=(RegistrationDetails)session.getAttribute("RegistrationDetails");
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("emailid")) EmailId = cookie.getValue();
}
}
%>
		<fieldset>
			<center>
				<h3>Please Edit the information below</h3>
			</center>
			<fieldset>
<center>
<form action="edit" method="post">
<center><p>Please Enter Your Valid Credentials: </p></center>
FirstName : <input type="text" name="firstName" placeholder="Enter Your FirstName" /><br><br>
LastName : <input type="text" name="lastName" placeholder="Enter Your LastName" /><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	Password : <input type="password" name="password" placeholder="Enter Your Password" /><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mobile   : <input type="text" name="phoneNumber" placeholder="Enter Your 10 digit PhoneNumber" /><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gender   : 
<label for="male">Male</label>
  <input type="radio" name="gender" id="male" value="male" >
  <label for="female">Female</label>
 <input type="radio" name="gender" id="female" value="female" >
  <label for="other">Other</label>
 <input type="radio" name="gender" id="other" value="other" ><br><br>
<a href="Out.jsp"> <input type="submit" value="Submit"/></a>
</form>
<a href="Out.jsp" ><input type="submit" value="Back"/></a>
</center>
<fieldset>
	</form>
</body>
</html>

