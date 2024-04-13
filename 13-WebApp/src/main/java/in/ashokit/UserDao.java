package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	
	public static final String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	public static final String DB_UNAME="root";
	public static final String DB_PASSWORD="123456";
	
	public boolean save(String name,String email,String password,String phno) throws ClassNotFoundException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String sql="insert into userregister1 values(?, ?, ?, ?)";
		
		try(Connection connection = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD);) {
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, phno);
			
			int count = pstmt.executeUpdate();
			System.out.println("record inserted succesfully :"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean getData(String email,String password) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	 	String sql = "SELECT email, password FROM userregister1 WHERE email = ? AND password = ?";
	 	
	 	Connection connection = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();

        boolean loginValid = resultSet.next(); // Check if there is a matching record

        resultSet.close();
        statement.close();
        connection.close();

        return loginValid;
	}
	
	
	public String getUserNameByEmail(String email) throws ClassNotFoundException, SQLException {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    
	    String sql = "SELECT name FROM userregister1 WHERE email = ?";
	    
	    try (Connection connection = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD);
	         PreparedStatement statement = connection.prepareStatement(sql);) {
	        statement.setString(1, email);
	        
	        ResultSet resultSet = statement.executeQuery();
	        
	        if (resultSet.next()) {
	            return resultSet.getString("name");
	        } else {
	            return null; // User not found
	        }
	    }
	}

	
	

}
