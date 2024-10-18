<%@ page import="com.digimart.project.ConnectionProvider" %>
<%@ page import="java.sql.*" %>
<%@ include file="header.jsp" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
    <style>
        /* General Styles */
        body {
            display: flex; /* Use flexbox */
            flex-direction: column; /* Stack children vertically */
            height: 100vh; /* Full viewport height */
            margin: 0; /* Remove default margin */
            background: linear-gradient(135deg, #96e6a1 0%, #d4fc79 100%); /* Light green gradient */
            min-height: 100vh;
        }

        h1 {
            font-size: 5rem; /* Responsive font size */
            color: #2c6fbb; /* Cool blue for headings */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Subtle shadow for depth */
            margin: auto; /* Center heading vertically */
        }

        .footer {
            background-color: #4caf50; /* Same green as navbar */
            color: white; /* White text */
            text-align: center; /* Center text */
            padding: 20px; /* Padding around footer */
            margin-top: auto; /* Push footer to the bottom */
            width: 100%; /* Full width */
        }

        /* Card Styles */
        .card-container {
            display: flex; /* Use flexbox for layout */
            flex-wrap: wrap; /* Allow wrapping of cards */
            justify-content: center; /* Center cards horizontally */
            padding: 20px; /* Padding around cards */
        }

        .card {
            background: linear-gradient(135deg,  #d4fc79, #e3f2fd);
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Card shadow */
            margin: 15px; /* Margin between cards */
            padding: 20px; /* Padding inside cards */
            width: 300px; /* Fixed width for cards */
            text-align: center; /* Center text */
            transition: transform 0.2s; /* Animation for hover effect */
        }

        .card:hover {
            transform: translateY(-10px); /* Lift card on hover */
        }

        .card img {
            width: 100%; /* Make image responsive */
            height: 200px; /* Maintain aspect ratio */
            border-radius: 8px; /* Match card border radius */
        }

        .card h4 {
            color: #2c6fbb; /* Heading color */
            margin: 10px 0; /* Margin for spacing */
        }

        .card p {
            color: #666; /* Gray text for description */
        }

        .add-to-cart {
            background-color: #28a745; /* Green background for button */
            color: white; /* White text */
            padding: 10px 15px; /* Padding for button */
            border: none; /* No border */
            border-radius: 5px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor */
            transition: background-color 0.3s; /* Smooth transition */
            text-decoration: none; /* Remove underline */
            display: inline-block; /* Ensure button displays correctly */
        }

        .add-to-cart:hover {
            background-color: #218838; /* Darker green on hover */
        }

        /* Alert Styles */
        .alert {
            text-align: center; /* Center alert text */
            margin: 10px 0; /* Margin for spacing */
            color: #4caf50; /* Green text for success */
            font-size: 1.2em; /* Font size for alerts */
        }
    </style>
</head>
<body>
    <div style="color: white; text-align: center; font-size: 30px;">Home <i class="fa fa-institution"></i></div>
    <%
        String msg = request.getParameter("msg");
        if (msg != null) {
            if ("added".equals(msg)) {
    %>
    <h3 class="alert">Product added successfully!</h3>
    <%
            } else if ("exist".equals(msg)) {
    %>
    <h3 class="alert">Product already exists in your cart! Quantity increased!</h3>
    <%
            } else if ("error".equals(msg)) {
    %>
    <h3 class="alert">Something went wrong! Try Again!</h3>
    <%
            }
        }
    %>
    
    <div class="card-container">
    <%
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Products WHERE status ='Available'");

            while (rs.next()) {
    %>
        <div class="card">
            <img src="data:image/jpg;base64,<%= Base64.getEncoder().encodeToString(rs.getBytes("image")) %>" alt="Product Image">
            <h4><%= rs.getString("name") %></h4>
            <p><strong>Category:</strong> <%= rs.getString("category") %></p>
            <p><strong>Description:</strong> <%= rs.getString("description") %></p>
            <p><strong>Available Quantity:</strong> <%= rs.getBigDecimal("available_qty") %> <%= rs.getString("unit") %></p>
            <p class="price"><strong> Price:</strong><i class="fa fa-inr"></i> <%= rs.getBigDecimal("price_per_unit") %></p>
            <a href="AddToCartServlet?product_id=<%= rs.getInt("product_id") %>" class="add-to-cart">Add to Cart <i class='fas fa-cart-plus'></i></a>
        </div>
    <%
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Better to log this
        } finally {
            // Close resources in the reverse order of their creation
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Better to log this
            }
        }
    %>
    </div>

</body>
<%@ include file="footer.jsp" %>
</html>
