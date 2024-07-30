package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class transaction {
	

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbcconnection";
		String un = "root";
		String pwd = "Bhanusanthu";
		Connection con = null;
		try 
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, un, pwd);
		Scanner scan =new Scanner(System.in);
		con.setAutoCommit(false);

		
		System.out.println("*****Welcome to Tap Bank*****");
		System.out.println("Enter Account Number:");
		int acc_num = scan.nextInt();
		System.out.println("Enter Pin:");
		int pin = scan.nextInt();
		PreparedStatement pstmt1 =
		con.prepareStatement("select * from transaction where " + "acount_number = ? and pin = ? ");
		pstmt1.setInt(1, acc_num);
		pstmt1.setInt(2, pin);
		ResultSet res1 =pstmt1.executeQuery();
		res1.next();
		String name = res1.getString(2);
		int bal = res1.getInt(4);
		System.out.println("Welcome "+name);
		System.out.println("Available balance is: "+bal);
		System.out.println("*****Transfer Details*****");
		System.out.println("Enter the beneficiary account number:");
		int bacc_num = scan.nextInt();
		System.out.println("Enter the transfer amount");
		int t_amount = scan.nextInt();
		PreparedStatement pstmt2 = con.prepareStatement("update transaction set balance = balance - ? where acount_number = ? ");
		pstmt2.setInt(1, t_amount);
		pstmt2.setInt(2, acc_num);
		pstmt2.executeUpdate();
		System.out.println("***** Incoming Credit Request *****");
		System.out.println(name + " account no " + acc_num + " wants to transfer "+ t_amount);
		System.out.println("Press Y to receive");
		System.out.println("Press N to reject");
		String choice = scan.next();
		if(choice.equalsIgnoreCase("Y")) 
		{
		PreparedStatement pstmt3 =con.prepareStatement("update transaction set balance = balance + ? where acount_number = ? ");
		pstmt3.setInt(1, t_amount);
		pstmt3.setInt(2, bacc_num);
		pstmt3.executeUpdate();
		PreparedStatement pstmt4 = con.prepareStatement("select * from transaction where acount_number = ? ");
		pstmt4.setInt(1, bacc_num);
		ResultSet res2 =pstmt4.executeQuery();
		res2.next();
		System.out.println("Updated balance is: " +res2.getInt(4));
		
				}
				else 
				{
				PreparedStatement pstmt5 =
				con.prepareStatement("select * from transaction " + "where acount_number = ? ");
				pstmt5.setInt(1, bacc_num);
				ResultSet res2 =pstmt5.executeQuery();
				res2.next();
				System.out.println("Existing balance is: " + res2.getInt(4));
				con.commit();
				}
		if(choice.equalsIgnoreCase("Y")){
			try {
				con.commit();
			}catch (SQLException e) {
	            e.printStackTrace();
	         }
			System.out.println("Transaction Success.");
		}
			else {
				try {
		            con.rollback();
		         } catch (SQLException e) 
				{
		            e.printStackTrace();
		         }

		         System.out.println("failure.");
			}
		}catch (Exception e){
				e.printStackTrace();
			}
		}
	}