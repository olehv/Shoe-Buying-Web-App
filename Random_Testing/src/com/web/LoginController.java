package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.ConnectionFactory;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	  Connection con;
	  ResultSet rs;
	  PreparedStatement pst;

	
    public LoginController() {
        super();
    }


    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String user = request.getParameter("user");
		
		// Get user's username and password input
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		// If statement to determine whether Customer/CSR login
		if (user.equals("customer")) {
			Customer customer = new Customer();
			try{
				response.setContentType("text/html");
				
				ConnectionFactory connection = new ConnectionFactory();
				customer = connection.getCustomer(username,password);
				
				
				// Validate Login Information
				if (username.equals(customer.getUserName()) && (password.equals(customer.getPassword()))) {
					
					// add bean to request & displatch to CustomerMainPage.jsp
					HttpSession session = request.getSession();
					session.setAttribute("customer", customer);
					RequestDispatcher view = request.getRequestDispatcher("/CustomerMainPage.jsp");
					view.forward(request, response);
					
				} else if (!username.equals(customer.getUserName()) && (!password.equals(customer.getPassword()))){
					//TODO DOES NOT REDIRECT
					System.out.println("failed login");
					RequestDispatcher rd=request.getRequestDispatcher("/FailedLogin.html");  
		            rd.forward(request, response); 
				}
			}catch (Exception e)
			{
				System.out.println(e);
			}
			
			
		} else if (user.equals("csr")) {
			CSR csr = new CSR();
			try{
				response.setContentType("text/html");
				//TODO CONNECTION FACTORY INTEGRATION, CURRENTLY NOT WORKING
				
				ConnectionFactory connection = new ConnectionFactory();
				csr = connection.getCSR(username,password);
				
				// Validate Login Information
				if (username.equals(csr.getUserName()) && (password.equals(csr.getPassword()))) {
					HttpSession session = request.getSession();
					session.setAttribute("csr", csr);
					RequestDispatcher view = request.getRequestDispatcher("/CSRMainPage.jsp");
					view.forward(request, response);
					
				} else if (!username.equals(csr.getUserName()) && (!password.equals(csr.getPassword()))){
					//TODO DOES NOT REDIRECT
					System.out.println("failed login");
					RequestDispatcher rd=request.getRequestDispatcher("/FailedLogin.html");  
		            rd.forward(request, response); 
				}
				
				
			}catch (Exception e)
			{
				System.out.println(e);
			}
			
		}

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}