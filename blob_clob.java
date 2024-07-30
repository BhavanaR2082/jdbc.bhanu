package jdbc;

import java.sql.*;
import java.util.Scanner;
import java.io.*;


public class blob_clob {
	static String url = "jdbc:mysql://localhost:3306/jdbcconnection";
	static String username = "root";
	static String password = "Bhanusanthu";
	 static Connection con = null;
	  static Statement pstmt1=null;
	public static void main(String[] args) {
		try {
			Scanner sc= new Scanner(System.in);
			//File f= new File("C:\\Users\\Vampire\\eclipse-workspace\\jdbc\\picture\\photo_2024-04-20_21-09-53.jpg");
			//FileInputStream fis= new FileInputStream(f);
			FileReader f1= new FileReader("C:\\Users\\Vampire\\eclipse-workspace\\jdbc\\text");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection(url, username, password);
	        pstmt1 = con.createStatement();
	     /*   String q="update employee set profile_picture=? where emp_id=?";
	      PreparedStatement pstmt = con.prepareStatement(q);
	      System.out.println("Enter the Id");
	      int id= sc.nextInt();8/
	      
	   /*  pstmt.setInt(2, id);
	      pstmt.setBinaryStream(1, fis);
	     int x= pstmt.executeUpdate();
	     System.out.print("updated:"+ x);*/
	     String q1="update employee set about=? where emp_id=?";
	     PreparedStatement pstmt1= con.prepareStatement(q1);
	      System.out.println("Enter the Id");
	      int id= sc.nextInt();
	     pstmt1.setInt(2, id);
	      pstmt1.setCharacterStream(1, f1);
	     int y= pstmt1.executeUpdate();
	     System.out.print("updated about :"+ y);
	     }catch(ClassNotFoundException | SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
		
	}