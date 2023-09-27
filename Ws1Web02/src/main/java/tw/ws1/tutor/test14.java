package tw.ws1.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.ws1.classes.Bike;

/**
 * Servlet implementation class test14
 */
@WebServlet("/test14")
public class test14 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("test15");
		
		Bike b1 = new Bike("test");
		request.setAttribute("b1", b1);
		b1.upSpeed();
		b1.upSpeed();
		b1.upSpeed();
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Brad Cpmpany</h1>");
		out.println("<hr/>");
		dis.include(request, response);
		out.println("<hr/>");
		out.println("Copyleft");
		
		
	}


}
