package servicos;

import java.sql.*;
import java.util.*;

public class Service2 {
	
       static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/Wallet";
	   
	   static final String USER = "root";
	   static final String PASS = "Datam0v2";
	   
		   Connection conn = null;
		   Statement stmt = null;
		   
	   @SuppressWarnings("finally")
	public
	static
	int sender(int sTender){  			   	   			   

		int sesTok = 0;
		Connection conn = null;
		Statement stmt = null;
		String sq1 = null;
		try{
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT token FROM Sessions WHERE tender = " + sTender;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		      sesTok = rs.getInt("token");
		      }
		      
		      
			rs = stmt.executeQuery(sq1);
		      
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
		      }catch(final SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(final SQLException se){
		         se.printStackTrace();
		      }
		      
		    
			return sesTok;
		   }
	   }
	   
	   public static void main(String args[]){
		   sender(101001000);
	   }

}

