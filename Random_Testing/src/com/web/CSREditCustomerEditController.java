package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CSREditCustomerEditController
 */
@WebServlet("/CSREditCustomerEditController")
public class CSREditCustomerEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSREditCustomerEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isUpdated = false;
		Customer customer = new Customer();
		
		ConnectionFactory connection = new ConnectionFactory();
		HttpSession session = ((HttpSession) request.getSession());
		int customerID = Integer.parseInt( session.getAttribute("currentCustomerID").toString());
		System.out.println(customerID);
		customer.setCustomerID(customerID);
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setUserName(request.getParameter("userName"));
		customer.setPassword(request.getParameter("password"));
		customer.setAddress(request.getParameter("address"));
		customer.setCity(request.getParameter("city"));
		customer.setPostalCode(request.getParameter("postalCode"));
		
		try { 
		isUpdated = connection.updateCustomer(customer);
		}
		catch(Exception e) {
			System.err.print(e);
		}
		if(isUpdated) {
			RequestDispatcher view = request.getRequestDispatcher("/CSRSuccess.jsp");
			view.forward(request, response);
		}
		else {
			System.out.println("Update Customer Failure");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
