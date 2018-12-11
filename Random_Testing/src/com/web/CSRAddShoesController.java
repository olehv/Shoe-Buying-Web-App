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
 * Servlet implementation class CSRAddShoesController
 */
@WebServlet("/CSRAddShoesController")
public class CSRAddShoesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSRAddShoesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isAdded = false;
		Shoe shoe = new Shoe();
		
		ConnectionFactory connection = new ConnectionFactory();
		
		shoe.setItemName(request.getParameter("itemName"));
		shoe.setShoeSize(Integer.parseInt(request.getParameter("shoeSize")));
		shoe.setPrice(Double.parseDouble(request.getParameter("price")));
		shoe.setCategory(request.getParameter("category"));
		
		try { 
		isAdded = connection.addShoe(shoe);
		}
		catch(Exception e) {
			System.err.print(e);
		}
		if(isAdded) {
			RequestDispatcher view = request.getRequestDispatcher("/CSRSuccess.jsp");
			view.forward(request, response);
		}
		else {
			System.out.println("Update Shoe Failure");
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
