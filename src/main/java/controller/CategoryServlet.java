package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import model.Category;
import model.Product;
import service.CategoryService;
/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService categoryService = new CategoryService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cateId = request.getParameter("cid");
		ProductDAO dao = new ProductDAO();
		List<Product> list = dao.findByCategory(cateId);
		List<Category> categories = categoryService.getCategories();
		request.setAttribute("categories", categories);
		request.setAttribute("products", list);
		request.getRequestDispatcher("jsp/Home.jsp").forward(request, response);
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch(action) {
			case "createPost":
				createPost(request, response);
				break;
			case "updatePost":
				updatePost(request, response);
				break;
		}
	}
	
	private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		categoryService.createCategory(new Category(name,0));
		response.sendRedirect("manager");
	}
	
	private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		categoryService.updateCategory(id, new Category(id, name,0));
		response.sendRedirect("manager");
	}
}