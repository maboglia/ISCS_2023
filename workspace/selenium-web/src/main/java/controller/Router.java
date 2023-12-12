package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/home", "/index", "/"})
public class Router extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Router() {
    	System.out.println("Servlet Router costruita");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().print("mi hai chiamato via get");
		request.setAttribute("titolo", "Home Page");
		request.getRequestDispatcher("header.jsp").include(request, response);

		response.getWriter().print("<h1>Sei in home page</h1>");
		
		request.getRequestDispatcher("footer.jsp").include(request, response);

		
	}

}
