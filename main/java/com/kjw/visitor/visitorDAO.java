package com.kjw.visitor;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisitorDAO {

	public static void countVistor(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		System.out.println("Submitted Username: " + username);

	}

	
	   public static void countVistor2(HttpServletRequest request, String[] args) {

		   
		   // 가상의 방문 기록 데이터 (실제로는 데이터베이스 또는 로그 파일에서 가져와야 함)
	        String[] visitedPages = {
	            "/home",
	            "/products",
	            "/home",
	            "/contact",
	            "/products",
	            "/about",
	            "/products",
	            "/home"
	        };

	        // 페이지 방문 횟수를 저장할 HashMap
	        HashMap<String, Integer> pageCounts = new HashMap<>();

	        // 방문 기록을 분석하여 페이지 방문 횟수 계산
	        for (String page : visitedPages) {
	            pageCounts.put(page, pageCounts.getOrDefault(page, 0) + 1);
	        }

	        // 결과 출력
	        System.out.println("인기 있는 페이지:");

	        for (String page : pageCounts.keySet()) {
	            int count = pageCounts.get(page);
	            System.out.println(page + ": " + count + "번 방문");
	        }
	    }
	
	   
	   public static void countVistor3(HttpServletRequest request, HttpServletResponse response) {

		   
		   // 쿠키 생성
		   Cookie cookie = new Cookie("cookieName", "value1");

		   // 쿠키 값 재설정
		   cookie.setValue("value2");

		   // 쿠키 유지 시간 설정(초단위)
		   cookie.setMaxAge(10); 

		   // 쿠키를 클라이언트로 전송
		   response.addCookie(cookie);
		   
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   public static void asd(HttpServletRequest request) {
	   
	   
	   Cookie[] cookies = request.getCookies(); //client에서 쿠키를 받아옴

	   String cookieName = "";
	   String cookieValue = "";

	   if(cookies!=null){
	       for(int i=0;i<cookies.length;i++){
	           if(cookies[i].getName().equals("cookieName")){
	               cookieName = cookies[i].getName();
	               cookieValue = cookies[i].getValue();
	           }
	       }
	   }
	   
	   }	   
}
