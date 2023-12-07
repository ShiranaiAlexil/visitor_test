package com.kjw.review;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kjw.main.DBManager;
import com.kjw.movie.Movie;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewDAO2 {

	private ArrayList<Review> reviews;

	public static final ReviewDAO2 RDAO = new ReviewDAO2();

	private  ReviewDAO2() {
	}

//	public static ReviewDAO getRdao() {
//		return RDAO;
//	}

	public void paging(int page, HttpServletRequest request) {
		request.setAttribute("curPageNo", page);
		int cut = 5; // 한 페이지 당 보여줄 갯수
		int total = reviews.size(); // 총 데이터 갯수
		// null?????

		// 총페이지 갯수
		int pageCount = (int) Math.ceil((double) total / cut);
		request.setAttribute("pageCount", pageCount);

		int start = total - (cut * (page - 1));
		int end = (page == pageCount) ? -1 : start - (cut + 1);

		ArrayList<Review> items = new ArrayList<Review>();
		for (int i = start - 1; i > end; i--) {
			items.add(reviews.get(i));
		}
		request.setAttribute("reviews", items);

	}

	public void getAllreview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from review_test";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Review r = null;
			reviews = new ArrayList<Review>();
			while (rs.next()) {
				r = new Review();
				r.setR_no(rs.getInt("r_no"));
				r.setR_title(rs.getString("r_title"));
				r.setR_txt(rs.getString("r_txt"));
				r.setR_date(rs.getDate("r_date"));
				reviews.add(r);
			}
//			request.setAttribute("reviews", reviews);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void RegReview(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into review_test values(review_test_seq.nextval, ?, ?, sysdate)";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String title = request.getParameter("title");
			String txt = request.getParameter("txt");

			pstmt.setString(1, title);
			pstmt.setString(2, txt);

			System.out.println(title);
			System.out.println(txt);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성골");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void getReview(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from review_test where r_no=?";
		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();

			System.out.println("----------");
			System.out.println(rs);
			System.out.println("----------");

			if (rs.next()) {
				Review r = new Review();
				r.setR_no(rs.getInt("r_no"));
				r.setR_title(rs.getString("r_title"));
				r.setR_txt(rs.getString("r_txt"));
				r.setR_date(rs.getDate("r_date"));
				request.setAttribute("review", r);

				System.out.println("rrrrrrrrrrrrr");
				System.out.println(r);
				System.out.println("rrrrrrrrrrrrr");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void reviewDelete(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete review_test where r_no=?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제 성공");
				request.setAttribute("r", "삭제 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

}
