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
import com.digimart.project.ConnectionProvider;
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("product_id"));
        int quantity = 1;
        int userId = (int) request.getSession().getAttribute("user_id"); // Assuming user is logged in
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            
            // Get the price of the product
            String getProductPriceQuery = "SELECT price_per_unit FROM products WHERE product_id = ?";
            stmt = con.prepareStatement(getProductPriceQuery);
            stmt.setInt(1, productId);
            rs = stmt.executeQuery();
            
            double pricePerUnit = 0.0;
            if (rs.next()) {
                pricePerUnit = rs.getDouble("price_per_unit");
            }
            
            double totalPrice = pricePerUnit * quantity;

            // Check if product already exists in the user's cart
            String checkProductQuery = "SELECT * FROM cart WHERE user_id = ? AND product_id = ? AND status = 'active'";
            stmt = con.prepareStatement(checkProductQuery);
            stmt.setInt(1, userId);
            stmt.setInt(2, productId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Product exists in the cart, update quantity and price
                String updateCartQuery = "UPDATE cart SET quantity = 1 + ?, price = price + ? WHERE user_id = ? AND product_id = ? AND status = 'active'";
                stmt = con.prepareStatement(updateCartQuery);
                stmt.setInt(1, quantity);
                stmt.setDouble(2, totalPrice); // Update the total price
                stmt.setInt(3, userId);
                stmt.setInt(4, productId);
                stmt.executeUpdate();
                response.sendRedirect("home.jsp?msg=exist");
            } else {
                // Product doesn't exist, add a new entry to the cart
                String addToCartQuery = "INSERT INTO cart (user_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
                stmt = con.prepareStatement(addToCartQuery);
                stmt.setInt(1, userId);
                stmt.setInt(2, productId);
                stmt.setInt(3, quantity);
                stmt.setDouble(4, totalPrice); // Set the total price
                stmt.executeUpdate();
                response.sendRedirect("home.jsp?msg=added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("home.jsp?msg=error");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
