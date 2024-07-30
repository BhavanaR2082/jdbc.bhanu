package jdbc;

import java.sql.*;
public class day {
	public static void main(String[] args)
		
		{
			day d1=new day();
			String url="jdbc:mysql://localhost:3306/jdbcconnection";
			String username = "root";
			String password="Bhanusanthu";
			Connection con=null;
			Statement stmt =null;
			ResultSet res=null;

			try {
				con=myconnect.connect();
				/*Class.forName("com.mysql.cj.jdbc.Driver");
				 con=DriverManager.getConnection(url,username,password);*/
				  stmt =con.createStatement();
				 res = stmt.executeQuery("select * from employee");
				while(res.next()) {
					System.out.println(res.getInt(1)+"     "+res.getString(2)+"     "+res.getString(3)+"     "+res.getInt(4)+"     "+res.getInt(5)
					);
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			finally {
				//close(res,stmt,con);  // d1.close(res,stmt,con)// u can connect to another class and cl that class as myconnect.close(res,stmt,con);
			 myconnect.close(res, stmt, con);}
			}
				
				
				/* static void close(ResultSet res,Statement stmt,Connection con)// void close();
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
			}*/
			
			
			
			}
		

			
		
	
