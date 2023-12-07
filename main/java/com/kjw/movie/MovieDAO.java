package com.kjw.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.kjw.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MovieDAO {

	private  ArrayList<Movie> movies;
	private static final MovieDAO MDAO = new MovieDAO();

	private MovieDAO() {
		// TODO Auto-generated constructor stub
	}

	public static MovieDAO getMdao() {
		return MDAO;
	}

	public void paging(int page, HttpServletRequest request) {
		request.setAttribute("curPageNo", page);
		int cut = 3; // 한 페이지 당 보여줄 갯수
		int total = movies.size(); // 총 데이터 갯수

		// 총페이지 갯수
		int pageCount = (int) Math.ceil((double) total / cut);
		request.setAttribute("pageCount", pageCount);

		int start = total - (cut * (page - 1));
		int end = (page == pageCount) ? -1 : start - (cut + 1);

		ArrayList<Movie> items = new ArrayList<Movie>();
		for (int i = start - 1; i > end; i--) {
			items.add(movies.get(i));
		}
		request.setAttribute("movies", items);

	}

	public void getAllMovie(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from movie_test";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Movie m = null;
			movies = new ArrayList<Movie>();
			while (rs.next()) {
				m = new Movie();
				m.setM_no(rs.getInt("m_no"));
				m.setM_title(rs.getString("m_title"));
				m.setM_story(rs.getString("m_story"));
				m.setM_img(rs.getString("m_img"));
				m.setM_actor(rs.getString("m_actor"));
				movies.add(m);
			}
			request.setAttribute("movies", movies);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void deleteMovie(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete movie_test where m_no=?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("nooo"));
			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제 성골");
				request.setAttribute("r", "삭제 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public static void getMovie(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from movie_test where m_no=?";
		
		
		try {
			request.setCharacterEncoding("utf-8");
			// 위의 친구는 아마 한글 가능하도록...?
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Movie m = new Movie();
				m.setM_no(rs.getInt("m_no"));
				m.setM_title(rs.getString("m_title"));
				m.setM_story(rs.getString("m_story"));
				m.setM_img(rs.getString("m_img"));
				m.setM_actor(rs.getString("m_actor"));
				request.setAttribute("movie", m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void regMovie(HttpServletRequest request) {
		// 값, 껍데기

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into movie_test values(movie_test_seq.nextval, ?, ?, ?, ?)";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			// 물음표 채우기 값 받기

			String path = request.getServletContext().getRealPath("jsp/movie/saveFile");

			MultipartRequest mr = new MultipartRequest(request, path, // 저장 경로
					30 * 1024 * 1024, // 지금은 10mb, 파일 최대 허용 용량(넘으면 예외) 단위는 바이트
					"utf-8", new DefaultFileRenamePolicy() // 이건 파일명이 겹칠 경우 이름을 순서대로 재정의해주는 친구다
			);
			String title = mr.getParameter("title");
			String actor = mr.getParameter("actor");
			String story = mr.getParameter("story");

			String fName = mr.getFilesystemName("file");

			System.out.println(title);
			System.out.println(actor);
			System.out.println(story);
			System.out.println(fName);

			pstmt.setString(1, title);
			pstmt.setString(2, actor);
			pstmt.setString(3, fName);
			pstmt.setString(4, story);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성골");
				request.setAttribute("r", "등록 성공!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void updateMovie(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update movie_test set m_title=?, m_story=?, m_actor=? where m_no=?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("t"));
			pstmt.setString(2, request.getParameter("a"));
			pstmt.setString(3, request.getParameter("s"));
			pstmt.setString(4, request.getParameter("no"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("수정 성골");
				request.setAttribute("r", "수정 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

}
