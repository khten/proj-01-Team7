package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Determines what resource the client is requesting;
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. URI rewriting  ... capture the uri 
		
		// http:localhost:8080/employee-servlet-app/login  
		final String URI = request.getRequestURI().replace("/employee-servlet-app/", "");
		switch(URI) {
		case "login" :   
			//invoke some function from the helper
			RequestHelper.processLogin(request, response);
			break;
		case "employees":
			//invoke some functionality from the helper which would return all employees
			break;
		default:
			//custom error page
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
