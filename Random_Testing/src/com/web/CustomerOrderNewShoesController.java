package com.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerOrderNewShoesController
 */
@WebServlet("/CustomerOrderNewShoesController")
public class CustomerOrderNewShoesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerOrderNewShoesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isAdded = false;
		Order order = new Order();
		
		ConnectionFactory connection = new ConnectionFactory();
		HttpSession session = ((HttpSession) request.getSession());
		Customer customer = (Customer) session.getAttribute("customer");
		
		order.setCustomerId(customer.getCustomerID());
		order.setItemId(Integer.parseInt(request.getParameter("shoes")));
		order.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		order.setStatus("ORDER PLACED");
		
		try { 
		isAdded = connection.addOrder(order);
		}
		catch(Exception e) {
			System.err.print(e);
		}
		if(isAdded) {
			session.setAttribute("currentOrder", order);
			RequestDispatcher view = request.getRequestDispatcher("/OrderSuccess.jsp");
			view.forward(request, response);
		}
		else {
			System.out.println("Add Order Failure");
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
