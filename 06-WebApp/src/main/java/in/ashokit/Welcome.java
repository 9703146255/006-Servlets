package in.ashokit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;


/*
 http://localhost:9090/04-WebApp/user?name=thirumalesh&age=25&salary=25000
 */
public class Welcome  extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
	
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		
		PrintWriter writer = res.getWriter();
		writer.write("NAME  	:"+name);
		writer.write("<br>");
		writer.write("EMAIL 	:"+email);
		writer.write("<br>");
		writer.write("PHONENO 	:"+phno);
		
		String sql="insert into user values(?,?,?)";
		;
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
