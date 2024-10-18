package com.digimart.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimart.project.ConnectionProvider;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/AddressPaymentForOrderServlet")
public class AddressPaymentForOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("user_id");
        String email = (String) session.getAttribute("email"); // Retrieve user email from session
        String fullName = request.getParameter("full_name"); // Corrected parameter name
        String mobileNumber = request.getParameter("phone_number"); // Corrected parameter name
        String address = request.getParameter("street_address"); // Corrected parameter name
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalCode = request.getParameter("postal_code"); // Corrected parameter name
        String country = request.getParameter("country");
        boolean isDefault = true; // Set this as true if this is the default address

        // Ensure userId is available
        if (userId == null) {
            response.sendRedirect("login.jsp"); // Redirect to login if user_id is null
            return;
        }

        try (Connection con = ConnectionProvider.getCon()) {
            // Check if a default address already exists
            PreparedStatement checkAddressStmt = con.prepareStatement(
                "SELECT address_id FROM address WHERE user_id = ? AND is_default = TRUE"
            );
            checkAddressStmt.setInt(1, userId);
            ResultSet rs = checkAddressStmt.executeQuery();

            if (rs.next()) {
                // If a default address exists, update it
                String sqlUpdate = "UPDATE address SET full_name = ?, phone_number = ?, street_address = ?, " +
                                   "city = ?, state = ?, postal_code = ?, country = ? " +
                                   "WHERE user_id = ? AND is_default = TRUE";
                try (PreparedStatement updateStmt = con.prepareStatement(sqlUpdate)) {
                    updateStmt.setString(1, fullName);
                    updateStmt.setString(2, mobileNumber);
                    updateStmt.setString(3, address);
                    updateStmt.setString(4, city);
                    updateStmt.setString(5, state);
                    updateStmt.setString(6, postalCode);
                    updateStmt.setString(7, country);
                    updateStmt.setInt(8, userId);
                    int rowsUpdated = updateStmt.executeUpdate();

                    if (rowsUpdated > 0) {
                        session.setAttribute("address_id", rs.getInt("address_id")); // Set address_id in session
                    }
                }
            } else {
                // No default address found, create a new one
                String sqlInsert = "INSERT INTO address (user_id, full_name, phone_number, street_address, " +
                                   "city, state, postal_code, country, is_default) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement insertStmt = con.prepareStatement(sqlInsert)) {
                    insertStmt.setInt(1, userId);
                    insertStmt.setString(2, fullName);
                    insertStmt.setString(3, mobileNumber);
                    insertStmt.setString(4, address);
                    insertStmt.setString(5, city);
                    insertStmt.setString(6, state);
                    insertStmt.setString(7, postalCode);
                    insertStmt.setString(8, country);
                    insertStmt.setBoolean(9, isDefault);
                    int rowsInserted = insertStmt.executeUpdate();

                    if (rowsInserted > 0) {
                        // Retrieve the newly created address_id
                        try (PreparedStatement addressIdStmt = con.prepareStatement(
                            "SELECT address_id FROM address WHERE user_id = ? AND is_default = TRUE ORDER BY address_id DESC LIMIT 1"
                        )) {
                            addressIdStmt.setInt(1, userId);
                            ResultSet idRs = addressIdStmt.executeQuery();
                            if (idRs.next()) {
                                int addressId = idRs.getInt("address_id");
                                session.setAttribute("address_id", addressId); // Set address_id in session
                            }
                        }
                    }
                }
            }

            // Update delivery date based on orders
         // Set delivery_date to 7 days from now if it is currently NULL
            String updateDeliveryDateSQL = 
                "UPDATE address " +
                "SET delivery_date = DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 7 DAY) " +
                "WHERE delivery_date IS NULL AND user_id = ?";

            try (PreparedStatement updateDeliveryStmt = con.prepareStatement(updateDeliveryDateSQL)) {
                updateDeliveryStmt.setInt(1, userId);
                updateDeliveryStmt.executeUpdate(); // No need to check rowsUpdated
            }

            // Redirect to billing page after processing
            response.sendRedirect("bill.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
            // You may want to handle exceptions and show error messages differently
            session.setAttribute("error_message", "An error occurred while updating your address.");
            response.sendRedirect("error.jsp"); // Redirect to an error page or handle it accordingly
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
