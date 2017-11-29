package servicos;

import java.sql.*;

public class Service4 {
	
       static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/Wallet";
	   
	   static final String USER = "root";
	   static final String PASS = "Datam0v2";
	   

		   
		   public static int selector(int token, int imei){  
			   
			   Connection conn = null;
			   Statement stmt = null;

		   int pTender = 0;
		    	 
		    	 
		   try{
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT ptender FROM Transacts WHERE token = " + token + " AND imei = " + imei;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		    	  pTender = rs.getInt("ptender");
		    	  
		    	  System.out.println(pTender);
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
		   return pTender;
		}
		   
		public static void main(String args[]){
			selector(10101010,101010101);
		}
}


