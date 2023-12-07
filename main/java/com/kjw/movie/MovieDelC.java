package com.kjw.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MovieDelC")
public class MovieDelC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		MovieDAO.deleteMovie(request);
		

		
		MovieDAO.getMdao().deleteMovie(request);
		
		request.setAttribute("contentPage", "jsp/movie/movie.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
