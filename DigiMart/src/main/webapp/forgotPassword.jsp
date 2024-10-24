<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
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
        <!-- Left Side: Forgot Password Form -->
        <div class="col-md-6 d-flex align-items-center justify-content-center">
            <div class="card-custom">
                <h3 class="text-center">Reset Your Password</h3>
                <form action="ForgotPassword" method="post">
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" placeholder="Enter Username" required>
                    </div>
                    <div class="form-group">
                        <input type="email" name="email" class="form-control" placeholder="Enter Email" required>
                    </div>
                    <div class="form-group">
                        <input type="number" name="phone" class="form-control" placeholder="Enter Mobile Number" required>
                    </div>
                    <div class="form-group">
                        <select name="securityQuestion" class="form-control" required>
                            <option value="What was your first car?">What was your first car?</option>
                            <option value="What is the name of your first pet?">What is the name of your first pet?</option>
                            <option value="What elementary school did you attend?">What elementary school did you attend?</option>
                            <option value="What is the name of the town where you were born?">What is the name of the town where you were born?</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="text" name="answer" class="form-control" placeholder="Enter Answer" required>
                    </div>
                    <div class="form-group">
                        <input type="password" name="newPassword" class="form-control" placeholder="Enter New Password" required>
                    </div>
                    <button type="submit" class="btn btn-custom btn-block">Save</button>
                </form>
                <% 
                    String msg = request.getParameter("msg");
                    if ("done".equals(msg)) {
                %>
                <div class="message">Password Changed Successfully!</div>
                <% } else if ("notdone".equals(msg)) { %>
                <div class="message">Something Went Wrong! Try Again!</div>
                <% } %>
                <div class="card-footer text-center mt-3">
                    <a href="login.jsp">Go to Login</a>
                </div>
            </div>
        </div>

        <!-- Right Side: Description Card for Forgot Password -->
        <div class="col-md-6 d-none d-md-flex align-items-center justify-content-center">
            <div class="description-card">
                <h2>Need Help?</h2>
                <p>If you've forgotten your password, please provide your username, email, and mobile number to reset your password.</p>
                <p>Your security question will help us verify your identity.</p>
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
