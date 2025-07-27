package online_course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertMultipleCourses {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/course_db";
		String user = "root";
		String password = "Kiran@2002"; //instead of root please provide your own password
		
		String[][] studentData = {
				{"1978", "LRDI", "Apoorv","2"},
				{"1128", "VARC", "JEJO","3"},
				{"1774","VARC", "Sanjana","2"},

		};
			try {
			
			//Load JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish Connection
			Connection conn = DriverManager.getConnection(url,user,password);
			
			String sql = "INSERT INTO courses (course_id, course_name, faculty, credits) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            for(String[] stud: studentData) {
            	stmt.setInt(1,Integer.parseInt(stud[0]));
            	stmt.setString(2,stud[1]);
            	stmt.setString(3,stud[2]);
            	stmt.setInt(4, Integer.parseInt(stud[3]));
            	stmt.executeUpdate();
            }
            
            System.out.println("All Courses inserted successfully.");
            
            stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("Connection Error: " + e);
		}
 

	}

}
