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
		
		String name= req.getParameter("name");
		String email= req.getParameter("email");
		String address= req.getParameter("address");
		
		PrintWriter writer = res.getWriter();
		writer.write("welcome to ashok it ... :"+name);
		writer.write("<br>");
		writer.write("welcome to ashok it ... :"+email);
		writer.write("<br>");
		writer.write("welcome to ashok it ... :"+address);
		
	}

}
