<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="text" name="msg" /><br>
		<input type="file" name="attachFile" /><br>
		<button>전송</button>	
	</form>
</body>
</html>