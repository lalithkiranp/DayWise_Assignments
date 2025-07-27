package online_course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateCredits {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/course_db";
		String user = "root";
		String password = "Kiran@2002";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			
			String sql = "UPDATE courses SET credits = ? WHERE faculty = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1,4);
			stmt.setString(2,"Ravi");
			int rowsUpdated = stmt.executeUpdate();
			if (rowsUpdated>0) {
				System.out.println("Row content updated!");
			}
			conn.close();
			stmt.close();
		}catch(Exception e){
			System.out.println(e);
		}

	}

}
