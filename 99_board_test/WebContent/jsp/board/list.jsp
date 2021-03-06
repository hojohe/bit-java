<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="header">
		<c:import url="/jsp/include/topMenu.jsp" />
	</div>
	<div class="content">
		<h3>게시판</h3>

		<c:choose>
		
			<c:when test="${empty board}">
				<h4>등록된 게시물이 없습니다.</h4>
			</c:when>
			
			<c:otherwise>
				<table>
					<c:forEach var="board" items="${board}">
						<tr>
							<td><c:out value="${board.no}" /></td>
							<td><a href="${pageContext.request.contextPath}/board/detail?no=${board.no}"><c:out value="${board.title}" /></a></td>
							<td><c:out value="${board.writer}" /></td>
							<td><c:out value="${board.regDate}" /></td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
			
		</c:choose>
		
		<a href="${pageContext.request.contextPath}/board/writeForm">글쓰기</a>
		
	</div>
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp" />
	</div>
</div>
<script>
	$.ajax({
		url: "",
		data: {},
		dataType: "",
	}).done(function () {
		
	});
</script>
</body>
</html>