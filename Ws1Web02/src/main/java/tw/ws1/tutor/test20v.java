package tw.ws1.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.ws1.classes.testUtils;

@WebServlet("/test20v")
public class test20v extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String x = (String) request.getAttribute("x");
		String y = (String) request.getAttribute("y");
		String result = (String) request.getAttribute("result");
		String view = (String) request.getAttribute("view");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String content = testUtils.loadView(view);
			out.printf(content, x, y, result);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
