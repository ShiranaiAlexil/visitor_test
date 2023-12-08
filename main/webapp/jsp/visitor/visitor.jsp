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

	<form id="myForm" action="VisitorC" method="get">
		<input type="hidden" id="usernameInput" name="username"> <input
			type="submit" value="Submit">
	</form>

</body>
</html>