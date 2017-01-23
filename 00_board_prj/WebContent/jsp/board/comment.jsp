<%@ page contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
<div class="container">

	<div class="header">
		<c:import url="/jsp/include/topMenu.jsp" />
	</div>

	<div class="content">
		<h2><c:out value="${msg}" /></h2>
		<a href='${pageContext.request.contextPath}/board/list'>목록</a>
	</div>
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp" />
	</div>

</div>	
</body>
</html>