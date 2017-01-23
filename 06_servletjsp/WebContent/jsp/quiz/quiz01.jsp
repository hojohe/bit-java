<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date" %>
<%-- 
	화면에 현재 시간 정보를 출력한다.
	-------------------------------
	오늘은 2016-08-05 입니다.
	현재 시간은 15:47:01입니다.
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
--------------------------------<br>
오늘은 
<%
	Date d = new Date();
	SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
%>	

<%=day.format(d)%> 입니다.<br>

현재 시간은 <%=time.format(d)%> 입니다.
	
</body>
</html>