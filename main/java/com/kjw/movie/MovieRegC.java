package com.kjw.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MovieRegC")
public class MovieRegC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 등록하는 일
//		MovieDAO.regMovie(request);
		MovieDAO.getMdao().regMovie(request);
		
		
		// 뭘로세팅?
//		MovieDAO.getAllMovie(request);
		MovieDAO.getMdao().getAllMovie(request);
		request.setAttribute("contentPage", "jsp/movie/movie.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
//		response.sendRedirect("MovieC");
	}

}
