package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class myconnect {
	
	private static String url="jdbc:mysql://localhost:3306/jdbcconnection";
	private static String username = "root";
	private static String password="Bhanusanthu";
	static Connection con=null;
	
		
	
	
	static Connection connect() throws ClassNotFoundException, SQLException  {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		con=DriverManager.getConnection(url,username,password);
		return con;
}
	 static void close(ResultSet res,Statement stmt,Connection con)// void close();
		{
		try {
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	}

	 


