package com.bridgelabz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegistrationServlet extends HttpServlet {
	static List<RegistrationDetails> list=new ArrayList<RegistrationDetails>();

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	@SuppressWarnings("unused")
	RegistrationDetails reg=new RegistrationDetails();
	reg.setFirstName(req.getParameter("firstName"));
	reg.setLastName(req.getParameter("lastName"));
	reg.setEmail(req.getParameter("email"));
	reg.setPassword(req.getParameter("password"));
	reg.setPhoneNumber(req.getParameter("phoneNumber"));
	list.add(reg);
	display(reg);
	
	}
void display(RegistrationDetails reg) {
	System.out.println("The Registration Details are:");
	System.out.println("FirstName:"+reg.getFirstName());
	System.out.println("LastName:"+reg.getLastName());
	System.out.println("Email:"+reg.getEmail());
	System.out.println("Password:"+reg.getPassword());
	System.out.println("Mobile:"+reg.getPhoneNumber());
}

}
