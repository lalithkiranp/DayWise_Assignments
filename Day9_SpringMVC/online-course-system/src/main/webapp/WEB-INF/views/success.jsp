<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enrollment Success</title>
</head>
<body>
    <h1>Enrollment Successful!</h1>
    
    <h2>Enrollment Details:</h2>
    <p>Student Name: ${student.studentName}</p>
    <p>Email: ${student.email}</p>
    <p>Phone: ${student.phone}</p>
    <p>Selected Course: ${student.selectedCourse}</p>
    
    <p>
        <a href="courses">View All Courses</a>
    </p>
</body>
</html>