<%@page import="com.jspex.beans.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="com.jspex.beans.MemberVO" id="vo"/>
<jsp:useBean class="com.jspex.beans.MemberDAO" id="dao"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈 예제</title>
</head>
<body>
	<!-- HTNK 주석은 컴파일을 막지 않고 보여주는 부분만 주석처리해준다. -->
	<%-- 
		JSP 주석은 컴파일도 주석처리 된다.
	 --%>
	<%--<jsp:setProperty property="name" name="vo" value="한동석"/>
	<jsp:setProperty property="birthday" name="vo" value="12-04"/>
	--%>
	<%
		ArrayList<MemberVO> members = dao.select("한동석");
	%>
	<table border=1>
		<%for(int i=0; i<members.size(); i++) {%>
		<jsp:setProperty property="name" name="vo" value="<%=members.get(i).getName() %>"/>
		<jsp:setProperty property="birthday" name="vo" value="<%=members.get(i).getBirthday() %>"/>		
		<tr>
			<%--<td><%=members.get(i).getName()%></td>--%>
			<%--<td><%=members.get(i).getBirthday()%></td>--%>
			<td><jsp:getProperty property="name" name="vo"/></td>
			<td><jsp:getProperty property="birthday" name="vo"/></td>
		</tr>
		<%} %>
	</table>
	
	<%--
	<jsp:getProperty property="name" name="vo"/>
	<jsp:getProperty property="birthday" name="vo"/>
	--%>
	
	
</body>
</html>