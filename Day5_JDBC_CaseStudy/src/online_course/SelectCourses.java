package online_course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectCourses {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/course_db";
		String user = "root";
		String password = "Kiran@2002"; //instead of root please provide your own password
		
		try {
			
			//Load JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish Connection
			Connection conn = DriverManager.getConnection(url,user,password);
			
			//Create Statement Object
			Statement stmt = conn.createStatement();
			
			//Execute Select Query
			String sql = "SELECT * FROM courses";
			ResultSet rs = stmt.executeQuery(sql);
			
			//Process the ResultSet
			System.out.println("ID\tName\tFaculty\tCredits");
			System.out.println("-------------------------------------");
			while(rs.next()) {
				int id = rs.getInt("course_id");
				String name = rs.getString("course_name");
				String faculty = rs.getString("faculty");
				int credits = rs.getInt("credits");
				
				System.out.println(id + "\t" + name + "\t"+ faculty+"\t"+ credits );
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
