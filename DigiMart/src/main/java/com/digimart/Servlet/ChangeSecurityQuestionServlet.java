package com.digimart.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.digimart.project.ConnectionProvider;

@WebServlet("/ChangeSecurityQuestionServlet")
public class ChangeSecurityQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("user_id");
        String currentPassword = request.getParameter("password"); // User-entered password for verification
        String newSecurityQuestion = request.getParameter("securityQuestion");
        String newAnswer = request.getParameter("securityAnswer");

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try (Connection con = ConnectionProvider.getCon()) {
            // Verify current password
            String passwordQuery = "SELECT password FROM users WHERE user_id = ?";
            PreparedStatement passwordStmt = con.prepareStatement(passwordQuery);
            passwordStmt.setInt(1, userId);
            ResultSet rs = passwordStmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");

                if (!storedPassword.equals(currentPassword)) {
                    // Incorrect password
                    response.sendRedirect("changeSecurityQuestion.jsp?msg=wrongPassword"); // Redirect with error message
                    return;
                }

                // Update security question and answer
                String updateQuery = "UPDATE users SET securityQuestion = ?, securityAnswer = ? WHERE user_id = ?";
                PreparedStatement updateStmt = con.prepareStatement(updateQuery);
                updateStmt.setString(1, newSecurityQuestion);
                updateStmt.setString(2, newAnswer);
                updateStmt.setInt(3, userId);

                int rowsUpdated = updateStmt.executeUpdate();
                if (rowsUpdated > 0) {
                    response.sendRedirect("changeSecurityQuestion.jsp?msg=success"); // Success message
                } else {
                    response.sendRedirect("changeSecurityQuestion.jsp?msg=error"); // Error message
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("changeSecurityQuestion.jsp?msg=error"); // Handle SQL error
        }
    }
}
