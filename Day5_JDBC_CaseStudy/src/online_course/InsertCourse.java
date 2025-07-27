package online_course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/course_db";
		String user = "root";
		String password = "Kiran@2002";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			
			String sql = "INSERT INTO courses(course_id,course_name,faculty,credits) VALUES (?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1,1416);
			stmt.setString(2,"Quant");
			stmt.setString(3,"Ravi");
			stmt.setInt(4,2);
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted>0) {
				System.out.println("new rows inserted");
			}
			conn.close();
			stmt.close();
		}catch(Exception e){
			System.out.println(e);
		}

	}

}
