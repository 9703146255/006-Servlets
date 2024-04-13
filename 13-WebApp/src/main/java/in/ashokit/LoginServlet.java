package in.ashokit;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		
		
	
		
		UserDao dao=new UserDao();
		
		
		String name=null;
		try {
			name=dao.getUserNameByEmail(email);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		try {
            boolean loginValid = dao.getData(email, pwd);
            if (loginValid) {
            	
            	
            	if (name != null) 
            	{
            	req.setAttribute("name1", name); // Set the name attribute
                RequestDispatcher rd = req.getRequestDispatcher("dashboard.html");
                rd.forward(req, resp);
            	}
               
            } else {
            	 resp.getWriter().write("<h2 style=\"color: red;\">Invalid credentials....</h2>");
            	  RequestDispatcher rd = req.getRequestDispatcher("login.html");
                  rd.include(req, resp);
                  
                 
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		
		
		
		
		
		
	}
	

}
