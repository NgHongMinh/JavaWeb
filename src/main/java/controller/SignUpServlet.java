package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AccountDAO;
//import model.Account;


/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        String user = request.getParameter("user");
	        String pass = request.getParameter("pass");
	        String re_pass = request.getParameter("repass");
	        if(!pass.equals(re_pass)){
	        	request.setAttribute("mess2", "Non-duplicate pass");
	            response.sendRedirect("login");
	        }else{
	            AccountDAO dao = new AccountDAO();
//	            Account a = dao.Checking(user);
//	            if(a == null){
	            	dao.create(user, pass);
	                response.sendRedirect("products");
//	            }else{
//	            	request.setAttribute("mess2", "Username already had");
//	                request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
	            }
//	        }
	        
	    }	    
		

    	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    			throws ServletException, IOException {
    		processRequest(request, response);
    	}
    	
    
    	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    			throws ServletException, IOException {
    		processRequest(request, response);
    	}
    	
	    public String getServletInfo() {
	        return "Short description";
	    }
	
}

