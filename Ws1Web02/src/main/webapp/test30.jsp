<%@page import="tw.ws1.classes.test19m"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String x = request.getParameter("x");
String y = request.getParameter("y");
String view = "test32";
String viewpage = String.format("%s.jsp", view);

if (x != null && y != null) {
	test19m obj = new test19m(x,y);
	int r = obj.plus();
	request.setAttribute("x", x);
	request.setAttribute("y", y);
	request.setAttribute("r", r+"");
}else{
	request.setAttribute("x", "");
	request.setAttribute("y", "");
	request.setAttribute("r", "");
}
%>
<jsp:forward page="<%=viewpage %>"></jsp:forward>