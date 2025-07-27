package product_inventory_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertMultipleProducts {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/inventory_db";
		String user = "root";
		String password = "Kiran@2002"; 
		
		String[][] productData = {
				{"23", "Laptop", "2","123100.23"},
				{"38", "PS5", "1","30000.0"},
				{"8","Mobile", "3","210000.50"},
				{"71","Cricket", "1","5100.58"}

		};
			try {
			
			//Load JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish Connection
			Connection conn = DriverManager.getConnection(url,user,password);
			
			String sql = "INSERT products (product_id, product_name, quantity, price) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            for(String[] prod: productData) {
            	stmt.setInt(1,Integer.parseInt(prod[0]));
            	stmt.setString(2,prod[1]);
            	stmt.setInt(3,Integer.parseInt(prod[2]));
            	stmt.setDouble(4, Double.parseDouble(prod[3]));
            	stmt.executeUpdate();
            }
            
            System.out.println("All Products inserted successfully.");
            
            stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("Connection Error: " + e);
		}

	}

}
