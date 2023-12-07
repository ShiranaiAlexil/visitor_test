package com.kjw.visitor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjw.movie.MovieDAO;

@WebServlet("/VisitorC")
public class VisitorC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VisitorDAO.countVistor(request);

//		MovieDAO m = MovieDAO.getMdao();
//		m.getAllMovie(request);

		request.setAttribute("contentPage", "jsp/visitor/visitor.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

//		request.getParameter("jsp/visitor/visitor.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
