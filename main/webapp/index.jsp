<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/movie.js"></script>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/movie.css">
<link rel="stylesheet" href="css/review.css">
</head>
<body>

	<table id="main-tbl">
		<tr>
			<td><a href="HC">Home</a></td>
			<td><a href="Menu2C">[Menu2]</a></td>
			<td><a href="MovieC">[Movie]</a></td>
			<td><a href="ReviewC">[Review]</a></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<table id="site">
					<tr>
						<td><jsp:include page="${contentPage }"></jsp:include></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>








</body>
</html>