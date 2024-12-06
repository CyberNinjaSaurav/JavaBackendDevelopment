package org.samadevs.saurav;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMain {

	public static void main(String[] args) {

		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "root";
		
		int temp;

		try {
			con = dbConnection(url, user, password);
//			createTable(con);
			
//			insertRecord(con);   
			
			
//			 for(int i = 0; i < 10; i++) { 
//				 temp = getRandomNumber(); 
//				 insertRecordPS(con, temp , "First " + temp , "Last " + temp, temp); 
//				 }
//			    selectQuery(con);
			    updateRecordPS(con, 1, 5);
			    updateRecordPSwithRS(con, 1, 5);
			    selectQueryRSUpdate(con);
			    deleteRecordPS(con,9538);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection dbConnection(String url, String user, String pass) {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void createTable(Connection con) throws SQLException {

		String sql = "CREATE TABLE IF NOT EXISTS `registration` (" 
		        + "  `id` INT NOT NULL,"
				+ "  `first` VARCHAR(45) NULL," + "  `last` VARCHAR(45) NULL," + "  `age` VARCHAR(45) NULL,"
				+ "  PRIMARY KEY (`id`));";

		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);

		System.out.println("Table Created Successfully.");

		// To run again for multiple times sql table
		// we have command call "IF NOT EXISTS"

	}

	
	  public static int insertRecord (Connection con) throws SQLException {
	  
	  String sql = "Insert into `registration` values (3, 'Alice', 'jackson', 6);"; 
	  Statement stmt = con.createStatement();
	  int result = stmt.executeUpdate(sql);
	  System.out.println("Insertion Result : " + result); 
	  return result;
	  
	  }
	  
	  public static int insertRecordPS(Connection con, int id, String first, String last, int age) throws SQLException {
		  
		  String sql = "Insert into `registration` values (?,?,?,?);";
		  
		  PreparedStatement pstmt = con.prepareStatement(sql);
		  
		  pstmt.setInt(1, age);
		  pstmt.setString(2, first);
		  pstmt.setString(3, last);
		  pstmt.setInt(4, age);
		  
		  
		  int result = pstmt.executeUpdate();
		  System.out.println("Insertion Result : " + result);
		  return result;
		  
	  }
	  
	  public static void selectQuery(Connection con) throws SQLException {
			String sql = "select * from `registration`;";
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs.getRow());
			
			System.out.println("*****************************************************");
			System.out.println("ID            First Name      Last Name          Age ");
			rs.absolute(25);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"            "+rs.getString(2)+"      "+rs.getString(3)+"          "+rs.getInt(4)+" Row Number:"+rs.getRow());
				
			}
			
			
			System.out.println("*****************************************************");
			
			rs.close();
			stmt.close();
			
		}
	  
	  
	  public static int updateRecordPS(Connection con, int id, int age) throws SQLException {
		  
		  String sql = "Update `registration` set age = ? where id = ?;";
		  
		  PreparedStatement pstmt = con.prepareStatement(sql);
		  
		  pstmt.setInt(1, age);
		  pstmt.setInt(2, id);
		  
		  int result = pstmt.executeUpdate();
		  
		  System.out.println("Insertion Result : " + result);
		  return result;
		  
	  }
	  
  public static void updateRecordPSwithRS(Connection con, int id, int age) throws SQLException {
		  
		  String sql = "Update `registration` set age = ? where id = ?;";
		  
		  PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, age);
			pstmt.setInt(2, id);
			
			int result = pstmt.executeUpdate();
			
			System.out.println("Insertion Result : "+result);
			
			String sql2 = "select * from `registration` where id=1;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql2);
			System.out.println(rs.getRow());
			System.out.println("*****************************************************");
			System.out.println("ID            First Name      Last Name          Age ");
		
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"            "+rs.getString(2)+"      "+rs.getString(3)+"          "+rs.getInt(4)+" Row Number:"+rs.getRow());
				
			}
			
			
			System.out.println("*****************************************************");
			
			rs.close();
			stmt.close();
			
			
		 
		  
	  }
  
  public static int deleteRecordPS(Connection con,int id) throws SQLException {
		String sql = "delete from `registration` where id = ?;";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		
		int result = pstmt.executeUpdate();
		
		System.out.println("Deletion Result : "+result);
		return result;
		
	}
  
  public static void selectQueryRSUpdate(Connection con) throws SQLException {
		String sql = "select * from `registration`;";
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println(rs.getRow());
		System.out.println("*****************************************************");
		System.out.println("ID            First Name      Last Name          Age ");
		
		
		while(rs.next()) {
			if(rs.getInt(1) == 5) {
				rs.updateInt(4, 100);
				rs.updateRow();
			}
			System.out.println(rs.getInt(1)+"            "+rs.getString(2)+"      "+rs.getString(3)+"          "+rs.getInt(4)+" Row Number:"+rs.getRow());
			
		}
		
		
		System.out.println("*****************************************************");
		
		rs.close();
		stmt.close();
		
	}
	  
	  
	  private static int getRandomNumber() {
			int min =1, max = 10000;
		    return (int) ((Math.random() * (max - min)) + min);
	  }
}
