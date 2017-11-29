package servicos;

import java.sql.*;
public class Service6 {
       static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/Wallet";
	   
	   static final String USER = "root";
	   static final String PASS = "Datam0v2";
	   

	   
	    public static int sender( int imei){  
	    	
	    	int sTender = 0;

	 	   Connection conn = null;
		   Statement stmt = null;	   
	    	 
	    	 
	   try{
	      Class.forName("com.mysql.jdbc.Driver");

	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT tender FROM Sessions WHERE imei = " + imei;
	      ResultSet rs = stmt.executeQuery(sql);
	      
	      while(rs.next()){
	    	  sTender = rs.getInt("tender");
	    	  
	    	  System.out.println(sTender);
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
	   return sTender;
	 }
	   
	   public static void main(String[] args) {
		   sender(101010101);
		   }
}
