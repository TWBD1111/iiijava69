package tw.ws1.tutor;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test11
 */
@WebServlet("/test11")
public class test11 extends HttpServlet {
	
    
    public test11() {
       System.out.println("test11");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		doGet(request, response);
		System.out.println("dopost");
	}


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service1");
		if(req.getMethod().equals("GET")) {
			
		}else if(req.getMethod().equals("POST")) {
			
		}
		super.service(req, resp);
	}


	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service2");
		super.service(req, res);
	}


	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
//		super.init();
	}


	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		super.init(config);
		System.out.println("ServletConfig");
	}
	

}
