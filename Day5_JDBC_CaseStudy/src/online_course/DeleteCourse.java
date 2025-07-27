package online_course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteCourse {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/course_db";
		String user = "root";
		String password = "Kiran@2002"; //instead of root please provide your own password
		
		try {
			
			//Load JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish Connection
			Connection conn = DriverManager.getConnection(url,user,password);
			
			
			//Execute Select Query
			String sql = "DELETE FROM courses WHERE course_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,1774);
			
			int rowsDeleted = stmt.executeUpdate();
			if  (rowsDeleted > 0 ) {
				System.out.println("Row Deleted");
			}
			
			stmt.close();
			conn.close();
		}
		catch(Exception e) {
			System.out.println("Connection Error: " + e);
		}

	}

}
