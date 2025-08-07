<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Enrollment</title>
</head>
<body>
    <h1>Course Enrollment Form</h1>
    
    <h2>Selected Course:</h2>
    <p>Course ID: ${course.courseId}</p>
    <p>Course Name: ${course.courseName}</p>
    <p>Instructor: ${course.instructor}</p>
    <p>Duration: ${course.duration}</p>
    <p>Fee: ${course.fee}</p>
    
    <hr>
    
    <h2>Student Details:</h2>
    <form action="submitEnrollment" method="post">
        <input type="hidden" name="selectedCourse" value="${course.courseName}">
        
        <p>
            Student Name: <br>
            <input type="text" name="studentName" required>
        </p>
        
        <p>
            Email: <br>
            <input type="email" name="email" required>
        </p>
        
        <p>
            Phone: <br>
            <input type="text" name="phone" required>
        </p>
        
        <p>
            <input type="submit" value="Submit Enrollment">
            <a href="courses">Back to Courses</a>
        </p>
    </form>
</body>
</html>