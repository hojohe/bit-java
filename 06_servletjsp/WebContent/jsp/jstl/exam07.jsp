<%@ page contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<c:set var="msg" value="fn test" />
	fn.length : <c:out value="${fn:length(msg)}" /><br><br>
	fn:substring : <c:out value="${fn:substring(msg, 0, 1)}"/><br><br>
	fn:substring : <c:out value="${fn:substring(msg, 1, 2)}"/><br><br>
	fn:substring : <c:out value="${fn:substring(msg, 5, -1)}"/><br><br>
	fn:replace : <c:out value="${fn:replace(msg, 'fn', 'test')}"/><br><br>
	fn:indexOf : <c:out value="${fn:indexOf(msg, 'es')}"/><br><br>
	fn:startsWith : <c:out value="${fn:startsWith(msg, 'fn')}"/><br><br>
	fn:endsWith : <c:out value="${fn:endsWith(msg, 'est')}"/><br><br>
	fn:contains : <c:out value="${fn:contains(msg, 'est')}"/><br><br>
</body>
</html>