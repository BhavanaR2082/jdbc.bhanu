package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class deleted_data {
	
	// Source code is decompiled from a .class file using FernFlower decompiler.
	

	
	
	   public deleted_data() {
	   }

	   public static void main(String[] args) {
	      String url = "jdbc:mysql://localhost:3306/jdbcconnection";
	      String username = "root";
	      String password = "Bhanusanthu";
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet res = null;
	      PreparedStatement pstmt = null;

	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         con = DriverManager.getConnection(url, username, password);
	         stmt = con.createStatement();
	         int x = stmt.executeUpdate("delete from `employee` where `emp_id`= 5");
	         if (x != 0) {
	            System.out.print("Data deleted");
	         } else {
	            System.out.print("Data not  deleted");
	         }
	      } catch (SQLException | ClassNotFoundException var22) {
	         var22.printStackTrace();
	      } finally {
	         try {
	            if (stmt != null) {
	               stmt.close();
	            }

	            if (con != null) {
	               con.close();
	            }
	         } catch (SQLException var21) {
	            var21.printStackTrace();
	         }

	      }

	   }
	}



