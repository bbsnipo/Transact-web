package servicos;

import java.sql.*;
import java.util.Date;
import java.text.*;

public class Service1 {
	
       static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/WALLET";
	   
	   static final String USER = "root";
	   static final String PASS = "Datam0v2";
	   
	   public static void record(int imei, long cardNo, int regDate, int expiry, String store, int register, int sTender){
	    	  Connection conn = null;
			  Statement stmt = null;
		   
		      Date rDate = new Date();
		      SimpleDateFormat day = 
		      new SimpleDateFormat ("yyyy-MM-dd");
		      
		      Date rTime = new Date();
		      SimpleDateFormat time =
		      new SimpleDateFormat ("hh:mm:ss");
		   
		   

		   
		   double sestok = Math.random()*10000000;
		   
	   try{
	      Class.forName("com.mysql.jdbc.Driver");

	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql = new String();
	      sql = "INSERT INTO Wallet VALUES " + imei + ", " + cardNo + ", " + regDate + ", " + expiry + ";";
	      ResultSet rs = stmt.executeQuery(sql);
	      String sq2 = new String();
	      sq2 = "INSERT INTO Sessions VALUES " + imei + ", " + sestok + ", " + day.format(rDate) + ", " + time.format(rTime) + ", " + store + ", " + register + ", " + sTender + ";";
	      ResultSet rs1 = stmt.executeQuery(sq2);
	      
	      rs.close();
	      rs1.close();
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
	   
	   public static void main(String[] args) {
		  
		   record(1002030,21040255688556678L,20001220,201704,"Bailey",10204050,332211);
		   
	   }
}
