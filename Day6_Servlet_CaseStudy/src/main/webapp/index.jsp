<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Course Feedback Form</title>
</head>
<body>
    <h2>Student Course Feedback</h2>
    <form method="post" action="FeedbackServlet">
        <label>Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Email Address:</label><br>
        <input type="email" name="email" required><br><br>

        <label>Course Attended:</label><br>
        <input type="text" name="course" required><br><br>

        <label>Feedback or Suggestions:</label><br>
        <textarea name="feedback" rows="5" cols="40" required></textarea><br><br>

        <input type="submit" value="Submit Feedback">
    </form>
</body>
</html>

    