package com.bridgelabz.config.dbutil.model.details;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import com.bridgelabz.filter.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.bridgelabz.config.dbutil.model.config.MySQLConnUtils;
import com.bridgelabz.config.dbutil.model.details.RegistrationDetails;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out= resp.getWriter();
		RequestDispatcher dis = null;
		RegistrationDetails log=new RegistrationDetails();
		String email=req.getParameter("email");
		String p=req.getParameter("password");
		log.setEmail(email);
		log.setPassword(p);
		//creating a new session if it doesnot exists
		//			HttpSession session=req.getSession(false);
		//			if(session!=null && !session.isNew()) {
		//				obj1.doFilter(req,resp,null);
		//			}
		//			else
		//			{
		//				resp.sendRedirect("/login.jsp");
		////			}
		//		 HttpSession session=req.getSession();
		//		 String email1 = (String) session.getAttribute("email");
		//		 if(email1==null)
		//		 {
		//		     resp.sendRedirect("Welcome.html");
		//		     return; // forces redirect to go now
		//		 }
		try {
			//passing user details and receiving the boolean 

			RegistrationDetails logcheck1=MySQLConnUtils.Validation(log);
			System.out.println(logcheck1.getFirstName());
			if (logcheck1!=null)
			{   

				HttpSession session=req.getSession();
				//			dis= req.getRequestDispatcher("/Welcome.jsp");
				//			dis.forward(req, resp);
				session.setAttribute("RegistrationDetails",logcheck1);  
				session.setMaxInactiveInterval(30*60);
				Cookie cookie=new Cookie("RegistrationDetails",logcheck1.getEmail());
				cookie.setMaxAge(60*60);
				resp.sendRedirect("Welcome.jsp");
				Cookie[] cookies=req.getCookies();
				if(cookies!=null)
				{
					for(Cookie cookie1:cookies) {
						if(cookie1.getName().equals("JSESSIONID")) {
							System.out.println("Cookie ID :"+cookie1.getValue());
						}
						cookie1.setMaxAge(10);
						resp.addCookie(cookie1);
					}

				}
				//encoding session id's with URL but only while redirecting
				//			String encodedURL=resp.encodeURL("Welcome.html");
				//			resp.sendRedirect(encodedURL);
			}

			else {
				out.print("<p><b>Invalid Username and Password</b></p>");				
				dis= req.getRequestDispatcher("/login.html");
				dis.include(req, resp);

			}
			out.close();
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


	//
	//	void display1(RegistrationDetails log) {
	//		System.out.println("The Login Details are:");
	//		System.out.println("Email ID:"+log.getEmail());
	//		System.out.println("Password:"+log.getPassword());
	//	}
}
