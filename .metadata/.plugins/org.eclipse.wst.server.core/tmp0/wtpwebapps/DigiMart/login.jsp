<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        body {
            background: linear-gradient(135deg, #96e6a1 0%, #d4fc79 100%); /* Light green gradient */
            display: flex;
            min-height: 100vh;
        }
        .section {
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }
        .card-custom {
            border-radius: 15px;
            background: #f0f9ff; /* Light blue background */
            padding: 30px;
            box-shadow: 0 12px 30px rgba(0, 0, 0, 0.15); /* Soft shadow */
            transition: transform 0.3s ease;
            width: 100%; /* Ensure full width on small devices */
            max-width: 600px; /* Set maximum width for the card */
        }
        .card-custom:hover {
            transform: translateY(-5px); /* Subtle hover lift */
        }
        .card-custom h3 {
            font-weight: bold;
            color: #2c6fbb; /* Cool blue for headings */
        }
        .form-control {
            border-radius: 25px;
            height: 60px; /* Increased height for input fields */
            background-color: #e0f7fa; /* Light cyan background for inputs */
            border: none;
            box-shadow: inset 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .btn-custom {
            border-radius: 25px;
            padding: 12px 25px;
            background-color: #4caf50; /* Light green button */
            color: white;
        }
        .description-card {
            background: rgba(255, 255, 255, 0.8); /* Semi-transparent white */
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 12px 30px rgba(0, 0, 0, 0.15);
            color: #333;
        }
        .description-card h2 {
            font-size: 2rem;
            margin-bottom: 20px;
        }
        .card-footer a {
            color: #2c6fbb;
        }
        .message {
            color: #ff5722; /* Error message color */
            font-weight: bold;
            text-align: center;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row section">
        <!-- Left Side: Login Form -->
        <div class="col-md-6 d-flex align-items-center justify-content-center">
            <div class="card-custom">
                <h3 class="text-center">Login to Your Account</h3>
                <form action="login" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                    </div>
                    <button type="submit" class="btn btn-custom btn-block">Login</button>
                </form>
                <% 
                    String msg = request.getParameter("msg");
                    if ("notexist".equals(msg)) {
                %>
                <div class="message">Incorrect Username or Password</div>
                <% } else if ("invalid".equals(msg)) { %>
                <div class="message">Something Went Wrong! Try Again!</div>
                <% } %>
                <div class="card-footer text-center mt-3">
                    <a href="signup.jsp">Don't have an account? Sign up</a>
                </div>
                <div class="card-footer text-center mt-3">
                    <a href="forgotPassword.jsp">Forgot Password</a>
                </div>
            </div>
        </div>

        <!-- Right Side: Description Card for Login -->
        <div class="col-md-6 d-none d-md-flex align-items-center justify-content-center">
            <div class="description-card">
                <h2>Welcome Back!</h2>
                <p>Login to access your account and explore fresh farm produce. Let's continue your journey with us.</p>
            </div>
        </div>
    </div>
</div>




<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
