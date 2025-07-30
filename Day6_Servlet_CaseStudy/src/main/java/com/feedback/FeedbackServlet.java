package com.feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Check for prior submission using session
        HttpSession session = request.getSession();
        if (session.getAttribute("feedbackSubmitted") != null) {
            response.sendRedirect("already_submitted.jsp");
            return;
        }

        // Check for cookie (in case session expired but cookie exists)
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("feedbackSubmitted".equals(c.getName())) {
                    response.sendRedirect("already_submitted.jsp");
                    return;
                }
            }
        }

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String feedback = request.getParameter("feedback");

        // Basic validation
        if (name == null || email == null || course == null || feedback == null ||
            name.isBlank() || email.isBlank() || course.isBlank() || feedback.isBlank()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "All fields are required.");
            return;
        }

        // Set cookie to prevent resubmission
        Cookie submittedCookie = new Cookie("feedbackSubmitted", "true");
        submittedCookie.setMaxAge(60 * 60 * 24); // 1 day
        response.addCookie(submittedCookie);

        // Set session attribute
        session.setAttribute("feedbackSubmitted", true);

        // Forward to confirmation page
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("course", course);
        request.setAttribute("feedback", feedback);
        request.getRequestDispatcher("feedback_submitted.jsp").forward(request, response);
    }
}
