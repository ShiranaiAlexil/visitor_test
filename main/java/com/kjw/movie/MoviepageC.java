package com.kjw.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MoviepageC")
public class MoviepageC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
//		MovieDAO.getAllMovie(request);
		MovieDAO.getMdao().getAllMovie(request);		
		int p = Integer.parseInt(request.getParameter("p"));
//	수정요망	MovieDAO.paging(p, request);

		request.setAttribute("contentPage", "jsp/movie/movie.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
