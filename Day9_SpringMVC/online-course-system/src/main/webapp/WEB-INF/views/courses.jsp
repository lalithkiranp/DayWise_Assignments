<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Available Courses</title>
</head>
<body>
    <h1>Available Courses</h1>
    
    <table border="1">
        <tr>
            <th>Course ID</th>
            <th>Course Name</th>
            <th>Instructor</th>
            <th>Duration</th>
            <th>Fee</th>
            <th>Action</th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.courseId}</td>
                <td>${course.courseName}</td>
                <td>${course.instructor}</td>
                <td>${course.duration}</td>
                <td>${course.fee}</td>
                <td>
                    <a href="enroll?courseId=${course.courseId}">Enroll</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>