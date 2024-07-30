package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class updatedata {
	// Source code is decompiled from a .class file using FernFlower decompiler.
	

	
	
	   public updatedata() {
	   }

	   public static void main(String[] args) {
	      String url = "jdbc:mysql://localhost:3306/jdbcconnection";
	      String username = "root";
	      String password = "Bhanusanthu";
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet res = null;
	      PreparedStatement pstmt = null;
	      String q = "update `employee` set `emp_salary`=`emp_salary`+5000 where \t`emp_dep`='it'";

	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         con = DriverManager.getConnection(url, username, password);
	         stmt = con.createStatement();
	         int x = stmt.executeUpdate(q);
	         if (x != 0) {
	            System.out.println("update success");
	         } else {
	            System.out.println("update failes");
	         }
	      } catch (SQLException | ClassNotFoundException var23) {
	         var23.printStackTrace();
	      } finally {
	         try {
	            if (stmt != null) {
	               stmt.close();
	            }

	            if (con != null) {
	               con.close();
	            }
	         } catch (SQLException var22) {
	            var22.printStackTrace();
	         }

	      }

	   }
	}



