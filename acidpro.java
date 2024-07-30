package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class acidpro {
	

	
	
	   static String url = "jdbc:mysql://localhost:3306/jdbcconnection";
	   static String username = "root";
	   static String password = "password";
	   static Connection con = null;
	   private static PreparedStatement pstmt_s;
	   private static PreparedStatement pstmt_r;
	   static int pin = 2082;
	   static Scanner sc;

	   static {
	      sc = new Scanner(System.in);
	   }

	   public acidpro() {
	   }

	   public static void main(String[] args) {
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         con = DriverManager.getConnection(url, username, password);
	         con.setAutoCommit(false);
	         String sendQuery = "update bank set balance= balance - ? where id=?";
	         String recvQuery = "update bank set balance= balance + ? where id=?";
	         pstmt_s = con.prepareStatement(sendQuery);
	         pstmt_r = con.prepareStatement(recvQuery);
	         System.out.println("enter sender id");
	         int sid = sc.nextInt();
	         System.out.println("enter sender amt");
	         int amount = sc.nextInt();
	         pstmt_s.setInt(1, amount);
	         pstmt_s.setInt(2, sid);
	         int x = pstmt_s.executeUpdate();
	         System.out.println("output is:" + x);
	         System.out.println("enter recv id");
	         int rid = sc.nextInt();
	         pstmt_r.setInt(1, amount);
	         pstmt_r.setInt(2, rid);
	         x = pstmt_r.executeUpdate();
	         System.out.println("output is:" + x);
	         con.commit();
	      } catch (SQLException | ClassNotFoundException var9) {
	         var9.printStackTrace();
	      }

	      System.out.println("enter pin");
	      int entered = sc.nextInt();
	      if (pin == entered) {
	         try {
	            con.commit();
	         } catch (SQLException var8) {
	            var8.printStackTrace();
	         }

	         System.out.println("success");
	      } else {
	         try {
	            con.rollback();
	         } catch (SQLException var7) {
	            var7.printStackTrace();
	         }

	         System.out.println("failure");
	      }

	   }
	}



