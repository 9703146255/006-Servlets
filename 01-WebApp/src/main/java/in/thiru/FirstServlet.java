package in.thiru;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {

	@Override
	public void destroy() {
		System.out.println("destroy() method.............");

	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("  getServletConfig() method.............");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo() method.............");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init() method.............");

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service() method............");
		
		PrintWriter writer = res.getWriter();
		writer.write("<h1>WELCOME TO ASHOKIT......................................................</h1>");
		writer.write("<h1>WELCOME TO ASHOKIT......................................................</h1>");
		writer.write("<h1>WELCOME TO ASHOKIT......................................................</h1>");
		writer.write("<h1>WELCOME TO ASHOKIT......................................................</h1>");
		writer.write("<h1>WELCOME TO ASHOKIT......................................................</h1>");
		writer.write("<h1>WELCOME TO ASHOKIT......................................................</h1>");
		writer.write("<h1>WELCOME TO ASHOKIT......................................................</h1>");
		writer.write("<h1>WELCOME TO ASHOKIT......................................................</h1>");
		
		

	}

}
