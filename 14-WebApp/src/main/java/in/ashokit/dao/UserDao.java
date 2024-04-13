package in.ashokit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
public class UserDao {
	
	
	
	public boolean saveUser(String name,String email,String pwd,String phno) throws SQLException
	{
		boolean isSaved = false;
		
		
		String sql="insert into user_details values(?, ?, ?, ?)";
		
		DataSource ds = ConnectionFactory.getConnection();
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(3, pwd);
		pstmt.setString(4, phno);
		int count = pstmt.executeUpdate();
		
		if(count>0)
		{
			isSaved=true;
		}
		
		return isSaved;
	}
	
	public boolean findByEmailAndPassword(String email,String pwd) throws SQLException
	{
		boolean isValid = false;
		
		String sql="select * from user_details where email= ? and pwd= ?";
		
		DataSource ds = ConnectionFactory.getConnection();
		Connection conn = ds.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rst = stmt.executeQuery();
		
		if(rst.next())
		{
			isValid = true;
		}
		return  isValid;
		
	}

}
