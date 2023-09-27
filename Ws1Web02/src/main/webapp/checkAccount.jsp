<%@page import="tw.ws1.classes.Member"%>
<%@page import="tw.ws1.classes.BCrypt"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//接收參數
	request.setCharacterEncoding("UTF-8");
	String account = request.getParameter("account");
	String passwd = request.getParameter("passwd");
	//連接資料庫
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost/iii","root","root");
	//判斷帳號是否存在
	
	String sql ="SELECT * FROM member WHERE account = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, account);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()){
		//取出密碼比對
		
		String hasPasswd = rs.getString("passwd");
		if(BCrypt.checkpw(passwd, hasPasswd)){
			Member member = new Member(rs.getInt("id"),
					rs.getString("account"),rs.getString("cname"),null);
			session.setAttribute("member", member);
			session.setMaxInactiveInterval(600);
			response.sendRedirect("main.jsp");
		}else{
			session.invalidate();
			response.sendRedirect("login.html");
		}
		
	}else{
		session.invalidate();
		response.sendRedirect("login.html");
	}

%>