<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String x = request.getParameter("x");
String y = request.getParameter("y");
String op = request.getParameter("op");
String r = "";
try {
	int intx = Integer.parseInt(x);
	int inty = Integer.parseInt(y);
	switch (op) {
	case "1":
		r += (intx + inty);
		break;
	case "2":
		r += (intx - inty);
		break;
	case "3":
		r += (intx * inty);
		break;

	case "4":
		r += (intx / inty);
		break;
	}
} catch (Exception e) {
	x = y = op= "";
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="test23.jsp">
		<input name="x" value="<%=x%>">
		 <select name="op">
			<option value="1" <%= op.equals("1")?"selected":"" %>>+</option>
			<option value="2" <%= op.equals("2")?"selected":"" %>>-</option>
			<option value="3" <%= op.equals("3")?"selected":"" %>>*</option>
			<option value="4" <%= op.equals("4")?"selected":"" %>>/</option>

		</select> 
		<input name="y" value="<%=y%>"> 
		<input type="submit" value="="> 
		<span><%=r%></span>
	</form>
</body>
</html>