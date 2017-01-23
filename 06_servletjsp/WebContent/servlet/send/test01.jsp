<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
String msg = (String)request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<h2><%=msg%></h2>
</body>
</html>