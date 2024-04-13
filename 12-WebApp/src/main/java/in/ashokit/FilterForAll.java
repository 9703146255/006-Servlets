package in.ashokit;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class FilterForAll
 */
//@WebFilter("/*")
public class FilterForAll extends HttpFilter implements Filter {
       

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		
		LocalTime time=LocalTime.now();
		int hour = time.getHour();
		
		if(hour>=19 && hour<=20)
		{
			chain.doFilter(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
		}
		else
		{
			response.getWriter().write("<h2 style='color:red'> Kindly login in office hours <br> between 09AM TO 05 PM</h2> ");
		}
		
		
		
		
		
		
		
	}



}
