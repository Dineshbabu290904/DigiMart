<%@ page import="com.digimart.project.ConnectionProvider" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="javax.servlet.annotation.MultipartConfig" %>
<%@ page import="javax.servlet.annotation.WebServlet" %>
<%@ page import="javax.servlet.http.*" %>
<%@ include file="adminHeader.jsp" %>
<%@ page import="java.util.Base64" %>
<%@ include file="../footer.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Change Product Photo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #333;
            color: white;
            text-align: center;
        }
        .form-container {
            max-width: 400px;
            margin: auto;
            background-color: #444;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        input[type="file"] {
            margin: 10px 0;
        }
        .submit-btn {
            background-color: #28a745;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .submit-btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h2>Change Product Photo</h2>
    <div class="form-container">
        <form action="ChangePhotoServlet" method="post" enctype="multipart/form-data">
            <%String productId = request.getParameter("product_id"); %>
            <input type="hidden" name="product_id" value="${request.getParameter("product_id")}"/>

            <% 
            // Get the product ID from the request
            
            session.setAttribute("product_id", productId);
            String imageBase64 = null;

            // Fetch the current image from the database
            if (productId != null) {
                try {
                    Connection con = ConnectionProvider.getCon();
                    PreparedStatement ps = con.prepareStatement("SELECT image FROM products WHERE product_id = ?");
                    ps.setInt(1, Integer.parseInt(productId));
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        // Convert the image bytes to Base64
                        byte[] imageBytes = rs.getBytes("image");
                        if (imageBytes != null) {
                            imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            %>

            <h3>Current Image</h3>
            <%
            // Display the current image
            if (imageBase64 != null) {
            %>
                <img src="data:image/jpeg;base64,<%= imageBase64 %>" alt="Product Image" width="200" height="200" />
            <%
            } else {
                out.println("<p>No image available</p>");
            }
            %>
			<br>
            <label for="image">Select New Photo:</label><br>
            <input type="file" name="image" id="image" required><br>
            <button type="submit" class="submit-btn">Update Photo</button>
        </form>
    </div>
</body>
</html>
