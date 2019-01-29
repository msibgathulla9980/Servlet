package com.bridgelabz.config.dbutil.model.details;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.config.dbutil.model.config.UserUpdate;

@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unused")
		PrintWriter out= resp.getWriter();
		 HttpSession session = req.getSession(true);
		 RegistrationDetails user = (RegistrationDetails) session.getAttribute("RegistrationDetails");
		
		String fname=req.getParameter("firstName");
	    String lname=req.getParameter("lastName");
	    String password=req.getParameter("password");
	    String mobileNumber=req.getParameter("phoneNumber");
	    if (fname.equals("") || lname.equals("")||password.equals("") || mobileNumber.equals("")) {
            resp.sendRedirect("update.jsp");
	    }
	    else {
	    	user.setFirstName(fname);
	    	user.setLastName(lname);
	    	user.setPassword(password);
	    	user.setPhoneNumber(mobileNumber);
	    }
	   
	    try {
	    UserUpdate.edit(user);
		resp.sendRedirect("checkout.jsp	");    
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }   

	    
	}
}