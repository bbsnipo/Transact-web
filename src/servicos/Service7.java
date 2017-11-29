package servicos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Service7 {

	   static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static String DB_URL = "jdbc:mysql://localhost/Wallet";
	   
	   static String USER = "root";
	   static String PASS = "Datam0v2";
	   
	   public static String retriever(int pTender,double payment){  			   	   			   

		   Connection conn = null;
		   Statement stmt = null;
		   int imei = 0;
		   int token = 0;
		   Date rDate = null;
		   Date rTime = null;
		   String store = null;
		   int register = 0;
	    	 
	    	 
	try{
	      Class.forName("com.mysql.jdbc.Driver");

	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT imei, token, date, time, store, register FROM Transacts";
	      ResultSet rs = stmt.executeQuery(sql);
	      
	      while(rs.next()){
	    	  imei = rs.getInt("imei");
	    	  token = rs.getInt("token");
	    	  rDate = rs.getDate("date");
	    	  rTime = rs.getTime("time");
	    	  store = rs.getString("store");
	    	  register = rs.getInt("register");
	      
	    	  System.out.println(imei + token + " " + rDate + rTime + store + register);
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
	return imei + token + " " + rDate + rTime + store + register;
}
	
	   public static void main(String[] args) {
		   retriever(1000100101,1000.01);
	   }
}
