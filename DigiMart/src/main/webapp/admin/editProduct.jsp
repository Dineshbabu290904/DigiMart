<%@ page import="com.digimart.project.ConnectionProvider" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Base64" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="../css/addNewProduct-style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Edit Product</title>
    <style>
        body {
            background: linear-gradient(135deg, #d4fc79 0%, #96e6a1 100%); /* Light green gradient */
            font-family: Arial, sans-serif;
            color: #333; /* Dark text color for contrast */
        }

        .back {
            color: white;
            margin-left: 2.5%;
            font-size: 1.2em;
            text-decoration: none; /* Remove underline */
        }

        .input-style {
            border-radius: 25px;
            background-color: #e0f7fa; /* Light cyan background */
            border: 1px solid #ccc;
            padding: 10px;
            width: 100%;
        }

        h3.card-title {
            color: #2c6fbb; /* Cool blue for headings */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Subtle shadow for depth */
        }

        button {
            background-color: #28a745; /* Green background */
            color: white; /* White text */
            border: none; /* No border */
            padding: 10px 20px; /* Padding */
            font-size: 16px; /* Font size */
            cursor: pointer; /* Pointer cursor on hover */
            border-radius: 25px; /* Rounded corners */
            transition: background-color 0.3s; /* Smooth background transition */
        }

        button:hover {
            background-color: #218838; /* Darker green on hover */
        }
    </style>
</head>
<body>
    <h2><a class="back" href="allProductEditProduct.jsp"><i class='fas fa-arrow-circle-left'></i> Back</a></h2>

    <%
        String productId = request.getParameter("product_id");
        if (productId != null) {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE product_id = ?");
                ps.setInt(1, Integer.parseInt(productId));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    // Retrieve data from the database
                    int userId = rs.getInt("user_id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String category = rs.getString("category");
                    BigDecimal pricePerUnit = rs.getBigDecimal("price_per_unit");
                    String unit = rs.getString("unit");
                    BigDecimal availableQty = rs.getBigDecimal("available_qty");
                    Timestamp dateListed = rs.getTimestamp("date_listed");
                    byte[] imageBytes = rs.getBytes("image");
                    String status = rs.getString("status");

                    // Convert image to base64 for displaying
                    String imageBase64 = (imageBytes != null) ? Base64.getEncoder().encodeToString(imageBytes) : null;
    %>

    <form action="UpdateProductServlet" method="get" enctype="multipart/form-data">
        <input type="hidden" name="product_id" value="<%= productId %>">
        
        <div class="container">
            <div class="row mb-4"> <!-- Added mb-4 for vertical spacing -->
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title">User ID</h3>
                            <input class="input-style" type="number" name="user_id" value="<%= userId %>" required />
                            <hr>
                            
                            <h3 class="card-title">Name</h3>
                            <input class="input-style" type="text" name="name" value="<%= name %>" required />
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title">Category</h3>
                            <input class="input-style" type="text" name="category" value="<%= category %>" required />
                            <hr>

                            <h3 class="card-title">Price per Unit</h3>
                            <input class="input-style" type="number" name="price_per_unit" value="<%= pricePerUnit %>" required step="0.01" />
                        </div>
                    </div>
                </div>
            </div>

            <div class="row mb-4"> <!-- Added mb-4 for vertical spacing -->
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title">Description</h3>
                            <textarea class="input-style" name="description" required><%= description %></textarea>
                        </div>
                        <hr>
                        <h3 class="card-title">Status</h3>
                            <select class="input-style" name="status" required>
                                <option value="Available" <%= status.equals("Available") ? "selected" : "" %>>Available</option>
                                <option value="Out of Stock" <%= status.equals("Out of Stock") ? "selected" : "" %>>Out of Stock</option>
                            </select>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title">Unit</h3>
                            <input class="input-style" type="text" name="unit" value="<%= unit %>" required />
                            <hr>

                            <h3 class="card-title">Available Quantity</h3>
                            <input class="input-style" type="number" name="available_qty" value="<%= availableQty %>" required />
                        </div>
                    </div>
                </div>
            </div>

            <div style="text-align: center; margin-top: 20px;">
                <button type="submit" name="update">Update Product</button>
            </div>
        </div>
    </form>

    <%
                } else {
                    out.println("<h3 style='color:red;'>Product not found!</h3>");
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<h3 style='color:red;'>Error fetching product data!</h3>");
            }
        } else {
            out.println("<h3 style='color:red;'>Invalid Product ID!</h3>");
        }
    %>

</body>
</html>
