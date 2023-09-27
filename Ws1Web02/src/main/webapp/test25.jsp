<%@page import="tw.ws1.classes.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	Bike b1= new Bike("test");
	request.setAttribute("bike", b1);
	b1.upSpeed();b1.upSpeed();b1.upSpeed();
	
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
	<%@ include file="test26.jsp"%>
	<hr>
	<jsp:include page="test27.jsp">
		<jsp:param value="100" name="x"/>
		<jsp:param value="33" name="y"/>
			
	</jsp:include>

</body>
</html>