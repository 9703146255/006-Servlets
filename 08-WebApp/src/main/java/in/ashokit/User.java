package in.ashokit;
//in.ashokit.User
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class User extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		
		
		
		UserDao dao=new UserDao();
		try {
			dao.insertData(name, email, phno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter writer = res.getWriter();
		writer.write("<h3 style='color:green'>DATA INSERTED SUCCESSFULLY..............</h3>");

		
		 req.getRequestDispatcher("index.html");
		 
		
		
		
		
		
	}

}
