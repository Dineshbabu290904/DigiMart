package com.digimart.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.digimart.project.ConnectionProvider;

@WebServlet("/MessageUsServlet")
public class MessageUsServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the form inputs
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        // Get the user_id from session (assuming user is logged in)
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("user_id");
        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Insert the message into the database
        try (Connection con = ConnectionProvider.getCon()) {
            String query = "INSERT INTO messages (user_id, subject, message) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setString(2, subject);
            ps.setString(3, message);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                // Success: Redirect to the form with a success message
                response.sendRedirect("messageUs.jsp?msg=valid");
            } else {
                // Failure: Redirect to the form with an error message
                response.sendRedirect("messageUs.jsp?msg=invalid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("messageUs.jsp?msg=invalid");
        }
    }
}