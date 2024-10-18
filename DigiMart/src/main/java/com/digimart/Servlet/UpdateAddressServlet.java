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

@WebServlet("/UpdateAddressServlet")
public class UpdateAddressServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int addressId = Integer.parseInt(request.getParameter("address_id"));
        String fullName = request.getParameter("full_name");
        String phoneNumber = request.getParameter("phone_number");
        String streetAddress = request.getParameter("street_address");
        String apartmentNumber = request.getParameter("apartment_number");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalCode = request.getParameter("postal_code");
        String country = request.getParameter("country");
        String addressType = request.getParameter("address_type");
        boolean isDefault = request.getParameter("is_default") != null;

        String updateQuery = "UPDATE address SET full_name = ?, phone_number = ?, street_address = ?, apartment_number = ?, city = ?, state = ?, postal_code = ?, country = ?, address_type = ?, is_default = ? WHERE address_id = ?";

        try (Connection con = ConnectionProvider.getCon(); 
             PreparedStatement pstmt = con.prepareStatement(updateQuery)) {
            pstmt.setString(1, fullName);
            pstmt.setString(2, phoneNumber);
            pstmt.setString(3, streetAddress);
            pstmt.setString(4, apartmentNumber);
            pstmt.setString(5, city);
            pstmt.setString(6, state);
            pstmt.setString(7, postalCode);
            pstmt.setString(8, country);
            pstmt.setString(9, addressType);
            pstmt.setBoolean(10, isDefault);
            pstmt.setInt(11, addressId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                // Redirect with success message
                response.sendRedirect("changeDetails.jsp?message=Address+successfully+updated!");
            } else {
                // Redirect with failure message
                response.sendRedirect("changeDetails.jsp?message=Something+went+wrong!+Try+again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("changeDetails.jsp?message=An+error+occurred!");
        }
    }
}

