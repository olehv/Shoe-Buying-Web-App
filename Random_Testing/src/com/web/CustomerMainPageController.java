package com.web;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerMainPageController
 */
@WebServlet("/CustomerMainPageController")
public class CustomerMainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerMainPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("action");
		
		if(button.equals("Edit Order")) {
			HttpSession session = (HttpSession) request.getSession();
			session.setAttribute("currentOrderEdit", request.getParameter("orders"));
			RequestDispatcher view = request.getRequestDispatcher("/CustomerOrderEdit.jsp");
			view.forward(request, response);
		}
		else if(button.equals("New Order")) {
			RequestDispatcher view = request.getRequestDispatcher("/CustomerOrderNew.jsp");
			view.forward(request, response);
		}
		else {
			System.out.println("Button not found...");
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
