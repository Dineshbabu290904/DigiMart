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

@WebServlet("/ChangeMobileNumberServlet")
public class ChangeMobileNumberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("user_id");
        String currentPassword = request.getParameter("password"); // User-entered password
        String newMobileNumber = request.getParameter("mobileNumber");

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
                    response.sendRedirect("changeMobileNumber.jsp?msg=wrongPassword");
                    return;
                }

                // Update mobile number
                String updateQuery = "UPDATE users SET phone = ? WHERE user_id = ?";
                PreparedStatement updateStmt = con.prepareStatement(updateQuery);
                updateStmt.setString(1, newMobileNumber);
                updateStmt.setInt(2, userId);

                int rowsUpdated = updateStmt.executeUpdate();
                if (rowsUpdated > 0) {
                    response.sendRedirect("changeMobileNumber.jsp?msg=success");
                } else {
                    response.sendRedirect("changeMobileNumber.jsp?msg=error");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("changeMobileNumber.jsp?msg=error");
        }
    }
}
