package in.ashokit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashokit.dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		
		
	//get the form data
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		
		
		if(email.equals("") && pwd.equals(""))
		{
		resp.getWriter().write("<h2 style=\"color: red;\">please enter the credentials....</h2>");
		 RequestDispatcher rd = req.getRequestDispatcher("login.html");
         rd.include(req, resp);
		}
		else
		{
			UserDao dao=new UserDao();
			try {
	            boolean loginValid = dao.findByEmailAndPassword(email, pwd);
	            if (loginValid) {
	                RequestDispatcher rd = req.getRequestDispatcher("dashboard.html");
	                rd.forward(req, resp);
	            } else {
	            	  resp.getWriter().write("<h2 style=\"color: red;\">Invalid credentials....</h2>");
	            	  RequestDispatcher rd = req.getRequestDispatcher("login.html");
	                  rd.include(req, resp);
	                  
	                 
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		
		
		
		

	}

}
