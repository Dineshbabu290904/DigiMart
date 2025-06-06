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
import javax.servlet.http.HttpSession;

import com.digimart.project.ConnectionProvider;

@WebServlet({ "/login", "/admin/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Database connection
            con = ConnectionProvider.getCon();
            // SQL query to authenticate user
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                String user_type = rs.getString("user_type");
                String email = rs.getString("email");
                String user = rs.getString("username");

                // Creating session
                HttpSession session = request.getSession();
                session.setAttribute("user_type", user_type);
                session.setAttribute("email", email);
                session.setAttribute("user", user);
                session.setAttribute("user_id", rs.getInt("user_id"));  // Assuming user_id is retrieved correctly

                // Redirect based on user type
                if (user_type.equals("Farmer")) {
                    response.sendRedirect("home.jsp");
                } else if (user_type.equals("Consumer")) {
                    response.sendRedirect("home.jsp");
                } else if (user_type.equals("Retailer")) {
                    response.sendRedirect("admin/adminHome.jsp");
                }
            } else {
                // Invalid credentials
                response.sendRedirect("login.jsp?msg=notexist");
                System.out.println("Invalid username or password.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            response.sendRedirect("login.jsp?msg=invalid");
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
