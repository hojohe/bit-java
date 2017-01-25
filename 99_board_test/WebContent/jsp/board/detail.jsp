<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="header">
		<c:import url="/jsp/include/topMenu.jsp" />
	</div>
	
	<div class="content">
		제목 : <c:out value="${board.title}" /><br>
		글쓴이 : <c:out value="${board.writer}" /><br>
		내용 : <c:out value="${board.content}" /><br>
		등록일시 : <fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd hh:mm:ss" /><br>
		<a href="${pageContext.request.contextPath}/board/updateForm?no=${board.no}" >수정</a>
		<a href="${pageContext.request.contextPath}/board/delete?no=${board.no}" >삭제</a>
		<a href="${pageContext.request.contextPath}/board/list" >목록</a>
	</div>
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp" />
	</div>
</div>
</body>
</html>