<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int START,ROWS,COLS;
	String row = request.getParameter("row");
	String col = request.getParameter("col");
	String start = request.getParameter("start");
	try{
		ROWS = Integer.parseInt(row);
		COLS = Integer.parseInt(col);
		START = Integer.parseInt(start);
	}catch(Exception e){
		ROWS = 2;
		COLS =4;
		START = 2;
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		Row: <input type="number" name="row">
		Column: <input type="number" name="col">
		Start: <input type="number" name="start">
		<input type="submit" value="change">
	
	
	</form>

	
	
	<table border="1" width="100%">	
			
		<%

		for(int k=0 ;k<ROWS;k++){
			out.println("<tr>");
			for(int j=START ;j<=(START+COLS-1);j++){
				int newj = j+k*COLS;
				if(k%2==0){
					if(j%2==0){
						out.println("<td bgcolor='pink'>");
					}else{
						out.println("<td bgcolor='yellow'>");
					}
				}else{
					if(j%2==0){
						out.println("<td bgcolor='yellow'>");
					}else{
						out.println("<td bgcolor='pink'>");
					}
				}
				for(int i = 1;i<=9;i++){
					int r = newj* i;
					out.println(String.format("%d x %d = %d <br>",newj,i,r));
				}
			
				out.println("</td>");
			}
			out.println("</tr>");
		}
		%>
		
	
	
	</table>
</body>
</html>