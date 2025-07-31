<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% String name = request.getParameter("name");
    String[] selectedFacilities = request.getParameterValues("facilities");

    java.util.Map<String, String> feedbackMap = new java.util.HashMap<>();

    if (selectedFacilities != null) {
        for (String facility : selectedFacilities) {
            String comment = request.getParameter(facility + "Comment");
            feedbackMap.put(facility, comment != null ? comment : "");
        }
    }

    session.setAttribute("name", name);
    request.setAttribute("feedbackMap", feedbackMap);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Summary</title>
</head>
<body>
<c:choose>
  <c:when test="${not empty feedbackMap}">
    <h3>📝 Feedback Summary for <c:out value='${sessionScope.name}' /></h3>
    <ul>
      <c:forEach var="entry" items="${feedbackMap}">
        <li><strong>${entry.key}:</strong> ${entry.value}</li>
      </c:forEach>
    </ul>
    <p><a href="Thankyou.jsp">Finish</a></p>
  </c:when>
  <c:otherwise>
    <p><strong>No feedback submitted.</strong></p>
    <p><a href="feedbackForm.jsp">🔁 Go Back</a></p>
  </c:otherwise>
</c:choose>
</body>
</html>
<%@ include file="footer.jsp" %>