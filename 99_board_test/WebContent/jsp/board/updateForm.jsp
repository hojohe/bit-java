<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		
		<h3>게시판 수정</h3>
		
		<form action="${pageContext.request.contextPath}/board/update" method="post">
			<input type="hidden" name="no" value="${board.no}" />
			제목 : <input type="text" name="title" value="${board.title}" /><br>
			글쓴이: <c:out value="${board.writer}" /><br>
			내용 : <br>
			<textarea rows="5" cols="70" name="content"><c:out value="${board.content}" /></textarea><br>
			<br><br>
			<input type="submit" value="등록" />
		</form>
		
		<a href="${pageContext.request.contextPath}/board/list">목록</a>
		
	</div>
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp" />
	</div>
	
</div>
</body>
</html>