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

import com.digimart.project.ConnectionProvider;

@WebServlet("/MarkDeliveredServlet")
public class MarkDeliveredServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String cartId = request.getParameter("cartId");
        boolean isUpdated = false;

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // Get the connection from ConnectionProvider
            con = ConnectionProvider.getCon();
            String query = "UPDATE cart SET status = ? WHERE cart_id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "Delivered"); // Update status to 'Delivered'
            pstmt.setString(2, cartId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        // Redirect back to the orders received page with a status parameter
        response.sendRedirect("admin/ordersReceived.jsp?action=" + (isUpdated ? "update" : "error"));
    }
}
