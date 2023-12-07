package com.kjw.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MovieDetailC")
public class MovieDetailC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 클릭한 영화를 조회하는 일
//		MovieDAO.getMovie(request);
		
		MovieDAO.getMovie(request);
		
		// 뭘로 세팅?
		request.setAttribute("contentPage", "jsp/movie/movie_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
