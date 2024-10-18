<%@ include file="changeDetailsHeader.jsp" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.digimart.project.ConnectionProvider" %>
<html>
<head>
    <link rel="stylesheet" href="css/changeDetails.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <title>Edit Address</title>
</head>
<body>

<%

    Integer userId = (Integer) session.getAttribute("user_id");

    // Check if user ID is null (not logged in)
    if (userId == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Fetch address details from the database
    String query = "SELECT address_id, full_name, phone_number, street_address, apartment_number, city, state, postal_code, country, address_type, is_default FROM address WHERE user_id = ?";
    try (Connection con = ConnectionProvider.getCon();
         PreparedStatement stmt = con.prepareStatement(query)) {
        
        stmt.setInt(1, userId); // Set the user ID in the query
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Fetch address details
            int addressId = rs.getInt("address_id");
            String fullName = rs.getString("full_name");
            String phoneNumber = rs.getString("phone_number");
            String streetAddress = rs.getString("street_address");
            String apartmentNumber = rs.getString("apartment_number");
            String city = rs.getString("city");
            String state = rs.getString("state");
            String postalCode = rs.getString("postal_code");
            String country = rs.getString("country");
            String addressType = rs.getString("address_type");
            boolean isDefault = rs.getBoolean("is_default");
%>
            <h3>Address Details</h3>
            <hr>
            <form action="UpdateAddressServlet" method="POST">
                <input type="hidden" name="address_id" value="<%= addressId %>">
                <h3>Full Name: <input type="text" name="full_name" value="<%= fullName %>" required /></h3>
                <hr>
                <h3>Phone Number: <input type="text" name="phone_number" value="<%= phoneNumber %>" required /></h3>
                <hr>
                <h3>Street Address: <input type="text" name="street_address" value="<%= streetAddress %>" required /></h3>
                <hr>
                <h3>Apartment Number: <input type="text" name="apartment_number" value="<%= apartmentNumber %>" /></h3>
                <hr>
                <h3>City: <input type="text" name="city" value="<%= city %>" required /></h3>
                <hr>
                <h3>State: <input type="text" name="state" value="<%= state %>" required /></h3>
                <hr>
                <h3>Postal Code: <input type="text" name="postal_code" value="<%= postalCode %>" required /></h3>
                <hr>
                <h3>Country: <input type="text" name="country" value="<%= country %>" required /></h3>
                <hr>
                <h3>Address Type: 
                    <select name="address_type">
                        <option value="shipping" <%= addressType.equals("shipping") ? "selected" : "" %>>Shipping</option>
                        <option value="billing" <%= addressType.equals("billing") ? "selected" : "" %>>Billing</option>
                    </select>
                </h3>
                <hr>
                <h3>Default Address: 
                    <input type="checkbox" name="is_default" <%= isDefault ? "checked" : "" %> /> Yes
                </h3>
                <hr>
                <input type="submit" value="Update Address" />
            </form>
<%
        } else {
%>
            <h3>No address found for this user.</h3>
<%
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("<h3>Error fetching address details.</h3>");
    }
%>

<br><br><br>
<i class='far fa-arrow-alt-circle-right'></i>

</body>
<%@ include file="footer.jsp" %>
</html>
