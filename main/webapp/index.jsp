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



<SCRIPT LANGUAGE=JAVASCRIPT TYPE="TEXT/JAVASCRIPT">
	expireDate = new Date
	expireDate.setMonth(expireDate.getMonth() + 6)
	hitCt = eval(cookieVal("pageHit"))
	hitCt++
	document.cookie = "pageHit=" + hitCt + ";expires="
			+ expireDate.toGMTString()

	function cookieVal(cookieName) {
		thisCookie = document.cookie.split("; ")
		for (i = 0; i < thisCookie.length; i++) {
			if (cookieName == thisCookie[i].split("=")[0]) {
				return thisCookie[i].split("=")[1]
			}
		}
		return 0
	}
</SCRIPT>

<SCRIPT LANGUAGE=JAVASCRIPT TYPE="TEXT/JAVASCRIPT">
	document.write("제 홈페이지에 <font color=red>" + hitCt + "</font> 번째 방문자이시네요.")
</SCRIPT>




</head>
<body>


	<a href="https://hits.seeyoufarm.com"><img
		src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=http%3A%2F%2Flocalhost%2F64_board%2FHC&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false" /></a>


	<a href="http://localhost/64_board/HC">asds</a>




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