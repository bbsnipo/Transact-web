package servicos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Service3 {
	
	
       static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static String DB_URL = "jdbc:mysql://localhost/Wallet";
	   
	   static String USER = "root";
	   static String PASS = "Datam0v2";
	   
	   static Connection conn = null;
	   static Statement stmt = null;
	   
	   public static int linkert(int token){ 
			
			int imei = 0;
			int sTender = 0;
			int register = 0;
			
			SimpleDateFormat day =
			new SimpleDateFormat("yyyy-MM-dd);");

			   
	    	 
		try{
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT imei FROM Transacts WHERE token=" + token;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		    	  imei = rs.getInt("imei");
		      }
		      
		      String sq2 = null;
		      
			  sql = "SELECT tender FROM Transacts WHERE imei=" + imei;
		      ResultSet rs1 = stmt.executeQuery(sq2);
		      
		      
		      while(rs1.next()){
		    	  sTender = rs1.getInt("tender");
		    	  register = rs.getInt("register");
		    	  
		    	  return sTender;

		      }		      
	
		      
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
		return sTender;
		
		

	   }
		
		public static Date linkerd(int token){ 
			
			int imei = 0;
			Date rDate = null;

			   
	    	 
		try{
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT register,imei FROM Transacts WHERE token=" + token;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		    	  imei = rs.getInt("imei");
		      }
		      
		      String sq2 = null;
		      
			  sql = "SELECT tender, date, store FROM Transacts WHERE imei=" + imei;
		      ResultSet rs1 = stmt.executeQuery(sq2);
		      
		      
		      while(rs1.next()){
		    	  rDate = rs1.getDate("date");	

		    	  
		    	  return rDate;

		      }		      
	
		      
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
		return rDate;
		

	   }
  	  
		public static String linkers(int token){ 
			
			int imei = 0;
			String store = null;

			   
	    	 
		try{
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT register,imei FROM Transacts WHERE token = " + token;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		    	  imei = rs.getInt("imei");
		    	  
		    	  System.out.println(imei);
		      }
		      
		      String sq2 = null;
		      
			  sql = "SELECT store FROM Transacts WHERE imei = " + imei;
		      ResultSet rs1 = stmt.executeQuery(sq2);
		      
		      
		      while(rs1.next()){
		    	  store = rs1.getString("store");	

		    	  
		    	  return store;

		      }		      
	
		      
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
		return store;
		

	   }
	  
	  
	   public static void main(String[] args) {
		   
		   linkert(101010101);
		   linkerd(101010101);
		   linkers(101010101);
	   		   

	}  
}

