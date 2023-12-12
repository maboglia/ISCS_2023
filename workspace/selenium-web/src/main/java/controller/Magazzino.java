package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repos.MagliaDAO;

import java.io.IOException;

@WebServlet("/magazzino")
public class Magazzino extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MagliaDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Magazzino() {
    	System.out.println("Servlet Magazzino costruita");
    	this.dao = new MagliaDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().print("mi hai chiamato via get");
		request.setAttribute("titolo", "Magazzino Page");
		request.getRequestDispatcher("header.jsp").include(request, response);

		request.setAttribute("maglie", dao.getMaglie());
		
		request.getRequestDispatcher("magazzino.jsp").include(request, response);
		
		request.getRequestDispatcher("footer.jsp").include(request, response);

		
	}

}
