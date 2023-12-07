<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>- 리뷰 디테일 페이지 -</h1>

	<table id="tbl-detail" border="1">
		<tr>
			<td class="detail-td">리뷰 등록 번호</td>
			<td>${review.r_no }</td>
		</tr>
		<tr>
			<td class="detail-td">제목</td>
			<td>${review.r_title }</td>
		</tr>
		<tr>
			<td class="detail-td">등록 일자</td>
			<td>${review.r_date }</td>
		</tr>
		<tr>
			<td class="detail-td">내용</td>
			<td>${review.r_txt }</td>
		</tr>
	</table>



	<button>수정버튼</button>
	<button onclick="location.href='ReviewDeleteC?no=${param.no }'">삭제버튼</button>

</body>
</html>










