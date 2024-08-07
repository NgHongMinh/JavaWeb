package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;

/**
 * Servlet implementation class AmountServlet
 */
@WebServlet("/amountConfirm")
public class AmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    List<Product> cart = (List<Product>) session.getAttribute("cart");

	    if (cart == null) {
	        cart = new ArrayList<>();
	    }
	    
	    for (Product product : cart) {
	        String amountParam = request.getParameter("amount" + product.getId());
	        if (amountParam != null) {
	            try {
	                int amount = Integer.parseInt(amountParam);
	                product.setAmount(amount);
	                System.out.println("Product ID: " + product.getId() + " Amount: " + amount);
	            } catch (NumberFormatException e) {
	                System.err.println("Invalid amount for product ID: " + product.getId() + " - " + amountParam);
	            }
	        } else {
	            System.err.println("Amount parameter is missing for product ID: " + product.getId());
	        }
	    }

	    double totalAmount = 0;
	    for (Product product : cart) {
	        totalAmount += product.getPrice() * product.getAmount();
	    }

	    double vat = 10; // VAT cố định
	    double totalPayment = totalAmount + vat;
	    
	    session.setAttribute("cart", cart);

	    request.setAttribute("totalAmount", totalAmount);
	    request.setAttribute("vat", vat);
	    request.setAttribute("totalPayment", totalPayment);
	    request.setAttribute("products", cart);
	    request.getRequestDispatcher("jsp/Bill.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
