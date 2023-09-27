<%@page import="tw.ws1.classes.Bike"%>
<%
	String x = request.getParameter("x");
	Bike b2 = (Bike) request.getAttribute("bike");
%>

	<h1>test big company123</h1>
<%=x%>
<%=b2 %>
