<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("name", "Session Test!");
	session.setAttribute("id", "session ID");
	
	session.setMaxInactiveInterval(60*5);
%>
<script>
	location.href="sessionTest.jsp";
</script>