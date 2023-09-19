<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login_ok.jsp" name="loginForm" method="post">
		<p>
			<label>
				아이디 : <input type="text" name="id">		
			</label>
		</p>
		<p>
			<label>
				비밀번호 : <input type="password" name="password">		
			</label>
		</p>
		<p>
			<input type="button" value="로그인" onclick="login()">
		</p>
	</form>
</body>
<script>
	function login() {
		var form = document.loginForm;
		if(!form.id.value) {
			alert("아이디를 입력해주세요.");
			return;
		}
		if(!form.pw.value) {
			alert("비밀번호를 입력해주세요.");
			return;
		}
		form.submit();
	}
</script>
</html>