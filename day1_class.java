package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class day1_class {
	// Source code is decompiled from a .class file using FernFlower decompiler.
	public day1_class() {
	   }

	   public static void main(String[] args) {
	      String url = "jdbc:mysql://localhost:3306/jdbcconnection";
	      String username = "root";
	      String password = "Bhanusanthu";
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet res = null;
	      String q = "insert into employee(emp_id, emp_name , emp_dep,emp_salary,employeecol2) values (5,'raj','it',20000,4)";

	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         con = DriverManager.getConnection(url, username, password);
	         stmt = con.createStatement();
	         res = stmt.executeQuery("select * from employee");

	         while(res.next()) {
	            int id = res.getInt(1);
	            String name = res.getString(2);
	            String dept = res.getString(3);
	            int salary = res.getInt(4);
	            int employeecol2 = res.getInt(5);
	            System.out.printf("%d %-9s %-9s %d %d\n", id, name, dept, salary, employeecol2);
	         }
	      } catch (SQLException | ClassNotFoundException var22) {
	         var22.printStackTrace();
	      } finally {
	         try {
	            res.close();
	            stmt.close();
	            con.close();
	         } catch (SQLException var21) {
	            var21.printStackTrace();
	         }

	      }

	   }
	}

	
	
	
	
	


