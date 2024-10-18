<%@include file="header.jsp"%>
<html>
<head>
    <link rel="stylesheet" href="css/messageUs.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <title>Message Us</title>
</head>
<body>
    <div style="color: white; text-align: center; font-size: 30px;">Message Us <i class='fas fa-comment-alt'></i></div>

    <!-- Display success or error messages -->
    <%
        String msg = request.getParameter("msg");
        if ("valid".equals(msg)) {
    %>
        <h3 style="text-align:center; color:yellow;">Message successfully sent. Our team will contact you soon!</h3>
    <%
        } else if ("invalid".equals(msg)) {
    %>
        <h3 style="text-align:center; color:red;">Something went wrong! Try again!</h3>
    <%
        }
    %>

    <!-- Form to submit a message -->
    <form action="MessageUsServlet" method="post">
        <div class="form-group">
            <input class="input-style" name="subject" type="text" placeholder="Subject" required>
        </div>
        <hr>
        <div class="form-group">
            <textarea class="input-style" name="message" placeholder="Enter Your Message" required></textarea>
        </div>
        <hr>
        <button class="button" type="submit">Send <i class="far fa-arrow-alt-circle-right"></i></button>
    </form>

    <br><br><br>
</body>
<%@include file="footer.jsp"%>
</html>
