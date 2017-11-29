package servicos;

import java.sql.*;

public class uno {
	
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/Wallet";
	   
	   static final String USER = "root";
	   static final String PASS = "Datam0v2";
	   
	   public static void main(String[] args) {
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT imei, cardNo, date, expiry FROM Wallet";
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         int id  = rs.getInt("imei");
		         int age = rs.getInt("cardNo");
		         int first = rs.getInt("date");
		         int last = rs.getInt("expiry");

		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		   System.out.println("Goodbye!");
		}
}