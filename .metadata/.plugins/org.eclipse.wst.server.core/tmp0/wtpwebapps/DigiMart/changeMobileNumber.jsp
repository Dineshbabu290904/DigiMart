<%@include file="changeDetailsHeader.jsp"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.digimart.project.ConnectionProvider" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/changeDetails.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <title>Change Mobile Number</title>
</head>
<body>
    <%
        // Get user ID from the session
        Integer userId = (Integer) session.getAttribute("user_id");
        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String currentMobileNumber = null;

        // Retrieve the user's current mobile number from the database
        try (Connection con = ConnectionProvider.getCon()) {
            String query = "SELECT phone FROM users WHERE user_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                currentMobileNumber = rs.getString("phone");
            } else {
                out.println("<h3>Could not retrieve your mobile number. Please try again later.</h3>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h3>An error occurred while retrieving your mobile number.</h3>");
        }
    %>

<% 
    String message = request.getParameter("msg");
    if ("success".equals(message)) { 
%>
    <h3 class="alert alert-success">Your Mobile Number has been successfully changed!</h3>
<% 
    } else if ("wrongPassword".equals(message)) { 
%>
    <h3 class="alert alert-danger">Your password is incorrect!</h3>
<% 
    } else if ("error".equals(message)) { 
%>
    <h3 class="alert alert-danger">Something went wrong! Please try again.</h3>
<% 
    } 
%>

    <!-- Form for Mobile Number Update -->
    <form action="ChangeMobileNumberServlet" method="post">
        <div class="form-group">
            <center><label for="mobileNumber"><h3>Your Current Mobile Number</h3></label></center>
            <hr>
            <input class="input-style" type="text" name="mobileNumber" id="mobileNumber" class="form-control" value="<%= currentMobileNumber != null ? currentMobileNumber : "" %>" required>
        </div>
        <hr>
        <div class="form-group">
            <center><label for="password"><h3>Enter Password (For Security)</h3></label></center>
            <br>
            <input class="input-style" type="password" name="password" id="password" class="form-control" required>
        </div>
        <hr>
        <div class="form-group">
        	<center>
            <button type="submit" class="btn btn-primary">
                <i class="far fa-arrow-alt-circle-right"></i> Submit
            </button>
            </center>
        </div>
    </form>
    <br><br><br>
</body>
</html>