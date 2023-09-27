<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String[] var1 = { "test", "OK", "III" };
pageContext.setAttribute("var1", var1);
String[] var2 = { "test2", "OK2", "III2" };
request.setAttribute("var1", var2);
String[] var3 = { "test3", "OK3", "III3" };
session.setAttribute("var1", var3);
String[] var4 = { "test4", "OK4", "III4" };
application.setAttribute("var1", var4);

LinkedList<String> list =new LinkedList<>();
list.add("test5");list.add("OK5");list.add("III5");
pageContext.setAttribute("list", list);

HashMap<String,String> map = new HashMap<>();
map.put("k1","v1");map.put("k2","v2");map.put("k2","v2");
pageContext.setAttribute("map", map);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	var1[0]: ${var1[0] }<br>
	var1[0]: page ${pageScope.var1[0] }<br>
	var1[0]: request ${requestScope.var1[0] }<br>
	var1[0]: session ${sessionScope.var1[0] }<br>
	var1[0]: application ${applicationScope.var1[0] }<br>
	list.get(0): ${list[0] } <br>
	list.get(i): ${list[param.i] } <br>
	map.get("k1"): ${map["k1"] }<br>
	map.get("k2"): ${map.k2 }<br>
	
	${10+3 } <br>
	${param.x + param.y } <br>
	${param.x == param.y } <br>
	
	
	
	
</body>
</html>