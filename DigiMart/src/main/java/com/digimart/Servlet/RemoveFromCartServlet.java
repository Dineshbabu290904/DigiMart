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

@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int userId = (int) request.getSession().getAttribute("user_id");
        int productId = Integer.parseInt(request.getParameter("product_id"));
        String message;

        try (Connection con = ConnectionProvider.getCon()) {
            // Prepare the SQL statement to remove the product from the cart
            PreparedStatement ps = con.prepareStatement("DELETE FROM cart WHERE user_id = ? AND product_id = ?");
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                message = "removed"; // Product successfully removed
            } else {
                message = "not_found"; // Product not found in cart
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message = "error"; // Some error occurred
        }

        // Redirect back to the cart page with a message
        response.sendRedirect("myCart.jsp?msg=" + message);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
}
