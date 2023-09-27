<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<sql:setDataSource 
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost/iii"
	user="root"
	password="root"
/>
<sql:query var="rs">
	SELECT * FROM foods
</sql:query>
<c:set var="rpp">10</c:set>

<c:set var="currentPage" value="${!empty param.page ? param.page : 1}" />

<%-- 計算總頁數 --%>
<c:set var="totalRows" value="${fn:length(rs.rows)}" />
<c:set var="totalPages" value="${Math.ceil(totalRows / rpp)}" />

<%-- 確保當前頁碼在合法範圍內 --%>
<c:choose>
    <c:when test="${currentPage < 1}">
        <c:set var="currentPage" value="1" />
    </c:when>
    <c:when test="${currentPage > totalPages}">
        <c:set var="currentPage" value="${Math.round(totalPages)}" />
    </c:when>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="?page=${currentPage - 1}">上頁</a> | <a href="?page=${currentPage + 1}">下頁</a>
	<table border="1" width="100%">
		<tr>
			<th>#</th>
			<th>Name</th>		
		</tr>
		<c:forEach items="${rs.rows }"  var="row" varStatus="loop">
			<c:if test="${(loop.index >= (currentPage - 1) * rpp) && (loop.index < currentPage * rpp)}">
				<tr>
					<td>${row.id }</td>
					<td>${row.name }</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>