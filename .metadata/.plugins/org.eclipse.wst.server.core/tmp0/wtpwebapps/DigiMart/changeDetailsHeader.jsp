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
            background: linear-gradient(135deg, #d4fc79, #e3f2fd); /* Gradient navbar */
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
            margin-bottom: 10;
            margin-left: 10;
            padding: 10;
        }

        .navbar .user-info {
            color: #2c6fbb; /* Color for username */
            font-size: 20px; /* Font size for username */
        }

        .navbar .navbar-links {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            width: 100%;
            margin-top: 5px;
        }

        .navbar a {
            color: #2c6fbb; /* Cool blue for links */
            text-shadow: 1px 1px 4px rgba(0, 0, 0, 0.5); /* Shadow for depth */
            margin: 5px 10px;
            text-decoration: none;
            font-size: 18px;
        }

        .navbar a:hover {
            text-decoration: underline;
        }

        .search-container input[type="text"] {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-right: 5px;
            width: 200px;
        }

        .search-container button {
            padding: 8px 12px;
            background-color: #2c6fbb;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .search-container button:hover {
            background-color: #1e4e87;
        }
    </style>
</head>
<body>
    <nav class="navbar">
        <div class="navbar-top">
            <h2>Change Details <i class="fa fa-edit"></i></h2>
            <div class="user-info">
                <% String user = session.getAttribute("user") != null ? session.getAttribute("user").toString() : "Guest"; %>
                <a href="changeDetails.jsp">Your Profile (<% out.println(user); %>) <i class="fas fa-user-alt"></i></a>
            </div>
        </div>
        <div class="navbar-links">
            <a href="home.jsp"><i class="fas fa-arrow-circle-left"></i> Back</a>
            <a href="changePassword.jsp">Change Password <i class="fas fa-key"></i></a>
            <a href="addChangeAddress.jsp">Add or Change Address <i class="fas fa-map-marker-alt"></i></a>
            <a href="changeSecurityQuestion.jsp">Change Security Question <i class="fa fa-repeat"></i></a>
            <a href="changeMobileNumber.jsp">Change Mobile Number <i class="fas fa-phone"></i></a>
        </div>
    </nav>
</body>
</html>
