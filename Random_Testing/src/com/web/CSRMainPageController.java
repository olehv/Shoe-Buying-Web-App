package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CSRMainPageController
 */
@WebServlet("/CSRMainPageController")
public class CSRMainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSRMainPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("action");
		
		if(button.equals("Edit Order Details")) {
			RequestDispatcher view = request.getRequestDispatcher("/CSREditOrderDetails.jsp");
			view.forward(request, response);
		}
		else if(button.equals("Add Shoes")) {
			RequestDispatcher view = request.getRequestDispatcher("/CSRAddShoes.jsp");
			view.forward(request, response);
		}
		else if(button.equals("Edit Shoes")) {
			RequestDispatcher view = request.getRequestDispatcher("/CSREditShoes.jsp");
			view.forward(request, response);
		}
		else if(button.equals("Edit/Delete Customer")) {
			RequestDispatcher view = request.getRequestDispatcher("/CSREditCustomer.jsp");
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
