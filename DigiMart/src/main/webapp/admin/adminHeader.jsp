<%@page errorPage="../error.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/home-style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <style>
        body {
            background: linear-gradient(135deg, #d4fc79 0%, #96e6a1 100%); /* Light green gradient */
        }
        .navbar {
            background: linear-gradient(135deg, #4caf50, #b2ebf2, #ffccbc); /* Green to Light Blue to Light Pink */
            padding: 10px; /* Padding around navbar */
        }
        .navbar a {
            color: #2c6fbb; /* Cool blue for headings */
            text-shadow: 1px 1px 4px rgba(0, 0, 0, 0.5); /* Subtle shadow for depth */
            margin: 0 15px; /* Spacing between links */
            text-decoration: none; /* Remove underline */
            font-size: 18px; /* Larger font size */
        }
        .navbar a:hover {
            text-decoration: underline; /* Underline on hover */
        }
        h1 {
            color: #2c6fbb; /* Cool blue for headings */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Subtle shadow for depth */
        }
    </style>
</head>
<body>
    <nav class="navbar">
        <a href="adminHome.jsp"><h2>Online Shopping</h2></a>
        <a href="addNewProduct.jsp">Add New Product</a>
        <a href="allProductEditProduct.jsp">All Products & Edit</a>
        <a href="messagesReceived.jsp">Messages Received</a>
        <a href="ordersReceived.jsp">Orders Received</a>
        <a href="cancelOrders.jsp">Cancel Orders</a>
        <a href="deliveredOrders.jsp">Delivered Orders</a>
        <a href="../logout.jsp">Logout</a>
    </nav>
</body>
</html>
