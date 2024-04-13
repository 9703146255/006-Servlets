package in.ashokit;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckEligibility")
public class UserServlet extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
        String birthdateStr = req.getParameter("birthdate");
        
        // Parse the birthdate
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = null;
        try {
            birthdate = dateFormat.parse(birthdateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // Calculate age	1sec ==>1000 milliseconds
        Date currentDate = new Date();
        long ageInMillis = currentDate.getTime() - birthdate.getTime();
        int age = (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365));
        
        // Check eligibility
        boolean isEligible = age >= 18;
        
        // Prepare the response
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<html><head><title>Eligibility Result</title></head><body>");
        out.write("<h1>Eligibility Result</h1>");
        out.write("<p>Name: " + name + "</p>");
        out.write("<p>Age: " + age + " years</p>");
        out.write("<p>Eligible to Vote: " + (isEligible ? "Yes" : "No") + "</p>");
        out.write("</body></html>");
	}
	

}
