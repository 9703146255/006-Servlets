package in.ashokit.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
	public static final String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	public static final String DB_UNAME="root";
	public static final String DB_PASSWORD="123456";
	
	
	private static DataSource ds=null;
	
	public static DataSource getConnection()
	{

			
			if(ds == null)
			{
				
				try
				{
				HikariConfig config=new HikariConfig();
				config.setJdbcUrl(DB_URL);
				config.setUsername(DB_UNAME);
				config.setPassword(DB_PASSWORD);
				config.setDriverClassName("com.mysql.cj.jdbc.Driver");
				config.setMaximumPoolSize(20);
				config.setMinimumIdle(5);
				 ds=new HikariDataSource(config);
				 
				 return ds;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
			}
			 return ds;
			
			
		
	
		
		
		
		
		
		
	}
	

}
