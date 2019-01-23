package com.bridgelabz.config.dbutil.model.details;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.config.dbutil.model.config.MySQLConnUtils;
import com.bridgelabz.config.dbutil.model.details.RegistrationDetails;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
PrintWriter out= resp.getWriter();
		RegistrationDetails log=new RegistrationDetails();
		String email=req.getParameter("email");
		String p=req.getParameter("password");
		 log.setEmail(email);
		 log.setPassword(p);
		 try {
			 //passing user details and receiving the boolean 
				RegistrationDetails logcheck1=MySQLConnUtils.Registration1(log);
				if (logcheck1!=null)
				{
					   RequestDispatcher dis= req.getRequestDispatcher("/Welcome.html");
				        dis.forward(req, resp);
				}
				else {
                 out.print("<h5><p>Password Mismatch</p></h5>");				
					 RequestDispatcher dis= req.getRequestDispatcher("/login.html");
				        dis.include(req, resp);
				}
			} catch (ClassNotFoundException|SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		        RequestDispatcher dis= req.getRequestDispatcher("/Welcome.html");
//		        dis.forward(req, resp);
		        
	}
		//	RegistrationServlet.list.add(log);	
//		display1(log);
//		for(RegistrationDetails req1:RegistrationServlet.list) {
//			if(email.equalsIgnoreCase("msibgathulla@gmail.com")&&(p.equalsIgnoreCase("Thanos"))) {
//				resp.setContentType("Welcome.html");
//				out.print("Password Matched");
//						RequestDispatcher rd = req.getRequestDispatcher("Welcome.html"); 
//						rd.forward(req, resp);  
				//PrintWriter out=resp.getWriter();
				//out.write("You've Loggedin successfully,\n Welcome To Home Page");

//			}
//			else{ 	
//				out.print("Password Mismatch");			
//				RequestDispatcher rd = req.getRequestDispatcher("login.html");
//				//rd.forward(req, resp);//next page
//					rd.include(req, resp);   //same page
//
//			}
//		
//	}   



	void display1(RegistrationDetails log) {
		System.out.println("The Login Details are:");
		System.out.println("Email ID:"+log.getEmail());
		System.out.println("Password:"+log.getPassword());
	}
}