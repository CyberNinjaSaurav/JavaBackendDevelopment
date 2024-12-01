package org.samadevs.saurav;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMain {
	
     public static void main(String[] args) {
    	 
    	 Connection con = null;
    	 String url ="jdbc:mysql://localhost:3306/demo";
    	 String user = "root";
    	 String password = "root";
     }
     
     public static Connection dbConnection(String url, String user, String pass) {
   	  Connection con = null;
   	  
    
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		
		 con = DriverManager.getConnection(url, user, pass);

}
	 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return con;
     }
     
     public static void createTable(Connection con)
}

     
    
