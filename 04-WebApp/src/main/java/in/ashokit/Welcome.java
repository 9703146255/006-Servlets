package in.ashokit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Welcome extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String salary=req.getParameter("salary");
		
		PrintWriter writer = res.getWriter();
		writer.write("Name   :... :"+name+"<br>");
		writer.write("Age    :... :"+age+"<br>");
		writer.write("Salary :... :"+salary+"<br>");
		
	}

}
