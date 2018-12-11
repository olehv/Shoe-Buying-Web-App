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
 * Servlet implementation class CustomerOrderEditController
 */
@WebServlet("/CustomerOrderEditController")
public class CustomerOrderEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerOrderEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isEdited = false;
		Order order = new Order();
		
		ConnectionFactory connection = new ConnectionFactory();
		HttpSession session = ((HttpSession) request.getSession());
		Customer customer = (Customer) session.getAttribute("customer");
		
		order.setCustomerId(customer.getCustomerID());
		order.setOrderId(Integer.parseInt(session.getAttribute("currentOrderEdit").toString()));
		order.setItemId(Integer.parseInt(request.getParameter("shoes")));
		order.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		order.setStatus("ORDER PLACED");
		
		try { 
		isEdited = connection.updateOrder(order);
		}
		catch(Exception e) {
			System.err.print(e);
		}
		if(isEdited) {
			session.setAttribute("currentOrder", order);
			RequestDispatcher view = request.getRequestDispatcher("/OrderSuccess.jsp");
			view.forward(request, response);
		}
		else {
			System.out.println("Update Order Failure");
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
