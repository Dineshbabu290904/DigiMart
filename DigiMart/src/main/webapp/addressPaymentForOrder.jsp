<%@ page import="com.digimart.project.ConnectionProvider" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/addressPaymentForOrder-style.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <title>Checkout</title>
    <style>
        body {
            background: linear-gradient(135deg, #96e6a1 0%, #d4fc79 100%);
            min-height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .alert {
            color: red;
            font-weight: bold;
        }
        .input-style {
            width: 90%;
            margin: 10px auto;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .btn {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <br>
    <%
        Integer userId = (Integer) session.getAttribute("user_id"); 

        if (userId == null) {
            response.sendRedirect("login.jsp"); 
            return;
        }

        double totalParam = (double) session.getAttribute("total");

        // Initialize address fields
        String fullName = "", phoneNumber = "", streetAddress = "", apartmentNumber = "", city = "", state = "", postalCode = "", country = "";
        boolean hasDefaultAddress = false;

        Connection con = null;
        PreparedStatement psAddress = null;
        
        PreparedStatement psCart = null;
        ResultSet rsAddress = null;
        ResultSet rsPhone = null;
        ResultSet rsCart = null;

        try {
            con = ConnectionProvider.getCon();

            // Fetch user's default address
            psAddress = con.prepareStatement(
                "SELECT full_name, phone_number, street_address, apartment_number, city, state, postal_code, country " +
                "FROM address WHERE user_id = ? AND is_default = TRUE LIMIT 1"
            );
            psAddress.setInt(1, userId);
            rsAddress = psAddress.executeQuery();

            if (rsAddress.next()) {
                fullName = rsAddress.getString("full_name");
                phoneNumber = rsAddress.getString("phone_number");
                streetAddress = rsAddress.getString("street_address");
                apartmentNumber = rsAddress.getString("apartment_number");
                city = rsAddress.getString("city");
                state = rsAddress.getString("state");
                postalCode = rsAddress.getString("postal_code");
                country = rsAddress.getString("country");
                hasDefaultAddress = true; // Default address found
            }

            

            // Fetch cart items
            psCart = con.prepareStatement(
                "SELECT p.product_id, p.name, p.category, p.price_per_unit, c.quantity " +
                "FROM cart c JOIN products p ON c.product_id = p.product_id " +
                "WHERE c.user_id = ? AND c.status = 'active'"
            );
            psCart.setInt(1, userId);
            rsCart = psCart.executeQuery();

            if (!rsCart.isBeforeFirst()) {
    %>
                <h3 class="alert">Your cart is empty!</h3>
    <%
            } else {
    %>
                <table>
                    <thead>
                        <tr>
                            <th scope="col"><a href="myCart.jsp"><i class='fas fa-arrow-circle-left'></i> Back</a></th>
                            <th scope="col" style="background-color: yellow;">Total: <i class="fa fa-inr"></i> <%= totalParam %></th>
                        </tr>
                    </thead>
                    <thead>
                        <tr>
                            <th scope="col">S.No</th>
                            <th scope="col">Product Name</th>
                            <th scope="col">Category</th>
                            <th scope="col"><i class="fa fa-inr"></i> Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Sub Total</th>
                        </tr>
                    </thead>
                    <tbody>
    <%
                int sNo = 1;
                while (rsCart.next()) {
                    String productName = rsCart.getString("name");
                    String category = rsCart.getString("category");
                    double price = rsCart.getBigDecimal("price_per_unit").doubleValue();
                    int quantity = rsCart.getInt("quantity");
                    double subTotal = price * quantity;
    %>
                        <tr>
                            <td><%= sNo++ %></td>
                            <td><%= productName %></td>
                            <td><%= category %></td>
                            <td><i class="fa fa-inr"></i> <%= price %></td>
                            <td><%= quantity %></td>
                            <td><i class="fa fa-inr"></i> <%= subTotal %></td>
                        </tr>
    <%
                }
    %>
                    </tbody>
                </table>
    
                <hr style="width: 100%">

                <!-- Address Form -->
                <form action="AddressPaymentForOrderServlet" method="post">
                    <div class="left-div">
                        <h3>Enter Full Name</h3>
                        <input class="input-style" type="text" name="full_name" value="<%= hasDefaultAddress ? fullName : "" %>" required placeholder="Enter your Full Name">
                    </div>

                    <div class="right-div">
                        <h3>Enter Phone Number</h3>
                        <input class="input-style" type="text" name="phone_number" value="<%= hasDefaultAddress ? phoneNumber : "" %>" required placeholder="Enter your phone number">
                    </div>

                    <div class="left-div">
                        <h3>Enter Address</h3>
                        <input class="input-style" type="text" name="street_address" value="<%= hasDefaultAddress ? streetAddress : "" %>" required placeholder="Enter your address">
                    </div>

                    <div class="right-div">
                        <h3>Enter Apartment Number (optional)</h3>
                        <input class="input-style" type="text" name="apartment_number" value="<%= hasDefaultAddress ? apartmentNumber : "" %>" placeholder="Enter your apartment number">
                    </div>

                    <div class="left-div">
                        <h3>Enter City</h3>
                        <input class="input-style" type="text" name="city" value="<%= hasDefaultAddress ? city : "" %>" required placeholder="Enter your city">
                    </div>

                    <div class="right-div">
                        <h3>Enter State</h3>
                        <input class="input-style" type="text" name="state" value="<%= hasDefaultAddress ? state : "" %>" required placeholder="Enter your state">
                    </div>

                    <div class="left-div">
                        <h3>Enter Postal Code</h3>
                        <input class="input-style" type="text" name="postal_code" value="<%= hasDefaultAddress ? postalCode : "" %>" required placeholder="Enter your postal code">
                    </div>

                    <div class="right-div">
                        <h3>Enter Country</h3>
                        <input class="input-style" type="text" name="country" value="<%= hasDefaultAddress ? country : "" %>" required placeholder="Enter your country">
                    </div>

                    <h3 style="color: red;">*This address will also be updated in your profile</h3>

                    <hr style="width: 100%">
                    
                    <!-- Payment Options -->
                    <div class="left-div">
                        <h3>Select Way of Payment</h3>
                        <select class="input-style" name="payment_method">
                            <option value="cod">Cash on Delivery</option>
                            <option value="online">Online Payment</option>
                        </select>
                    </div>

                    <div class="right-div">
                        <h3>Pay Online to: <strong>btechdays@pay.com</strong></h3>
                        <h3 style="color: red;">*If you select online payment, enter your transaction ID here, otherwise leave it blank</h3>
                        <input class="input-style" type="text" name="transaction_id" placeholder="Enter Transaction ID">
                    </div>

                    <hr style="width: 100%">

                    <!-- Mobile Number -->
                    <div class="left-div">
                        <h3>Enter your mobile number</h3>
                        <input class="input-style" type="text" name="mobile_number" value="<%= phoneNumber %>" required placeholder="Enter your mobile number">
                    </div>

                    <div class="right-div">
                        <h3 style="color: red;">*If you enter a wrong transaction ID, your order may be cancelled!</h3>
                        <h3 style="color: red;">*Fill the form correctly</h3>
                    </div>

                    <br><br>

                    <!-- Submit Button -->
                    <div style="text-align: center;">
                        <button type="submit" class="btn">Place Order <i class='fas fa-arrow-right'></i></button>
                    </div>
                </form>
                <br><br><br>
    <%
            }
        } catch (SQLException e) {
            out.println("<h3 class='alert'>An error occurred while processing your request. Please try again later.</h3>");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rsCart != null) rsCart.close();
                if (rsPhone != null) rsPhone.close();
                if (rsAddress != null) rsAddress.close();
                if (psCart != null) psCart.close();
                
                if (psAddress != null) psAddress.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    %>
</body>
</html>
