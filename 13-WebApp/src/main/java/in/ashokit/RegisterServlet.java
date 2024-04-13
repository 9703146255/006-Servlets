package in.ashokit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	resp.setContentType("text/html");
	
	String name = req.getParameter("name");
	String email = req.getParameter("email");
	String pwd = req.getParameter("pwd");
	String phno = req.getParameter("phno");
	
	
	if(name.equals("") && email.equals("") && pwd.equals("") && phno.equals("") )
	{
		PrintWriter writer = resp.getWriter();
		writer.write("<h2 style=\"color: red;\">please enter the details...</h2>");
		RequestDispatcher rd = req.getRequestDispatcher("register.html");
		rd.include(req, resp);
	}
	else
	{
		UserDao dao=new UserDao();
		try {
			dao.save(name, email, pwd, phno);
		} catch (NumberFormatException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PrintWriter writer = resp.getWriter();
		writer.write("<h2 style=\"color: green;\">Registerd successfully</h2>");
		
		RequestDispatcher rd = req.getRequestDispatcher("register.html");
		rd.include(req, resp);
	}
}
}
	
	

