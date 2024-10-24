<%@ page import="com.digimart.project.ConnectionProvider" %>
<%@ page import="java.sql.*" %>
<%@ include file="adminHeader.jsp" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/addNewProduct-style.css">
    <title>Add New Product</title>
    <style>
        body {
            background: linear-gradient(135deg, #d4fc79 0%, #96e6a1 100%); /* Light green gradient */
        }
        .container {
            margin-top: 30px;
        }
        .alert {
            text-align: center;
        }
        .input-style {
            border-radius: 25px;
            height: 50px;
            background-color: #e0f7fa; /* Light cyan background for inputs */
            border: 1px solid #ccc;
        }
        .button {
            border-radius: 25px;
            background-color: #4caf50; /* Green background */
            color: white;
            padding: 12px 25px;
            border: none;
            transition: background 0.3s;
        }
        .button:hover {
            background-color: #45a049; /* Darker green on hover */
        }
        h3 {
            color: #2c6fbb; /* Cool blue for headings */
            text-shadow: 1px 1px 3px rgba(0, 0, 0, .25);
        }
    </style>
</head>
<body>

<%
    int id = 1; // Default product ID
    String msg = request.getParameter("msg"); // Get message parameter from the request
    try {
        Connection con = ConnectionProvider.getCon();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT MAX(product_id) FROM products");
        if (resultSet.next()) {
            id = resultSet.getInt(1) + 1; // Get the next product ID
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("SQL Error: " + e.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error: " + e.getMessage());
    }
%>

<div class="container">
    <% if (msg != null) { %>
        <div class="alert alert-<%= msg.equals("done") ? "success" : "danger" %>">
            <%= msg.equals("done") ? "Product Added Successfully!" : "Something went wrong! Try Again!" %>
        </div>
    <% } %>

    <h3>Product ID: <%= id %></h3>
    
    <form action="AddProductServlet" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="<%= id %>">

        <div class="row">
            <div class="col-md-6">
                <h3>Enter Name</h3>
                <input class="input-style form-control" type="text" name="P_name" placeholder="Enter Name" required maxlength="100">
                <hr>
                
                <h3>Enter Description</h3>
                <textarea class="input-style form-control" name="description" placeholder="Enter Product Description" required maxlength="500"></textarea>
                <hr>
                
                <h3>Unit</h3>
                <input class="input-style form-control" type="text" name="unit" placeholder="Enter Unit (e.g., kg, lb)" required maxlength="20">
                <hr>

                <h3>Product Image (optional)</h3>
                <input class="input-style form-control" type="file" name="productImage" accept="image/*">
                <hr>
            </div>

            <div class="col-md-6">
                <h3>Enter Category</h3>
                <input class="input-style form-control" type="text" name="category" placeholder="Enter Category" required maxlength="100">
                <hr>

                <h3>Enter Price</h3>
                <input class="input-style form-control" type="number" step="0.01" name="price" placeholder="Enter Price per unit" required min="0">
                <hr>

                <h3>Available Quantity</h3>
                <input class="input-style form-control" type="number" name="available_qty" placeholder="Enter Available Quantity" required min="0">
                <hr>

                <h3>Status</h3>
                <select name="status" class="input-style form-control">
                    <option value="Available">Available</option>
                    <option value="Out of Stock">Out of Stock</option>
                </select>
                <hr>
            </div>
        </div>

        <button type="submit" class="button">Save <i class='far fa-arrow-alt-circle-right'></i></button>
    </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
<%@ include file="../footer.jsp" %>
</html>
