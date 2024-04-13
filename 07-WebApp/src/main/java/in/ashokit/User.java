package in.ashokit;
//in.ashokit.User
import java.io.IOException;

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
		
		System.out.println("SUCCESSFULLY INSERTED.......");
		
		
	}

}
