package jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class stored_procedure {
	// Source code is decompiled from a .class file using FernFlower decompiler.
	static String url = "jdbc:mysql://localhost:3306/jdbcconnection";
	   static String username = "root";
	   static String password = "Bhanusanthu";
	   static Connection con;
	   static CallableStatement prepareCall;
	   static Scanner sc;

	   static {
	      sc = new Scanner(System.in);
	   }

	   public stored_procedure() {
	   }

	   public static void main(String[] args) {
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         con = DriverManager.getConnection(url, username, password);
	         prepareCall = con.prepareCall("{dept_deatails(?,?)}");
	         System.out.println("enter the dept name");
	         String dept = sc.nextLine();
	         prepareCall.setString(1, dept);
	         prepareCall.registerOutParameter(2, 4);
	         prepareCall.execute();
	         int x = prepareCall.getInt(2);
	         System.out.println("no of employess:" + dept + "dept are :" + x);
	      } catch (SQLException | ClassNotFoundException var3) {
	         var3.printStackTrace();
	      }

	   }
	}



