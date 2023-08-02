<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="tw.ws1.classes.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<input name="x" value="${param.x}"> 
		<select>
			<option>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
			
		</select>
		<input name="y" value="${param.y}">
		<input type="submit" value="=">
		<span>${testUtils.calc(param.x,param.y)}</span>
	</form>
</body>
</html>