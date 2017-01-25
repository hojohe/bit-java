<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네트워크 게시판</title>
</head>
<body>
<div class="container">

	<div class="header">
		<c:import url="/jsp/include/topMenu.jsp" />
	</div>

	<div class="content">
		<h2>네트워크 게시판</h2>
		전체
		<c:out value="${fn:length(list)}"/>개
		<br>
		<hr>
		<table width='70%' border='1'>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>등록일</th>
			</tr>
	
			<c:forEach var="board" items="${list}">
				<tr>
					<td><c:out value="${board.no}" /></td>
					<c:choose>
						<c:when test="${empty user.userId}">
							<td><c:out value="${board.title}" /></td>
						</c:when>
						<c:otherwise>
							<td><a href='detail?no=<c:out value="${board.no}"/>'><c:out value="${board.title}" /></a></td>
						</c:otherwise>
					</c:choose>
					<td><c:out value="${board.writer}" /></td>
					<td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				</tr>
			</c:forEach>
	
			<c:if test="${empty list}">
				<tr>
					<td colspan='4'>입력된 게시물이 없습니다.</td>
				</tr>
			</c:if>
		</table>
		
		<c:choose>
			<c:when test="${not empty user.userId}">
				<a href='${pageContext.request.contextPath}/board/writeForm'>글쓰기</a>
			</c:when>
		</c:choose>
	</div>		
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp"/>
	</div>
	
</div>
</body>
</html>




