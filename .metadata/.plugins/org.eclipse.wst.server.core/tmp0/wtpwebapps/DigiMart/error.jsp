<%@page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Error</title>
    <style>
        body {
            background: linear-gradient(135deg, #96e6a1 0%, #d4fc79 100%); /* Light green gradient */
            display: flex;
            min-height: 100vh;
            font-family: Arial, sans-serif; /* Font style */
            margin: 0; /* Remove default margin */
            padding: 0; /* Remove default padding */
            height: 100vh; /* Full height */
            display: flex; /* Flexbox for centering */
            flex-direction: column; /* Column layout */
            justify-content: center; /* Center vertically */
            align-items: center; /* Center horizontally */
            color: white; /* White text */
        }

        h1 {
            text-align: center; /* Center text */
            margin: 10px 0; /* Margin for spacing */
        }

        a {
            color: white; /* White link */
            text-decoration: none; /* Remove underline */
            padding: 10px 20px; /* Padding for link */
            background-color: #28a745; /* Green background */
            border-radius: 5px; /* Rounded corners */
            transition: background-color 0.3s; /* Transition effect */
        }

        a:hover {
            background-color: #218838; /* Darker green on hover */
        }
    </style>
</head>
<body>
    <h1>Something Went Wrong!</h1>
    <h1>Please log in and try again!</h1>
    <h1><a href="login.jsp">Go to Login</a></h1>
</body>
</html>
