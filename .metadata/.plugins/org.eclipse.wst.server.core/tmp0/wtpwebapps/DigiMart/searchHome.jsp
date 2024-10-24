<%@ page import="com.digimart.project.ConnectionProvider" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Base64" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
    <link rel="stylesheet" href="../css/home-style.css"> <!-- Include your CSS file for styling -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> <!-- Font Awesome -->
    <style>
    body {
	    background: linear-gradient(135deg, #96e6a1 0%, #d4fc79 100%); /* Light green gradient */
	    min-height: 100vh;
	}
	
	.card-container {
	    display: flex; /* Use flexbox for layout */
	    flex-wrap: wrap; /* Allow wrapping */
	    justify-content: center; /* Center items */
	    margin: 20px; /* Margin around the card container */
	}
	
	.card {
	    background: white; /* White background for cards */
	    border-radius: 10px; /* Rounded corners */
	    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2); /* Subtle shadow for depth */
	    margin: 15px; /* Margin around each card */
	    padding: 15px; /* Padding inside the card */
	    text-align: center; /* Center text inside cards */
	    width: 300px; /* Fixed width for cards */
	}
	
	.card img {
	    width: 100%; /* Responsive image */
	    border-radius: 10px; /* Rounded corners for images */
	}
	
	.card h4 {
	    font-size: 1.2em; /* Font size for product name */
	    color: #2c6fbb; /* Cool blue for product name */
	    margin: 10px 0; /* Margin above and below product name */
	}
	
	.card p {
	    margin: 5px 0; /* Margin above and below paragraphs */
	}
	
	.card .price {
	    font-size: 1.5em; /* Larger font size for price */
	    color: #ff5722; /* Orange color for price */
	}
	
	.card .add-to-cart {
	    background-color: #4caf50; /* Green button for 'Add to Cart' */
	    color: white; /* White text for button */
	    padding: 10px 15px; /* Padding inside button */
	    border: none; /* Remove border */
	    border-radius: 5px; /* Rounded corners */
	    cursor: pointer; /* Pointer on hover */
	    text-decoration: none; /* Remove underline */
	    transition: background-color 0.3s; /* Smooth background color change */
	}
	
	.card .add-to-cart:hover {
	    background-color: #388e3c; /* Darker green on hover */
	}
	    
    </style>
</head>
<body>
    <div style="color: white; text-align: center; font-size: 30px;">Home <i class="fa fa-institution"></i></div>
    <div class="card-container">
        <%
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                String search = request.getParameter("Search");
                con = ConnectionProvider.getCon();

                // Use PreparedStatement to prevent SQL injection
                String query = "SELECT * FROM products WHERE (name LIKE ? OR category LIKE ?) AND status='Available'";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, "%" + search + "%"); // Set the first parameter
                pstmt.setString(2, "%" + search + "%"); // Set the second parameter

                rs = pstmt.executeQuery();
                
                // Track if any products were found
                boolean hasProducts = false;

                while (rs.next()) {
                    hasProducts = true; // Found at least one product
        %>
            <div class="card">
                <img src="data:image/jpg;base64,<%= Base64.getEncoder().encodeToString(rs.getBytes("image")) %>" alt="Product Image">
                <h4><%= rs.getString("name") %></h4>
                <p><strong>Category:</strong> <%= rs.getString("category") %></p>
                <p><strong>Description:</strong> <%= rs.getString("description") %></p>
                <p><strong>Available Quantity:</strong> <%= rs.getBigDecimal("available_qty") %> <%= rs.getString("unit") %></p>
                <p class="price"><i class="fa fa-inr"></i> <%= rs.getBigDecimal("price_per_unit") %></p>
                <a href="editProduct.jsp?product_id=<%= rs.getInt("product_id") %>" class="add-to-cart">Add to Cart <i class='fas fa-cart-plus'></i></a>
            </div>
        <%
                }
                
                if (!hasProducts) {
        %>
            <h1 style="color:white; text-align: center;">Nothing to show</h1>
        <%
                }
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("<h1 style='color: red; text-align: center;'>Database error: " + e.getMessage() + "</h1>");
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<h1 style='color: red; text-align: center;'>An error occurred: " + e.getMessage() + "</h1>");
            } finally {
                // Close resources
                if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        %>
    </div>
    <br>
    <br>
    <br>
</body>
<%@ include file="footer.jsp" %>
</html>
