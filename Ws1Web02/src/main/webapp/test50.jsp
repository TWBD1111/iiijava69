<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int lottery =(int)(Math.random()*49+1);
	session.setAttribute("lottery", lottery);
	pageContext.setAttribute("lottery", lottery);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	i am test 50 <hr>
	${lottery }
	<hr>
	<a href="test51.jsp">test51</a>
</body>
</html>