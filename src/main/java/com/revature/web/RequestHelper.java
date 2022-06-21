package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class RequestHelper {
    
	// employeeservice
	
	private static EmployeeService eserv = new EmployeeService(new EmployeeDao());
	
	// object mapper (for 
	private static ObjectMapper om = new ObjectMapper();
	
	/**
	 * Extracts the params from a request (username, password) form the ui
	 * It will call the confirmLogin() method from the EmployeeService and see if a
	 * user with that username and password exists
	 * 
	 * Who will provide the method with the HTTPRequest?  The UI
	 * 
	 * Need to build an html doc with a form that will send these params to the method
	 * 
	 * 
	 */
	public static void processLogin(HttpServletRequest request,HttpServletResponse response ) 
	            throws IOException, ServletException{
		
		// 1. Extract the params from the request (username and password)
			//fn key + arrow will get to the end of a line  or ctrl +
		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
		
		//2. Call the confirm login method form employeeService 
		
			Employee e = eserv.confirmLogin(username, password);
			
		//3. If User exists, let's print their info to the screen
		       //alternatively you can redirect o another resource (servlet)
			if(e != null && e.getId() > 0) {
				//grab the session
				 HttpSession sess = request.getSession();

					//add the user to the session
				 sess.setAttribute("the-user", e);
				 
				
				//print users data with printwriter
				 PrintWriter out = response.getWriter();
				 response.setContentType("text/html");
				 out.println("<h1>Welcome " + e.getFirst_name() + " </h1><br />");
				 out.println("<h3>You have successfully logged in!</h3>");
				 
				 //you could print out the object as a JSON string
				 String jsonString = om.writeValueAsString(e);
				 out.println(jsonString);
				 
				 
			}else {
				 PrintWriter out = response.getWriter();
				 response.setContentType("text/html");
				 out.println("No user found, sorry");
				// response.setStatus(204); //204 means successful connection to server, but no content found
			}
		
	}
	
	
	
}
