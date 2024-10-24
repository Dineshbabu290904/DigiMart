package com.digimart.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimart.project.ConnectionProvider;

@WebServlet({"/signup","/admin/signup" })
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Fetch form data
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String user_type = request.getParameter("user_type");
        String password = request.getParameter("password");
        String securityQuestion = request.getParameter("securityQuestion");
        String answer = request.getParameter("answer");

        try {
            // Database connection
            Connection con = ConnectionProvider.getCon();
            // SQL query to insert the data
            String query = "INSERT INTO users (username, name, email, phone, user_type, password, securityQuestion, securityAnswer) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.setString(5, user_type);
            pstmt.setString(6, password);
            pstmt.setString(7, securityQuestion);
            pstmt.setString(8, answer);

            // Execute the query
            pstmt.executeUpdate();

            // Redirect to signup page with success message
            response.sendRedirect("signup.jsp?msg=valid");
        } catch (Exception e) {
            e.printStackTrace();
            // Redirect to signup page with error message
            response.sendRedirect("signup.jsp?msg=invalid");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
