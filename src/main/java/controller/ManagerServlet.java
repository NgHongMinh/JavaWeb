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
import service.CategoryService;
import service.ProductService;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/manager")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductService();
	private CategoryService categoryService = new CategoryService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch(action) {
		default:
			displayAllProductandCategory(request, response);
			break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch(action) {
		case "updatePost":
			updatePost(request, response);
			break;
		case "createPost":
			createPost(request, response);
			break;
		}
	}
	
	private void displayAllProductandCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = productService.getProducts();
		List<Category> categories = categoryService.getCategories();
		request.setAttribute("categories", categories);
		request.setAttribute("products", products);
		request.getRequestDispatcher("jsp/ManagerProduct.jsp").forward(request, response);
	}    
	
	
	private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String image = request.getParameter("image");
		String description = request.getParameter("description");
		int categoryId = Integer.parseInt(request.getParameter("cId"));
		Category category = categoryService.getById(categoryId);
		productService.createProduct(new Product(name, price, quantity, image, description, category, 0));
		response.sendRedirect("manager");
	}
	

	private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String image = request.getParameter("image");
		String description = request.getParameter("description");
		int categoryId = Integer.parseInt(request.getParameter("cId"));
		Category category = categoryService.getById(categoryId);
		productService.updateProduct(id, new Product(id, name, price, quantity, image, description, category, 0));
		response.sendRedirect("manager");
	}
}
