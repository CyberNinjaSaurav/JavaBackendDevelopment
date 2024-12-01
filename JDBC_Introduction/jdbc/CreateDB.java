import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
         

    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
			
			System.out.println("Connection: "+con);
			
			String query = "CREATE DATABASE demo";
			
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
