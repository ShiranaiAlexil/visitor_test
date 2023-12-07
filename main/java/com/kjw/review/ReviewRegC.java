package com.kjw.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReviewRegC")
public class ReviewRegC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 입력 받으러 보내주기만 함
		request.getRequestDispatcher("jsp/review/reviewSU.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReviewDAO.RegReview(request);
		
//		ReviewDAO.getAllreview(request);

		// 값 가져오기
ReviewDAO.RegReview(request);
		
//		ReviewDAO r = ReviewDAO.getRdao();

		// 값 보여주기
//		r.getAllreview(request);

		// 돌아가기
		request.setAttribute("contentPage", "jsp/review/review.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
