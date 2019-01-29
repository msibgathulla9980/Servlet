package com.bridgelabz.config.dbutil.model.details;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.Cookies;

@SuppressWarnings({ "serial", "unused" })
public class LogoutServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		out.print("<h2>You are successfully logged out!</h2>");
//		req.getRequestDispatcher("logout.html");
//		((RequestDispatcher) req).include(req,resp);
//		HttpSession session=req.getSession();
//		session.invalidate();
		Cookie[] cookies=req.getCookies();
		if(cookies!=null)
		{
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("JSESSIONID")) {
					System.out.println("Cookie ID :"+cookie.getValue());
				}
				cookie.setMaxAge(10);
				resp.addCookie(cookie);
			}
			
		}
		//invalidating the session if Exists
		HttpSession session=req.getSession(false);
		System.out.println("User :" +session.getAttribute("email"));
		   if(session!=null) {
			   session.invalidate();
		   }
		   //invalidating the session, hence no encoding
		   resp.sendRedirect("login.html");
		out.close();
	}
}
