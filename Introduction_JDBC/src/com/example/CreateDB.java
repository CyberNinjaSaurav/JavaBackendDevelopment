package com.example;

import java.sql.Driver;

public class CreateDB {
    public static void main(String[] args) {

    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","password");
			
			System.out.println("Connection: "+con);
			
			String query = "CREATE DATABASE jbdl65";
			
			Statement stmt = con.createStatement();
			
			stmt.execute(query);
			
			System.out.println("Database Created Successfully.");
			
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
}