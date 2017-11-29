package servicos;

import java.sql.*;
import java.util.Date;

public class Service5 {

	
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/Wallet";
	   
	   static final String USER = "root";
	   static final String PASS = "Datam0v2";
	   
		   Connection conn = null;
		   Statement stmt = null;
		   
		   public static int requesteri(int pTender,double payment){  			   	   			   
			   Connection conn = null;
			   Statement stmt = null;
		   int imei = 0;
		   
		    	 
		    	 
		   try{
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT imei FROM Transacts WHERE ptender = " + pTender;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		    	  imei = rs.getInt("imei");
		      
		    	  System.out.println(imei);
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
	    	  return imei;
		   
		}
		    
	public static Time requestert(int pTender,double payment){  			   	   			   

		   Connection conn = null;
		   Statement stmt = null;
				   
		    Time rTime = null;	 
		    	 
		   try{
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT imei, token, date, time, store, register FROM Transacts WHERE ptender=" + pTender;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		    	  rTime = rs.getTime("time");
		    	  System.out.println(rTime);		      

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
		   return rTime;
		}
	
	public static Date requesterd(int pTender,double payment){  			   	   			   

		   Connection conn = null;
		   Statement stmt = null;
		  
		   Date rDate = null; 
   	 
   	 
		   try{
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT date FROM Transacts WHERE ptender=" + pTender;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		    	  rDate = rs.getTime("date");
		    	  System.out.println(rDate);		      

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
		   return rDate;
		}	
	
	public static String requesters(int pTender,double payment){  			   	   			   

		   String store = null;
		   Connection conn = null;
		   Statement stmt = null;
   	 
		   try{
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT store FROM Transacts WHERE ptender=" + pTender;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		    	  store = rs.getString("store");
		    	  System.out.println(store);		      

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
	    	  return store;
		}
	   public static int requestertoken(int pTender,double payment){  			   	   			   

	   int token = 0;

	   Connection conn = null;
	   Statement stmt = null;
	    	 
	    	 
	   try{
	      Class.forName("com.mysql.jdbc.Driver");

	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT token FROM Transacts WHERE ptender=" + pTender;
	      ResultSet rs = stmt.executeQuery(sql);
	      
	      while(rs.next()){
	    	  token = rs.getInt("token");
	      
	    	  System.out.println(token);		    	  
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
 	  return token;		    	  

	   
	}
	   public static int requesterr(int pTender,double payment){  			   	   			   

	   int register = 0;
	   
	   Connection conn = null;
	   Statement stmt = null;
	    	 
	    	 
	   try{
	      Class.forName("com.mysql.jdbc.Driver");

	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT register FROM Transacts WHERE ptender=" + pTender;
	      ResultSet rs = stmt.executeQuery(sql);
	      
	      while(rs.next()){
	    	  register = rs.getInt("register");
	          	  
	    	  System.out.println(register);
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
    	  return register;
	   
	}
	   
	public static void main(String args[]){
		
		requesteri(1000100101,1000.01);
		requestert(1000100101,1000.01);
		requesterd(1000100101,1000.01);
		requesters(1000100101,1000.01);
		requestertoken(1000100101,1000.01);
		requesterr(1000100101,1000.01);
		
	}
	
}
