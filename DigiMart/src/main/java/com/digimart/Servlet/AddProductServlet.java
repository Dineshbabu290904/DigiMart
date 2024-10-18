package com.digimart.Servlet;

import java.io.InputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.digimart.project.ConnectionProvider;

@WebServlet({ "/AddProductServlet", "/admin/AddProductServlet" })
@MultipartConfig(maxFileSize = 1024 * 1024 * 10) // 10MB max file size
public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form data
        String name = request.getParameter("P_name");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String unit = request.getParameter("unit");
        String available_qty = request.getParameter("available_qty");
        String status = request.getParameter("status");

        // Get the image file part
        Part filePart = request.getPart("productImage");
        InputStream inputStream = null;

        // Ensure file is not empty
        if (filePart != null && filePart.getSize() > 0) {
            inputStream = filePart.getInputStream();  // Obtain input stream of the uploaded file
        }

        // Input validation
        if (name == null || name.trim().isEmpty() ||
            category == null || category.trim().isEmpty() ||
            description == null || description.trim().isEmpty() ||
            price == null || price.trim().isEmpty() ||
            unit == null || unit.trim().isEmpty() ||
            available_qty == null || available_qty.trim().isEmpty() ||
            status == null || status.trim().isEmpty() ||
            inputStream == null) {

            response.sendRedirect("addNewProduct.jsp?msg=None");
            return;
        }

        // Get the user_id from the session
        HttpSession session = request.getSession(false);
        Integer userId = (Integer) session.getAttribute("user_id");

        // Check if the user_id exists in session
        if (userId == null) {
            response.sendRedirect("login.jsp?msg=loginrequired");  // Redirect to login if user is not logged in
            return;
        }

        try {
            // Get database connection
            Connection con = ConnectionProvider.getCon();

            // SQL query to insert product details including image as BLOB and user_id
            String query = "INSERT INTO Products (name, category, price_per_unit, available_qty, description, unit, status, image, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            // Set parameters for the SQL query
            ps.setString(1, name);
            ps.setString(2, category);
            ps.setDouble(3, Double.parseDouble(price));
            ps.setInt(4, Integer.parseInt(available_qty));
            ps.setString(5, description);
            ps.setString(6, unit);
            ps.setString(7, status);

            // Set the image as BLOB
            if (inputStream != null) {
                ps.setBlob(8, inputStream);
            }

            // Set the user_id
            ps.setInt(9, userId);

            // Execute the query
            ps.executeUpdate();
            con.close();

            // Redirect to the form page with success message
            response.sendRedirect("addNewProduct.jsp?msg=done");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("addNewProduct.jsp?msg=invalid");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
