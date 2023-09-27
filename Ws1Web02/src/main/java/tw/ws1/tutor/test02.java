package tw.ws1.tutor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test02
 */
@WebServlet("/test02")
public class test02 extends HttpServlet {
	private int i;
	public test02() {
		System.err.println("test02()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("hello"+ i++);
	}

}
