package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class inserted_data {
	// Source code is decompiled from a .class file using FernFlower decompiler.
	 public inserted_data() {
	   }

	   public static void main(String[] args) {
	      String url = "jdbc:mysql://localhost:3306/jdbcconnection";
	      String username = "root";
	      String password = "Bhanusanthu";
	      Connection con = null;
	      Statement stmt = null;
	      String q = "insert into employee(emp_id, emp_name , emp_dep,emp_salary,employeecol2) values (5,'raj','it',20000,4)";

	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         con = DriverManager.getConnection(url, username, password);
	         stmt = con.createStatement();
	         int x = stmt.executeUpdate(q);
	         System.out.println("output " + x);
	      } catch (SQLException | ClassNotFoundException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if (stmt != null) {
	               stmt.close();
	            }

	            if (con != null) {
	               con.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }

	      }

	   
	}

	
	
	
	
	
	
	

}
