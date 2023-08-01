package tw.ws1.tutor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.ws1.classes.test19m;

@WebServlet("/test18c")
public class test18c extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.接收參數
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		if (x != null && y != null) {

			// 2.演算法
			try {
				test19m model = new test19m(x, y);
				int result = model.plus();
				request.setAttribute("x", x);
				request.setAttribute("y", y);
				request.setAttribute("result", result+"");
				request.setAttribute("view", "view2");
				// 3. view
				RequestDispatcher dispatcher = request.getRequestDispatcher("test20v");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			request.setAttribute("x", "");
			request.setAttribute("y", "");
			request.setAttribute("result", "");
			request.setAttribute("view", "view1");
			RequestDispatcher dispatcher = request.getRequestDispatcher("test20v");
			dispatcher.forward(request, response);
		}

	}

}
