package com.bridgelabz;


import java.io.IOException;
import static java.lang.System.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LoginDetails log=new LoginDetails();
		String email=log.setEmail(req.getParameter("email"));
		String p=log.setPassword(req.getParameter("password"));
		//	RegistrationServlet.list.add(log);	
		display1(log);
//		for(RegistrationDetails req1:RegistrationServlet.list) {
			if(email.equalsIgnoreCase("msibgathulla@gmail.com")&&(p.equalsIgnoreCase("Thanos"))) {
//				resp.setContentType("Welcome.html");
				System.out.println("Password Matched");
						RequestDispatcher rd = req.getRequestDispatcher("Welcome.html"); 
						rd.forward(req, resp);  
				//PrintWriter out=resp.getWriter();
				//out.write("You've Loggedin successfully,\n Welcome To Home Page");

			}
			else{ 	
				out.print("Password Mismatch");			
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				//rd.forward(req, resp);//next page

					rd.include(req, resp);   //same page

			}
		
	}   



	void display1(LoginDetails log) {
		System.out.println("The Login Details are:");
		System.out.println("Email ID:"+log.getEmail());
		System.out.println("Password:"+log.getPassword());
	}
}