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
}}
%>
		<fieldset>
			<center>
				<h3>Please Edit the information below</h3>
			</center>
			<fieldset>
<center>
<form action="Register" method="post">
<center><p>Please Enter Your Valid Credentials: </p></center>
FirstName : <input type="text" name="firstName" placeholder="Enter Your FirstName" required/><br><br>
LastName : <input type="text" name="lastName" placeholder="Enter Your LastName" required/><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email : <input type="email" name="email" placeholder="Enter Your Email" required/><br><br>
&nbsp;&nbsp;Password : <input type="password" name="password" placeholder="Enter Your Password" required/><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mobile   : <input type="text" name="phoneNumber" placeholder="Enter Your 10 digit PhoneNumber" required/><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gender   : 
<label for="male">Male</label>
  <input type="radio" name="gender" id="male" value="male" >
  <label for="female">Female</label>
 <input type="radio" name="gender" id="female" value="female" >
  <label for="other">Other</label>
 <input type="radio" name="gender" id="other" value="other" ><br><br>
<a href="login.html"> <input type="submit" value="Update"/></a>
</form>
<a href=login.html ><input type="submit" value="Login"/></a>
</center>
<fieldset>
	</form>
</body>
</html>

