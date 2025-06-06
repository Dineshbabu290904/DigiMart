<%@ page import="com.digimart.project.ConnectionProvider" %>
<%@ page import="java.sql.*" %>
<%@ include file="adminHeader.jsp" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Products & Edit Products</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #333;
            color: white;
        }

        h3 {
            color: green; /* Gold color for headings */
            text-align: center;
        }

        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }

        .card {
		    background: linear-gradient(135deg, #a8e6cf, #d0eaff, #ffccd5);
		    border-radius: 10px;
		    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
		    width: 350px;
		    padding: 20px;
		    text-align: center;
		    transition: transform 0.3s;
		}


        .card:hover {
            transform: scale(1.05);
        }

        .card img {
            width: 100%;
            height: auto;
            border-radius: 5px;
        }

        .card h4 {
            color: green; /* Cool blue for headings */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Subtle shadow for depth */
        }

        .card p {
            color: #ccc; /* Light grey for text */
            margin: 10px 0;
        }

        .edit-btn {
            background-color: #28a745; /* Green background for buttons */
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            display: inline-block;
            transition: background-color 0.3s;
        }

        .edit-btn:hover {
            background-color: #218838; /* Darker green on hover */
        }

        .price {
            font-size: 20px;
            color: #FFD700; /* Gold color for price */
        }

        .msg {
            text-align: center;
            margin: 20px;
        }
		.card p {
		    color: #444; /* Dark gray for better readability */
		    margin: 10px 0;
		}
    </style>
</head>
<body>
<div style="color: #2c6fbb; text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.75); text-align:center; font-size:30px;">All Products & Edit Products <i class='fab fa-elementor'></i></div>

<% String msg = request.getParameter("msg"); %>
<% if (msg != null) { %>
    <h3 class="alert" style="color: <%=(msg.equals("done") ? "green" : "red")%>;">
        <% if (msg.equals("done")) { %>
            Product Updated Successfully!
        <% } else { %>
            Something went wrong! Try Again!
        <% } %>
    </h3>
<% } %>

<div class="container">
    <% 
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");
            while (rs.next()) {
    %>
    <div class="card">
        <img src="data:image/jpg;base64,<%=Base64.getEncoder().encodeToString(rs.getBytes("image")) %>" alt="Product Image">
        <h4><%= rs.getString("name") %></h4>
        <p><strong>Category:</strong> <%= rs.getString("category") %></p>
        <p><strong>Description:</strong> <%= rs.getString("description") %></p>
        <p><strong>Available Quantity:</strong> <%= rs.getBigDecimal("available_qty") %> <%= rs.getString("unit") %></p>
        <p class="price"><i class="fa fa-inr"></i> <%= rs.getBigDecimal("price_per_unit") %></p>
        <p><strong>Status:</strong> <%= rs.getString("status") %></p>
        <p><strong>Date Listed:</strong> <%= rs.getTimestamp("date_listed") %></p>
        <a href="editProduct.jsp?product_id=<%= rs.getInt("product_id") %>" class="edit-btn">Edit <i class='fas fa-pen-fancy'></i></a>
        <br>
        <a href="changePhoto.jsp?product_id=<%= rs.getInt("product_id") %>" class="edit-btn">Change Photo</a>
    </div>
    <% 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>
