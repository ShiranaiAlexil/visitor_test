package com.kjw.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MovieUpdateC")
public class MovieUpdateC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 수정하는 일
//		MovieDAO.updateMovie(request);

		MovieDAO.getMdao().updateMovie(request);
		
		// 뭘로세팅?
//		MovieDAO.getAllMovie(request);
//		request.setAttribute("contentPage", "jsp/movie/movie.jsp");
//		request.getRequestDispatcher("index.jsp").forward(request, response);

		response.sendRedirect("MovieC");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
