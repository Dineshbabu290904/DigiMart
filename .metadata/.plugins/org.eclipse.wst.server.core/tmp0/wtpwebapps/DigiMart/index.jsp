<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Digimart - Direct Market Access for Farmers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles.css"> <!-- Link to your CSS file -->
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg" style="background-color: #e3f2fd;">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Digimart</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#about">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#features">Features</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#services">Services</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#contact">Contact</a>
                    </li>
                    <li class="nav-item">
                        <button class="btn btn-outline-primary" onclick="window.location.href='login.jsp'">Login</button>
                    </li>
                    <li class="nav-item">
                        <button class="btn btn-outline-success ms-2" onclick="window.location.href='signup.jsp'">Create Account</button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
    <!-- Header Section -->
    <header class="bg-success bg-gradient text-white text-center py-5">
        <div class="container">
            <h1 class="display-4">Welcome to Digimart</h1>
            <p class="lead">Your one-stop solution for direct market access to agricultural produce</p>
            <button class="btn btn-light btn-lg text-success" onclick="window.location.href='signup.jsp'">Join Us</button>
			<a href="#about" class="btn btn-light btn-lg">Learn More</a>
			<button class="btn btn-light btn-lg text-primary" onclick="window.location.href='login.jsp'">Already Joined</button>
        </div>
    </header>

    <!-- About Section -->
    <section id="about" class="py-5">
        <div class="container">
            <h2 class="text-center">About Digimart</h2>
            <p>Digimart is a platform designed to connect farmers directly with consumers and retailers, eliminating the need for middlemen. With AgroMart, farmers can list their produce, negotiate prices, and manage transactions seamlessly.</p>
        </div>
    </section>

    <!-- Features Section -->
    <section id="features" class="bg-light py-5">
        <div class="container">
            <h2 class="text-center">Key Features</h2>
            <ul class="list-group">
                <li class="list-group-item">Direct access to consumers and retailers</li>
                <li class="list-group-item">Easy produce listing and price negotiation</li>
                <li class="list-group-item">Secure payment and transaction management</li>
                <li class="list-group-item">Real-time price prediction for crops</li>
                <li class="list-group-item">Logistics and delivery support for farmers</li>
            </ul>
        </div>
    </section>

    <!-- Services Section -->
    <section id="services" class="py-5">
        <div class="container">
            <h2 class="text-center">Our Services</h2>
            <p>Digimart offers a variety of services to help farmers manage their sales and logistics:</p>
            <ul class="list-group">
                <li class="list-group-item">Produce listing and management</li>
                <li class="list-group-item">Logistics coordination</li>
                <li class="list-group-item">Price prediction for better decision-making</li>
                <li class="list-group-item">Secure and fast transactions</li>
            </ul>
        </div>
    </section>

    <!-- Contact Section -->
    <section id="contact" class="bg-light py-5">
        <div class="container">
            <h2 class="text-center">Contact Us</h2>
            <p>If you have any questions or need support, feel free to reach out to us.</p>
            <form action="contact.html" method="POST">
                <div class="mb-3">
                    <label for="name" class="form-label">Name:</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="mb-3">
                    <label for="message" class="form-label">Message:</label>
                    <textarea class="form-control" id="message" name="message" rows="5" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Send Message</button>
            </form>
        </div>
    </section>

    <!-- Footer Section -->
    <footer class="text-center py-4">
        <p>&copy; 2024 AgroMart. All rights reserved.</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
