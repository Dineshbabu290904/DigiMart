<%@include file="adminHeader.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Welcome</title>
    <style>
        body {
            display: flex; /* Use flexbox */
            flex-direction: column; /* Stack children vertically */
            height: 100vh; /* Full viewport height */
            margin: 0; /* Remove default margin */
            background: linear-gradient(135deg, #d4fc79 0%, #96e6a1 100%); /* Light green gradient */
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
    </style>
</head>
<body>
    <h1>Welcome Admin!</h1>


    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
<%@ include file="../footer.jsp" %>
</html>
