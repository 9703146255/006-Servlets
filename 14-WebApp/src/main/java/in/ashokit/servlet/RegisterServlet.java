package in.ashokit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashokit.dao.UserDao;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		resp.setContentType("text/html");
		
		//taking the form data
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String phno = req.getParameter("phno");
		
		//calling the dao class
		boolean saveUser = false;
		UserDao dao=new UserDao();
		try {
		  saveUser = dao.saveUser(name, email, pwd, phno);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//sending the response to the user
		
		
		if(saveUser)
		{
	    resp.getWriter().write("<font color='green'>registration success please login....<font>");
	    RequestDispatcher rd = req.getRequestDispatcher("register.html");
	    rd.include(req, resp);
		}
		else
		{
			 resp.getWriter().write("<font color='green'>registration failded please enter valid details....<font>");
			 RequestDispatcher rd = req.getRequestDispatcher("register.html");
			 rd.include(req, resp);	
		}
	
	}

	

}
