package com.kjw.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjw.movie.MovieDAO;

@WebServlet("/ReviewDeleteC")
public class ReviewDeleteC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		ReviewDAO3.RDAO.reviewDelete(request);
		
		request.setAttribute("contentPage", "jsp/review/review_delete.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
