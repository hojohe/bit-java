<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	5 + 5 = <%=5+5%><br>
	5 + 5 = ${5 + 5}<br>
	5 % 5 = ${5 % 3}<br>
	5 mod 5 = ${5 mod 3}<br>
	5 == 5 = ${5 == 5}<br>
	5 == 5 = ${5 eq 5}<br>
	<br>
	empty str : ${empty str}<br>
	empty "" : ${empty ""}<br>
	empty "a" : ${empty "a"}<br>
	<br>
	not empty str : ${not empty str}<br>
	!empty str : ${!empty str}<br>
	<br>
	
</body>
</html>