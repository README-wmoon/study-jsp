<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<%
		String id = "";
		String pw = "";
		
		String cookie_check = request.getHeader("Cookie");
		if(cookie_check != null) {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("id")){
					id = cookie.getValue();
				}else if(cookie.getName().equals("pw")){
					pw = cookie.getValue();
				}
			}
		}
	%>

	<form action="login_ok.jsp" method="post">
		아이디: <input type="text" name="id" value="<%=id%>">
		<br>비밀번호: <input type="password" name="pw" value="<%=pw%>">
		<button>로그인</button>
	</form>
</body>
</html>