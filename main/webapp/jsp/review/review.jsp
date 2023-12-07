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

	<table id="tbl-review" border="1">
		<tr>
			<td class="r-td-title">Review Page</td>
			<td class="r-td-title"><a href="ReviewRegC">글쓰기</a></td>
		</tr>
	</table>
	<table id="tbl-review" border="1">
		<tr>
			<td class="r-td1">제목</td>
			<td class="r-td1">생성일자</td>
			<td class="r-td1">넘버</td>
			<td class="r-td1">내용</td>
		</tr>

	</table>
	<table id="tbl-review" border="1">
		<c:forEach items="${reviews }" var="review">
			<tr>

				<td class="r-td1"><span
					onclick="location.href='ReviewDetailC?no=${review.r_no }'">${review.r_title }</span></td>
				<td>${review.r_date }</td>
				<td>${review.r_no }</td>
				<td>${review.r_txt }</td>
				<!-- 
 -->
			</tr>

		</c:forEach>
	</table>

<a href="ReviewPageC?p=1">[맨처음] </a>

	<c:forEach begin="1" end="${pageCount }" var="n">
		<a href="ReviewPageC?p=${n }"> [${n }] </a>
	</c:forEach>
	
<a href="ReviewPageC?p=${pageCount }">[맨끝] </a>



	<!-- 
아래는 실전용 위는 개발자 확인용
	<table id="tbl-review2">
		<c:forEach items="${reviews }" var="review">
			<tr class="r-tr1">
				<td class="r-td1">${review.r_title }</td>
				<td class="r-td1">${review.r_date }</td>
				<td class="r-td1">${review.r_no }</td>
				<td class="r-td1">${review.r_txt }</td>
			</tr>

		</c:forEach>
	</table>
 -->




</body>
</html>