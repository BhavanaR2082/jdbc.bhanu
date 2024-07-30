package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class accept_input {
	// Source code is decompiled from a .class file using FernFlower decompiler.
	

	

	
	   public accept_input() {
	   }

	   public static void main(String[] args) {
	      String url = "jdbc:mysql://localhost:3306/jdbcconnection";
	      String username = "root";
	      String password = "Bhanusanthu";
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet res = null;
	      PreparedStatement pstmt = null;
	      Scanner sc1 = new Scanner(System.in);
	      Scanner sc2 = new Scanner(System.in);
	      String q = "INSERT INTO employee (emp_id, emp_name, emp_dep, emp_salary, employeecol2) VALUES (?, ?, ?, ?, ?)";

	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         con = DriverManager.getConnection(url, username, password);
	         pstmt = con.prepareStatement(q);
	         System.out.println("enter id");
	         int emp_id = sc1.nextInt();
	         System.out.println("enter name");
	         String emp_name = sc2.nextLine();
	         System.out.println("enter dept");
	         String emp_dep = sc2.nextLine();
	         System.out.println("enter salary");
	         int emp_salary = sc1.nextInt();
	         System.out.println("enter employeecol2 ");
	         int employeecol2 = sc1.nextInt();
	         pstmt.setInt(1, emp_id);
	         pstmt.setInt(4, emp_salary);
	         pstmt.setInt(5, employeecol2);
	         pstmt.setString(2, emp_name);
	         pstmt.setString(3, emp_dep);
	         int x = pstmt.executeUpdate();
	         System.out.println("output is" + x);
	      } catch (SQLException | ClassNotFoundException var25) {
	         var25.printStackTrace();
	      } finally {
	         try {
	            if (res != null) {
	               ((ResultSet)res).close();
	            }

	            if (stmt != null) {
	               ((Statement)stmt).close();
	            }

	            if (con != null) {
	               con.close();
	            }
	         } catch (SQLException var24) {
	            var24.printStackTrace();
	         }

	      }

	   }
	}

	
	
	
	


