<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="myErrorPage.jsp" info="Date 클래스를 이용한 날짜 출력"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디렉티브 태그 예제</title>
</head>
<body>
	Today is : <%=new Date() %>
	
	<% 
		String data = null;
		data.charAt(0);
	%>
</body>
</html>