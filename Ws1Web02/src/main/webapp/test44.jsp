<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="tw.ws1.classes.*" %>


<%
	pageContext.setAttribute("x", 10);
%>
<c:set var="x" value="10"></c:set>
<c:set var="x" value="100" scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	x=${x } <br>
	x=${requestScope.x } <br>
	<%="hello" %> <br>
	<c:out value="hello"></c:out><br>
	x=<c:out value="${x }"></c:out><br>
	i=<c:out value="${param.i }" default="no value"></c:out><br>
	<hr>
	<jsp:useBean id="member" class="tw.ws1.classes.Member"></jsp:useBean>
	<jsp:setProperty property="id" name="member" value="3"/> :
	<jsp:setProperty property="account" name="member" value="test"/> 
	<jsp:setProperty property="realname" name="member" value="Test"/>
	<jsp:setProperty property="birthday" name="member" value="1999-02-03"/>

	${member.id } : ${member.account } <br>
	${member }
	<hr>
	<c:remove var="member"/>
	${member }
	<hr>
	<c:set var="test">${testUtils.createMember() }</c:set>
	${test }
	
	<hr />
	<c:set var="brad" value="${testUtils.createMember() }"></c:set>
	${brad }

</body>
</html>