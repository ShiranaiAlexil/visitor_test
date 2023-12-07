package com.kjw.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReviewPageC")
public class ReviewPageC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReviewDAO.getAllreview(request);
		
		int p = Integer.parseInt(request.getParameter("p"));
		ReviewDAO.paging(p, request);

		request.setAttribute("contentPage", "jsp/review/review.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
