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
	<h1>
		- Movie Page - <span style="color: red;">${r }</span>
	</h1>

	<form action="MovieRegC" method="post" enctype="multipart/form-data">
		<table id="mTbl">

			<tr>
				<td class="detail-td">Title</td>
				<td><input name="title"></td>
			</tr>
			<tr>
				<td class="detail-td">Actor</td>
				<td><input name="actor"></td>
			</tr>
			<tr>
				<td class="detail-td">File</td>
				<td><input name="file" type="file"></td>
			</tr>
			<tr>
				<td class="detail-td">Story</td>
				<td><textarea name="story"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button>add</button>
				</td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td style="font-size: 50pt; width: 50px;"> 
		
			<c:if test="${curPageNo != 1 }">
			<a href="MoviepageC?p=${curPageNo - 1 }"> ◀-if</a>
		</c:if>
		
		<c:choose>
			<c:when test="${curPageNo != 1 }">
			<a href="MoviepageC?p=${curPageNo - 1 }">	◀-ch</a>
		</c:when>
		<c:otherwise>
			◀-ch
		</c:otherwise>
		</c:choose>
		
			</td>
			
			<td>
			
			<c:forEach var="m" items="${movies }">

		<table id="mTbl2">
			<tr>
				<td id="m_td2" rowspan="4"><img id="movieImg"
					src="jsp/movie/saveFile/${m.m_img }"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td class="m_td1"><span
					onclick="location.href='MovieDetailC?no=${m.m_no}'">${m.m_title }</span></td>
			</tr>
			<tr>
				<td>배우</td>
				<td class="m_td1">${m.m_actor }</td>
			</tr>
			<tr>
				<td>줄거리</td>
				<td class="m_td1">${m.m_story }</td>
			</tr>
			<tr>
				<td>
					<button onclick="deleteMovie('${m.m_no}')">삭제</button>
					<button>수정(img JSP)</button>
					<button
						onclick="updateMovie('${m.m_no}','${m.m_story }','${m.m_title}','${m.m_actor}')">수정(JS)</button>
				</td>
			</tr>
		</table>

	</c:forEach>
			
			</td>
			<td style="font-size: 50pt; width: 50px;"> 
			<a href="MoviepageC?p=${curPageNo + 1 }"> ▶ </a>
			</td>
		</tr>
	</table>

	
	
<c:if test="${curPageNo != 1 }">
<a href="MoviepageC?p=${curPageNo - 1 }">	<button >이전if</button></a>
</c:if>
	



<c:choose>
	<c:when test="${curPageNo != 1 }">
		<a href="MoviepageC?p=${curPageNo - 1 }">	<button >이전choose</button></a>
	</c:when>
	<c:otherwise>
		<button >이전choose</button>
	</c:otherwise>
</c:choose>



<c:if test="${curPageNo != pageCount }">
	<a href="MoviepageC?p=${curPageNo + 1 }">	<button class="butten">다음if</button></a>
</c:if>


<c:choose>
	<c:when test="${pageCount != curPageNo}">
		<a href="MoviepageC?p=${curPageNo + 1 }">	<button class="butten">다음choose</button></a>
	</c:when>
	<c:otherwise>
		<button class="butten">다음choose</button>
	</c:otherwise>
</c:choose>



<a href="ReviewPageC?p=1">[맨처음] </a>

	<c:forEach begin="1" end="${pageCount }" var="n">
		<a href="ReviewPageC?p=${n }"> [${n }] </a>
	</c:forEach>
	
<a href="ReviewPageC?p=${pageCount }">[맨끝] </a>

</body>
</html>






