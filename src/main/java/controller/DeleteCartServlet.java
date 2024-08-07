package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;


/**
 * Servlet implementation class DeleteCartServlet
 */
@WebServlet("/deleteCart")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    int pid = Integer.parseInt(request.getParameter("pid"));
	    @SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) session.getAttribute("cart");
	    if (products != null) {
	    	products.removeIf(product -> product.getId() == pid);
	        session.setAttribute("products", products);
	    } else {
	        // Xử lý trường hợp CProduct là null, có thể ghi log lỗi hoặc thiết lập danh sách sản phẩm rỗng
	        System.err.println("products là null, không thể xóa sản phẩm với pid: " + pid);
	    }
	    response.sendRedirect("showCart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
