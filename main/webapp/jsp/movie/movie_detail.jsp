<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>- Movie Detail -</h1>

	<table id="tbl-detail">
		<tr>
			<td colspan="2"><img src="jsp/movie/saveFile/${movie.m_img }"></td>
		</tr>
		<tr>
			<td class="detail-td">No.</td>
			<td>${movie.m_no }</td>
		</tr>
		<tr>
			<td class="detail-td">Title</td>
			<td>${movie.m_title }</td>
		</tr>
		<tr>
			<td class="detail-td">Actor</td>
			<td>${movie.m_actor }</td>
		</tr>
		<tr>
			<td class="detail-td">Story</td>
			<td>${movie.m_story }</td>
		</tr>

	</table>


</body>
</html>










