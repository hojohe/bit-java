<%@page import="quiz.Quiz02"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%
	List<Quiz02> list = new ArrayList<>();
	Quiz02 q = new Quiz02();
	q.setMsg("성공");
	list.add(q);
	
	pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<%--
		실행시 화면에 "성공이라고 뜨도록 코딩 작성"
	--%>
	${list[0].msg}
</body>
</html>