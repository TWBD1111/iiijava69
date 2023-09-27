package tw.ws1.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test16
 */
@WebServlet("/test16")
public class test16 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("test17");
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Brad Cpmpany16</h1>");
		out.println("<hr/>");
		dis.forward(request, response);
		out.println("<hr/>");
		out.println("Copyleft");
	}

}
