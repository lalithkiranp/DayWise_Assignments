package product_inventory_system;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConn {

	public static void main(String[] args) {
		
			String url = "jdbc:mysql://localhost:3306/inventory_db";
			String user = "root";
			String password = "Kiran@2002";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url,user,password);
				System.out.println("Connected to the database");
				conn.close();
			}catch(Exception e){
				System.out.println(e);
			}

	}
}
