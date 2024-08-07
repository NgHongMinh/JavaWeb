package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AccountDAO;
import model.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private AccountService accountService = new AccountService();
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            AccountDAO dao = new AccountDAO();
            Account a = dao.Login(user, pass);
            if (a != null) {
            	HttpSession session = request.getSession();
            	session.setAttribute("acc", a);
            	session.setMaxInactiveInterval(1000);
                response.sendRedirect("products");     
            } else {
            	request.setAttribute("mess1", "Wrong user or pass");    
            	request.getRequestDispatcher("jsp/login.jsp").forward(request, response);  
            }
            
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
