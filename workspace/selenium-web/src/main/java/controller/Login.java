package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logindemo")
public class Login extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().print("funge");
		//response.sendRedirect("login.jsp");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("username")!= null && request.getParameter("password")!=null) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if (username.equals("mauro") && password.equals("12345")) {
				System.out.println("sei loggato");
				
			} else {
				System.out.println("non sei loggato");
				doGet(request, response);
			}
			
		}
		
	}

}
