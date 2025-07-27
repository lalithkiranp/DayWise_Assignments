package product_inventory_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewStock {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/inventory_db";
		String user = "root";
		String password = "Kiran@2002"; 
		
		try {
			
			//Load JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish Connection
			Connection conn = DriverManager.getConnection(url,user,password);
			
			//Create Statement Object
			Statement stmt = conn.createStatement();
			
			//Execute Select Query
			String sql = "SELECT quantity, price FROM products";
			ResultSet rs = stmt.executeQuery(sql);
			
			//Process the ResultSet
			System.out.println("quantity price");
			System.out.println("----------------");
			while(rs.next()) {
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				
				System.out.println(quantity+"\t"+price );
			}
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e) {
			System.out.println("Connection Error: " + e);
		}
	}

}
