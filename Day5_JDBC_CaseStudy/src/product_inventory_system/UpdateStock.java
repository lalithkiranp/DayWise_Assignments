package product_inventory_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStock {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/inventory_db";
        String user = "root";
        String password = "Kiran@2002";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter product ID to update: ");
            int productId = sc.nextInt();

            System.out.print("Enter quantity change (positive for purchase, negative for sale): ");
            int quantityChange = sc.nextInt();

            String sql = "UPDATE products SET quantity = quantity + ? WHERE product_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, quantityChange);
            stmt.setInt(2, productId);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product stock updated successfully.");
            } else {
                System.out.println("Product not found.");
            }

            stmt.close();
            conn.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("Connection Error: " + e);
        }
    }
}
