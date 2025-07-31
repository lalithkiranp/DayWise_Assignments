<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fill Feedback</title>
</head>
<body>
<form action="feedbackSummary.jsp" method="post">
    Name: <input type="text" name="name" required><br><br>

    <p>Select facilities and give comments:</p>
    <input type="checkbox" name="facilities" value="Library"> Library 
    <input type="text" name="LibraryComment"><br><br>

    <input type="checkbox" name="facilities" value="Labs"> Labs 
    <input type="text" name="LabsComment"><br><br>

    <input type="checkbox" name="facilities" value="Cafeteria"> Cafeteria 
    <input type="text" name="CafeteriaComment"><br><br>

    <input type="submit" value="Submit Feedback">
</form>
</body>
</html>

<%@ include file="footer.jsp" %>