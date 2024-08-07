package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.Product;
import service.ProductService;
import service.CategoryService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductService();
	private CategoryService categoryService = new CategoryService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch(action) {
//		case "sortPrice":
//			sortPrice(request, response);
//			break;
		default:
			displayAllProductandCategory(request, response);
			break;
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String action = request.getParameter("action");
//		if (action == null) {
//			action = "";
//		}
//		switch(action) {
//			case "search":
//				searchByName(request, response);
//				break;
//		}
//	}
	
	private void displayAllProductandCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = productService.getProducts();
		List<Category> categories = categoryService.getCategories();
		request.setAttribute("categories", categories);
		request.setAttribute("products", products);
		request.getRequestDispatcher("jsp/Home.jsp").forward(request, response);
	}
	
//	private void sortPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String status = request.getParameter("status");
//		List<Product> products = productService.sortByPrice(status);
//		request.setAttribute("products", products);
//		request.getRequestDispatcher("jsp/Home.jsp").forward(request, response);
//	}
}
