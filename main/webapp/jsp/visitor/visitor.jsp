<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>





</head>
<body>


	<form action="VisitorC">
		<div style="background: lime;">방문자 수 : ${visitor }</div>
	</form>

	<img
		src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=http%3A%2F%2Flocalhost%2F64_board%2FHC&count_bg=%23000000&title_bg=%239B0000&icon=&icon_color=%23FFFFFF&title=%EB%B0%A9%EB%AC%B8%EC%9E%90+%EC%88%98&edge_flat=true" />

	<a href="https://hits.seeyoufarm.com"><img
		src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=http%3A%2F%2Flocalhost%2F64_board%2FHC&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false" /></a>

	<img
		src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=http%30A%2F%2Flocalhost%2F64_board%2FHC&count_bg=%2379C83D&edge_flat=false" />



	<SCRIPT LANGUAGE=JAVASCRIPT TYPE="TEXT/JAVASCRIPT">
		expireDate = new Date;
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
		document.write("제 홈페이지에 <font color=red>" + hitCt
				+ "</font> 번째 방문자이시네요.")
	</SCRIPT>



</body>
</html>