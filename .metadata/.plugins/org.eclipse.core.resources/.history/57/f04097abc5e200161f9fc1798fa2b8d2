<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<h1>메인 페이지~!</h1>
	
	<c:choose>
		<c:when test="${empty user}">
			<h2><a href="loginForm.jsp">로그인</a></a></h2>
		</c:when>
		<c:otherwise>
			<h2><a href="logout">로그아웃</a></h2>
		</c:otherwise>
	</c:choose>
	
</body>
</html>