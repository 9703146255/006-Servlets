package in.thiru;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondSevlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("2nd servlet destroy() method executed..............");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("2nd servlet getServletConfig() method executed..............");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("2nd servlet getServletInfo() method executed..............");
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2nd servlet init() method executed..............");
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
		PrintWriter writer = res.getWriter();
		writer.write("this is reqqqqqqqqqqqqqqqq");
	}

}
