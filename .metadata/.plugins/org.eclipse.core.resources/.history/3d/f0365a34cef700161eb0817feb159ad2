<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BoardDAO dao = new BoardDAO();
	BoardVO boardVO = new BoardVO();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	boardVO.setTitle(request.getParameter("title"));
	boardVO.setWriter(request.getParameter("writer"));
	boardVO.setContent(request.getParameter("content"));
	dao.insertBoard(boardVO);
%>	
		
	<h2>게시물 등록이 완료되었습니다.</h2>
	<a href='list.jsp'>목록</a>
</body>
</html>