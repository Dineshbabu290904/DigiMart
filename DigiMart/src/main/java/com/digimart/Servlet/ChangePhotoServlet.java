package com.digimart.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.digimart.project.ConnectionProvider;

@WebServlet("/admin/ChangePhotoServlet")
public class ChangePhotoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productId = request.getParameter("product_id");
        System.out.println("Product ID: " + productId); // Debugging output

        Part imagePart = request.getPart("image");
        InputStream imageStream = null;

        if (imagePart != null && imagePart.getSize() > 0) {
            imageStream = imagePart.getInputStream();
            System.out.println("Image Part Size: " + imagePart.getSize()); // Debugging output
        } else {
            System.out.println("No image part uploaded."); // Debugging output
        }

        try (Connection con = ConnectionProvider.getCon()) {
            String sql = "UPDATE PRODUCTS SET image = ? WHERE product_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            if (imageStream != null) {
                ps.setBlob(1, imageStream);
            } else {
                ps.setString(1, null); // Handle case where no image is uploaded
            }
            ps.setInt(2, Integer.parseInt(productId));

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                response.sendRedirect("allProductEditProduct.jsp?msg=done");
            } else {
                response.sendRedirect("changePhoto.jsp?product_id=" + productId + "&msg=error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("changePhoto.jsp?product_id=" + productId + "&msg=error");
        }
    }
}
