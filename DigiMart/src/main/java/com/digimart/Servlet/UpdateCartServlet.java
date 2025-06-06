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

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("product_id"));
        String action = request.getParameter("action");
        int userId = (int) request.getSession().getAttribute("user_id");
        
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = ConnectionProvider.getCon();
            if ("increase".equals(action)) {
                // Increase quantity
                String updateQuery = "UPDATE cart SET quantity = quantity + 1 WHERE product_id = ? AND user_id = ? AND status = 'active'";
                stmt = con.prepareStatement(updateQuery);
                stmt.setInt(1, productId);
                stmt.setInt(2, userId);
                response.sendRedirect("myCart.jsp?msg=increase");
            } else if ("decrease".equals(action)) {
                // Decrease quantity but ensure it doesn't go below 1
                String updateQuery = "UPDATE cart SET quantity = CASE WHEN quantity > 1 THEN quantity - 1 ELSE quantity END WHERE product_id = ? AND user_id = ? AND status = 'active'";
                stmt = con.prepareStatement(updateQuery);
                stmt.setInt(1, productId);
                stmt.setInt(2, userId);
                response.sendRedirect("myCart.jsp?msg=decrease");
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Redirect back to the shopping cart page
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
}
