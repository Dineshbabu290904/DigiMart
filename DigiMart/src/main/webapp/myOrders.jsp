<%@ include file="header.jsp" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.digimart.project.ConnectionProvider" %>

<%
    // Initialize variables
    Integer userId = (Integer) session.getAttribute("user_id");
    
    if (userId == null) {
        response.sendRedirect("login.jsp"); // Redirect to login if user_id is null
        return;
    }

    StringBuilder orderItemsHtml = new StringBuilder();

    // Retrieve order details from the cart and product tables
    String orderQuery = "SELECT c.quantity, c.price, p.name AS product_name, p.category, " +
                        "c.added_at AS order_date, a.delivery_date, c.status AS order_status " +
                        "FROM cart c " +
                        "JOIN products p ON c.product_id = p.product_id " +
                        "JOIN address a ON c.user_id = a.user_id " +
                        "WHERE c.user_id = ? AND c.status IN ('ordered', 'processing')";

    try (Connection con = ConnectionProvider.getCon(); 
         PreparedStatement orderStmt = con.prepareStatement(orderQuery)) {
        
        orderStmt.setInt(1, userId);
        ResultSet orderRs = orderStmt.executeQuery();

        int serialNo = 1; // Initialize serial number for the order items
        while (orderRs.next()) {
            String productName = orderRs.getString("product_name");
            String category = orderRs.getString("category");
            double price = orderRs.getDouble("price");
            int quantity = orderRs.getInt("quantity");
            double subTotal = price * quantity; // Calculate subtotal
            String orderDate = orderRs.getString("order_date");
            String deliveryDate = orderRs.getString("delivery_date");
            String orderStatus = orderRs.getString("order_status");

            // Create a row in HTML for each order item
            orderItemsHtml.append("<tr>")
                          .append("<td>").append(serialNo++).append("</td>")
                          .append("<td>").append(productName).append("</td>")
                          .append("<td>").append(category).append("</td>")
                          .append("<td><i class='fa fa-inr'></i> ").append(price).append("</td>")
                          .append("<td>").append(quantity).append("</td>")
                          .append("<td><i class='fa fa-inr'></i> ").append(subTotal).append("</td>")
                          .append("<td>").append(orderDate).append("</td>")
                          .append("<td>").append(deliveryDate).append("</td>")
                          .append("<td>").append("Cash on Delivery").append("</td>") // Assuming COD is the only payment method
                          .append("<td>").append(orderStatus).append("</td>")
                          .append("</tr>");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("<h3>An error occurred while retrieving your orders.</h3>");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Orders</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"> <!-- Font Awesome for icons -->
    <style>
        body {
            background-color: #e9ecef; /* Light background for the page */
            color: #343a40; /* Dark text color */
        }
        .page-title {
            color: #007bff; /* Vibrant blue for the title */
            text-align: center;
            font-size: 36px;
            margin: 20px 0;
        }
        .table-container {
            margin-top: 20px;
            background-color: white; /* White background for the table container */
            border-radius: 10px; /* Rounded corners */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Subtle shadow for depth */
        }
        th {
            background-color: #007bff; /* Vibrant blue for header */
            color: white; /* White text in header */
        }
        tbody tr:hover {
            background-color: #f8f9fa; /* Light hover effect for rows */
        }
        .footer {
            text-align: center;
            margin-top: 30px;
            color: #6c757d; /* Subtle gray for footer text */
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="page-title">My Orders <i class='fab fa-elementor'></i></div>
        <div class="table-container p-4">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th scope="col">S.No</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Category</th>
                        <th scope="col"><i class="fa fa-inr"></i> Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col"><i class="fa fa-inr"></i> Sub Total</th>
                        <th scope="col">Order Date</th>
                        <th scope="col">Expected Delivery Date</th>
                        <th scope="col">Payment Method</th>
                        <th scope="col">Status</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Dynamically populated order items -->
                    <%= orderItemsHtml.toString() %>
                </tbody>
            </table>
        </div>
        <div class="footer">
            <p>&copy; 2024 DigiMart. All Rights Reserved.</p>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script> <!-- jQuery -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script> <!-- Popper.js for Bootstrap -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> <!-- Bootstrap JS -->
</body>
</html>