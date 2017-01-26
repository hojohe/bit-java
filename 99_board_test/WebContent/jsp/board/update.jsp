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
		
		<h3>게시판 수정</h3>
		<h4>게시물 수정이 완료되었습니다. </h4>
		<a href="${pageContext.request.contextPath}/board/list">목록</a>
	</div>
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp" />
	</div>
	
</div>
</body>
</html>