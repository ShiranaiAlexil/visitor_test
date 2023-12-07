package com.kjw.visitor;

import javax.servlet.http.HttpServletRequest;

public class VisitorDAO {

	public static void countVistor(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		System.out.println("Submitted Username: " + username);

	}

}
