<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h3>글쓰기</h3>
		
		<form action="${pageContext.request.contextPath}/board/write" method="post">
			제목 : <input type="text" name="title" /><br>
			글쓴이 : <input type="text" name="writer" /><br>
			내용 : 
			<br><textarea name="content" cols="40" rows="5" ></textarea><br>
			<br><input type="submit" value="등록" />
		</form>
		<br><a href="${pageContext.request.contextPath}/board/list">목록</a>
	
	</div>
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp" />
	</div>
</div>
</body>
</html>