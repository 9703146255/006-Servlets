package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
	
	
	public static final String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	public static final String DB_UNAME="root";
	public static final String DB_PASSWORD="123456";
	public void insertData(String name,String email, String phno) throws Exception
	{
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String sql="insert into user values(?, ?, ?)";
		
		
		try(Connection connection = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD);) {
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, phno);
			
			int count = pstmt.executeUpdate();
			System.out.println("record inserted succesfully :"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
