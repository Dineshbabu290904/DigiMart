package com.digimart.Servlet;

import java.io.IOException;
import java.math.BigDecimal;
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
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet({ "/admin/UpdateProductServlet"})
public class UpdateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve parameters from the query string
        String productId = request.getParameter("product_id");
        String userId = request.getParameter("user_id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        String pricePerUnitStr = request.getParameter("price_per_unit");
        String unit = request.getParameter("unit");
        String availableQtyStr = request.getParameter("available_qty");
        String status = request.getParameter("status");

        System.out.println(productId);
        System.out.println(userId);
        System.out.println(name);
        System.out.println(description);
        System.out.println(category);
        System.out.println(pricePerUnitStr);
        System.out.println(unit);
        System.out.println(availableQtyStr);
        System.out.println(status);

        try (Connection con = ConnectionProvider.getCon()) {
            // Prepare SQL statement
            String sql = "UPDATE products SET user_id = ?, name = ?, description = ?, category = ?, "
                       + "price_per_unit = ?, unit = ?, available_qty = ?, status = ?";

            int paramIndex = 9; // Initialize parameter index
            sql += " WHERE product_id = ?";

            // Create PreparedStatement
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, Integer.parseInt(userId));
                ps.setString(2, name);
                ps.setString(3, description);
                ps.setString(4, category);
                ps.setBigDecimal(5, new BigDecimal(pricePerUnitStr)); // Convert to BigDecimal
                ps.setString(6, unit);
                ps.setBigDecimal(7, new BigDecimal(availableQtyStr)); // Convert to BigDecimal
                ps.setString(8, status);
                ps.setInt(9, Integer.parseInt(productId));

                // Execute the update
                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    response.sendRedirect("allProductEditProduct.jsp?msg=done");
                } else {
                    response.sendRedirect("editProduct.jsp?product_id=" + productId + "&msg=error");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("editProduct.jsp?product_id=" + productId + "&msg=error");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("editProduct.jsp?product_id=" + productId + "&msg=invalid");
        }
    }

    // Handle POST requests by forwarding them to doGet
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
