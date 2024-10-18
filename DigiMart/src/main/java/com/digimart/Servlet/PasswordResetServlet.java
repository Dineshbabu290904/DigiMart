package com.digimart.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimart.project.ConnectionProvider;

@WebServlet({ "/ForgotPassword", "/admin/ForgotPassword" })
public class PasswordResetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form data
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String securityQuestion = request.getParameter("securityQuestion");
        String answer = request.getParameter("answer");
        String newPassword = request.getParameter("newPassword");

        try {
            // Get database connection
            Connection con = ConnectionProvider.getCon();

            // SQL query to check user details
            String query = "SELECT * FROM Users WHERE username = ? and email = ? and phone = ? and securityQuestion = ? and securityAnswer = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, securityQuestion);
            ps.setString(5, answer);

            ResultSet rs = ps.executeQuery();

            // If user details are valid, update the password
            if (rs.next()) {
                // Update the password
                String updateQuery = "UPDATE Users SET password = ? WHERE email = ?";
                PreparedStatement updatePs = con.prepareStatement(updateQuery);
                updatePs.setString(1, newPassword); 
                updatePs.setString(2, email);
                int rowsUpdated = updatePs.executeUpdate();

                // Check if the password was updated successfully
                if (rowsUpdated > 0) {
                    System.out.println("Password updated successfully.");
                    response.sendRedirect("forgotPassword.jsp?msg=done");
                } else {
                    System.out.println("Error updating password.");
                    response.sendRedirect("forgotPassword.jsp?msg=notdone");
                }
            } else {
                // If user details are incorrect
                System.out.println("Invalid details provided.");
                response.sendRedirect("forgotPassword.jsp?msg=notdone");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            response.sendRedirect("forgotPassword.jsp?msg=error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}