<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제</title>
</head>
<body>
	<%
		String cookie_check = request.getHeader("Cookie");
		if(cookie_check == null) {
	%>
	<p>쿠키가 삭제되었습니다.</p>
	<%
		}else{
	%>
	<p>쿠키가 삭제되지 않았습니다. 기존 쿠키를 모두 지운 후 다시 시도해부세요</p>
	<%
		}
	%>
</body>
</html>