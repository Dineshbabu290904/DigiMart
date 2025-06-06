<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/home-style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <style>
        body {
            background: linear-gradient(135deg, #96e6a1 0%, #d4fc79 100%); /* Light green gradient */
            min-height: 100vh;
        }

        .navbar {
            background: linear-gradient(135deg,  #d4fc79, #e3f2fd); /* Gradient navbar */
            padding: 10px; /* Padding around navbar */
            display: flex; /* Use flexbox for layout */
            flex-direction: column; /* Stack rows vertically */
            box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.5);
            margin-bottom: 10;
        }

        .navbar .navbar-top {
            display: flex; /* Use flexbox for the first row */
            box-shadow: 4px 4px 4px rgba(0.15, 0.15, 0.15, 0.15);
            justify-content: space-between; /* Space between heading and username */
            align-items: center; /* Center items vertically */
            width: 100%; /* Full width */
        }

        .navbar h2 {
            color: #2c6fbb; /* Cool blue for headings */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Shadow for depth */
            margin-bottom: 10; /* Remove default margin */
            margin-left: 10;
            padding: 10; /* Remove default padding */
        }

        .navbar .user-info {
            color: #2c6fbb; /* Color for username */
            font-size: 20px; /* Font size for username */
        }

        .navbar .navbar-links {
            display: flex; /* Flexbox for second row */
            flex-wrap: wrap; /* Allow wrapping if necessary */
            justify-content: space-between;
            width: 100%; /* Full width for links */
            margin-top: 5px; /* Space above links */
        }

        .navbar a {
            color: #2c6fbb; /* Cool blue for links */
            text-shadow: 1px 1px 4px rgba(0, 0, 0, 0.5); /* Shadow for depth */
            margin: 5px 10px; /* Spacing between links */
            text-decoration: none; /* Remove underline */
            font-size: 18px; /* Larger font size */
        }

        .navbar a:hover {
            text-decoration: underline; /* Underline on hover */
        }

        .search-container input[type="text"] {
            padding: 8px; /* Padding inside input */
            border: 1px solid #ccc; /* Light gray border */
            border-radius: 4px; /* Rounded corners */
            margin-right: 5px; /* Space to the right of input */
            width: 200px; /* Width of search input */
        }

        .search-container button {
            padding: 8px 12px; /* Padding for button */
            background-color: #2c6fbb; /* Button background */
            color: white; /* Button text color */
            border: none; /* Remove border */
            border-radius: 4px; /* Rounded corners */
            cursor: pointer; /* Pointer on hover */
        }

        .search-container button:hover {
            background-color: #1e4e87; /* Darker blue on hover */
        }
    </style>
</head>
<body>
    <nav class="navbar">
        <div class="navbar-top">
            <h2>Online Shopping</h2>
            <div class="user-info">
                <% String username = session.getAttribute("user") != null ? session.getAttribute("user").toString() : "Guest"; %>
                <a href=""><% out.println(username); %> <i class='fas fa-user-alt'></i></a>
            </div>
        </div>
        <div class="navbar-links">
            <a href="home.jsp">Home <i class="fa fa-institution"></i></a>
            <a href="myCart.jsp">My Cart <i class='fas fa-cart-arrow-down'></i></a>
            <a href="myOrders.jsp">My Orders <i class='fab fa-elementor'></i></a>
            <a href="changeDetails.jsp">Change Details <i class="fa fa-edit"></i></a>
            <a href="messageUs.jsp">Message Us <i class='fas fa-comment-alt'></i></a>
            <a href="about.jsp">About <i class="fa fa-address-book"></i></a>
            <a href="logout.jsp">Logout <i class='fas fa-share-square'></i></a>
            <div class="search-container">
            <form action="searchHome.jsp" method="post">
                <input type="text" placeholder="Search" name="Search">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
        </div>
        </div>
    </nav>
</body>
</html>
