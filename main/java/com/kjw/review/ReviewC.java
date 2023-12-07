package com.kjw.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReviewC")
public class ReviewC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		ReviewDAO.getAllreview(request);

		// 값 가져오기
//		ReviewDAO r = ReviewDAO.getRdao();

		// 값 보여주기
//		r.getAllreview(request);

//		ReviewDAO.getReview(request);
//		ReviewDAO.paging(1, request);

//		ReviewDAO2.RDAO.getAllreview(request);
		
		ReviewDAO3.RDAO.getAllreview(request);
		ReviewDAO3.RDAO.paging(1, request);
		
		request.setAttribute("contentPage", "jsp/review/review.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
