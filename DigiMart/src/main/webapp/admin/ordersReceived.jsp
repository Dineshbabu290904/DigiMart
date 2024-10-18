<%@ page import="com.digimart.project.ConnectionProvider" %>
<%@ page import="java.sql.*" %>
<%@ include file="adminHeader.jsp" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/ordersReceived-style.css">
<!-- Add Bootstrap for better styling -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
<title>Orders Received</title>
<style>
.table {
    width: 100%;
    margin: 20px auto;
    border-collapse: separate;
    border-spacing: 0;
}
.table th, .table td {
    text-align: center;
    padding: 15px;
    border: 1px solid #dee2e6; /* Define a solid border for cells */
}
.alert {
    color: red; /* Highlight alert messages in red */
    text-align: center;
}
</style>
</head>
<body>
<div style="color: white; text-align: center; font-size: 30px;">Orders Received <i class="fas fa-archive"></i></div>
<%
 	boolean orderCanceled = false;  // Set based on your application logic
    boolean orderUpdated = false;    // Set based on your application logic
    boolean orderError = false;      // Set based on your application logic

    // Example logic to set these variables (modify according to your actual logic)
    String action = request.getParameter("action");  // Example parameter to determine action
    if ("cancel".equals(action)) {
        orderCanceled = true;
    } else if ("update".equals(action)) {
        orderUpdated = true;
    } else if ("error".equals(action)) {
        orderError = true;
    }
    
%>
<div class="container">
        <div class="header-title">Orders Received <i class="fas fa-archive"></i></div>

        <div class="alert alert-success" style="display: <%= orderCanceled ? "block" : "none" %>;">
            Order Cancelled Successfully!
        </div>
        <div class="alert alert-success" style="display: <%= orderUpdated ? "block" : "none" %>;">
            Successfully Updated!
        </div>
        <div class="alert alert-danger" style="display: <%= orderError ? "block" : "none" %>;">
            Something went wrong! Try Again!
        </div>
<table class="table table-striped">
    <thead>
        <tr>
            <th>Mobile Number</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th><i class="fa fa-inr"></i> Sub Total</th>
            <th>Address</th>
            <th>City</th>
            <th>State</th>
            <th>Country</th>
            <th>Order Date</th>
            <th>Expected Delivery Date</th>
            <th>Payment Method</th>
            <th>T-ID</th>
            <th>Status</th>
            <th>Cancel Order <i class='fas fa-window-close'></i></th>
            <th>Order Delivered <i class='fas fa-dolly'></i></th>
        </tr>
    </thead>
<tbody>
    <%
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Get the connection from ConnectionProvider
            con = ConnectionProvider.getCon();
            stmt = con.createStatement();

            // SQL query to fetch orders and their details including address information
            String query = "SELECT u.phone, p.name, c.quantity, "
                         + "c.updated_at, a.delivery_date, "
                         + "a.payment_method, a.transaction_id, c.status,p.price_per_unit, "
                         + "a.street_address, a.city, a.state, a.country,c.cart_id "
                         + "FROM cart c "
                         + "JOIN products p ON c.product_id = p.product_id "
                         + "JOIN users u ON c.user_id = u.user_id "
                         + "JOIN address a ON u.user_id = a.user_id";  // Join with address based on user_id

            rs = stmt.executeQuery(query);

            // Iterate over the result set to display the orders
            while (rs.next()) {
                String phone = rs.getString("phone");
                String productName = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double subtotal = quantity * rs.getDouble("price_per_unit"); // Assuming price is retrieved in a joined manner
                String address = rs.getString("street_address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String country = rs.getString("country");
                String orderDate = rs.getString("updated_at");
                String expectedDeliveryDate = rs.getString("delivery_date");
                String paymentMethod = rs.getString("payment_method");
                String transactionId = rs.getString("transaction_id");
                String status = rs.getString("status");
                int cartId = rs.getInt("cart_id");
    %>
                <tr>
                    <td><%= phone != null ? phone : "N/A" %></td>
                    <td><%= productName != null ? productName : "N/A" %></td>
                    <td><%= quantity %></td>
                    <td><i class="fa fa-inr"></i> <%= subtotal %></td>
                    <td><%= address != null ? address : "N/A" %></td>
                    <td><%= city != null ? city : "N/A" %></td>
                    <td><%= state != null ? state : "N/A" %></td>
                    <td><%= country != null ? country : "N/A" %></td>
                    <td><%= orderDate != null ? orderDate : "N/A" %></td>
                    <td><%= expectedDeliveryDate != null ? expectedDeliveryDate : "N/A" %></td>
                    <td><%= paymentMethod != null ? paymentMethod : "N/A" %></td>
                    <td><%= transactionId != null ? transactionId : "N/A" %></td>
                    <td><%= status != null ? status : "N/A" %></td>
                    <td><a href="CancelOrderServlet?cartId=<%= cartId %>">Cancel <i class='fas fa-window-close'></i></a></td>
                    <td><a href="MarkDeliveredServlet?cartId=<%= cartId %>">Delivered <i class='fas fa-dolly'></i></a></td>
                </tr>
    <%
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    %>
</tbody>


</table>
<br>
<br>
<br>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<%@ include file="../footer.jsp" %>
