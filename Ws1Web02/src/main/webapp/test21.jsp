<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
if (name == null)
	name = "test";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test big company</h1>
	<hr>
	<div>
		welcome,<%=name%>!
	</div>
</body>
</html>