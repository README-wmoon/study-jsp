<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="dao.UserDAO" id="dao"/>
<%
	if(dao.checkId(request.getParameter("id"))) {
		out.println("중복된 아이디입니다.");
	} else {
		out.println("사용 가능한 아이디입니다.");
	}
%>