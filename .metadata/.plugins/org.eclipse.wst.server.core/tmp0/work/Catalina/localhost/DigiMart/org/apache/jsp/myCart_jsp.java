/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-10-18 03:44:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.digimart.project.ConnectionProvider;
import java.sql.*;
import java.util.Base64;

public final class myCart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1729186277053L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1729186404161L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(6);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(3);
    _jspx_imports_classes.add("java.util.Base64");
    _jspx_imports_classes.add("com.digimart.project.ConnectionProvider");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/home-style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css\">\r\n");
      out.write("    <script src='https://kit.fontawesome.com/a076d05399.js'></script>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            background: linear-gradient(135deg, #96e6a1 0%, #d4fc79 100%); /* Light green gradient */\r\n");
      out.write("            min-height: 100vh;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar {\r\n");
      out.write("            background: linear-gradient(135deg,  #d4fc79, #e3f2fd); /* Gradient navbar */\r\n");
      out.write("            padding: 10px; /* Padding around navbar */\r\n");
      out.write("            display: flex; /* Use flexbox for layout */\r\n");
      out.write("            flex-direction: column; /* Stack rows vertically */\r\n");
      out.write("            box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.5);\r\n");
      out.write("            margin-bottom: 10;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar .navbar-top {\r\n");
      out.write("            display: flex; /* Use flexbox for the first row */\r\n");
      out.write("            box-shadow: 4px 4px 4px rgba(0.15, 0.15, 0.15, 0.15);\r\n");
      out.write("            justify-content: space-between; /* Space between heading and username */\r\n");
      out.write("            align-items: center; /* Center items vertically */\r\n");
      out.write("            width: 100%; /* Full width */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar h2 {\r\n");
      out.write("            color: #2c6fbb; /* Cool blue for headings */\r\n");
      out.write("            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Shadow for depth */\r\n");
      out.write("            margin-bottom: 10; /* Remove default margin */\r\n");
      out.write("            margin-left: 10;\r\n");
      out.write("            padding: 10; /* Remove default padding */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar .user-info {\r\n");
      out.write("            color: #2c6fbb; /* Color for username */\r\n");
      out.write("            font-size: 20px; /* Font size for username */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar .navbar-links {\r\n");
      out.write("            display: flex; /* Flexbox for second row */\r\n");
      out.write("            flex-wrap: wrap; /* Allow wrapping if necessary */\r\n");
      out.write("            justify-content: space-between;\r\n");
      out.write("            width: 100%; /* Full width for links */\r\n");
      out.write("            margin-top: 5px; /* Space above links */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar a {\r\n");
      out.write("            color: #2c6fbb; /* Cool blue for links */\r\n");
      out.write("            text-shadow: 1px 1px 4px rgba(0, 0, 0, 0.5); /* Shadow for depth */\r\n");
      out.write("            margin: 5px 10px; /* Spacing between links */\r\n");
      out.write("            text-decoration: none; /* Remove underline */\r\n");
      out.write("            font-size: 18px; /* Larger font size */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar a:hover {\r\n");
      out.write("            text-decoration: underline; /* Underline on hover */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .search-container input[type=\"text\"] {\r\n");
      out.write("            padding: 8px; /* Padding inside input */\r\n");
      out.write("            border: 1px solid #ccc; /* Light gray border */\r\n");
      out.write("            border-radius: 4px; /* Rounded corners */\r\n");
      out.write("            margin-right: 5px; /* Space to the right of input */\r\n");
      out.write("            width: 200px; /* Width of search input */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .search-container button {\r\n");
      out.write("            padding: 8px 12px; /* Padding for button */\r\n");
      out.write("            background-color: #2c6fbb; /* Button background */\r\n");
      out.write("            color: white; /* Button text color */\r\n");
      out.write("            border: none; /* Remove border */\r\n");
      out.write("            border-radius: 4px; /* Rounded corners */\r\n");
      out.write("            cursor: pointer; /* Pointer on hover */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .search-container button:hover {\r\n");
      out.write("            background-color: #1e4e87; /* Darker blue on hover */\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <nav class=\"navbar\">\r\n");
      out.write("        <div class=\"navbar-top\">\r\n");
      out.write("            <h2>Online Shopping</h2>\r\n");
      out.write("            <div class=\"user-info\">\r\n");
      out.write("                ");
 String username = session.getAttribute("user") != null ? session.getAttribute("user").toString() : "Guest"; 
      out.write("\r\n");
      out.write("                <a href=\"\">");
 out.println(username); 
      out.write(" <i class='fas fa-user-alt'></i></a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"navbar-links\">\r\n");
      out.write("            <a href=\"home.jsp\">Home <i class=\"fa fa-institution\"></i></a>\r\n");
      out.write("            <a href=\"myCart.jsp\">My Cart <i class='fas fa-cart-arrow-down'></i></a>\r\n");
      out.write("            <a href=\"myOrders.jsp\">My Orders <i class='fab fa-elementor'></i></a>\r\n");
      out.write("            <a href=\"changeDetails.jsp\">Change Details <i class=\"fa fa-edit\"></i></a>\r\n");
      out.write("            <a href=\"messageUs.jsp\">Message Us <i class='fas fa-comment-alt'></i></a>\r\n");
      out.write("            <a href=\"about.jsp\">About <i class=\"fa fa-address-book\"></i></a>\r\n");
      out.write("            <a href=\"logout.jsp\">Logout <i class='fas fa-share-square'></i></a>\r\n");
      out.write("            <div class=\"search-container\">\r\n");
      out.write("            <form action=\"searchHome.jsp\" method=\"post\">\r\n");
      out.write("                <input type=\"text\" placeholder=\"Search\" name=\"Search\">\r\n");
      out.write("                <button type=\"submit\"><i class=\"fa fa-search\"></i></button>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>My Cart</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css\">\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            display: flex; /* Use flexbox */\r\n");
      out.write("            flex-direction: column; /* Stack children vertically */\r\n");
      out.write("            height: 100vh; /* Full viewport height */\r\n");
      out.write("            margin: 0; /* Remove default margin */\r\n");
      out.write("            background: linear-gradient(135deg, #96e6a1 0%, #d4fc79 100%); /* Light green gradient */\r\n");
      out.write("            min-height: 100vh;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h1 {\r\n");
      out.write("            font-size: 5rem; /* Responsive font size */\r\n");
      out.write("            color: #2c6fbb; /* Cool blue for headings */\r\n");
      out.write("            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Subtle shadow for depth */\r\n");
      out.write("            margin: auto; /* Center heading vertically */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .footer {\r\n");
      out.write("            background-color: #4caf50; /* Same green as navbar */\r\n");
      out.write("            color: white; /* White text */\r\n");
      out.write("            text-align: center; /* Center text */\r\n");
      out.write("            padding: 20px; /* Padding around footer */\r\n");
      out.write("            margin-top: auto; /* Push footer to the bottom */\r\n");
      out.write("            width: 100%; /* Full width */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Card Styles */\r\n");
      out.write("        .card-container {\r\n");
      out.write("            display: flex; /* Use flexbox for layout */\r\n");
      out.write("            flex-wrap: wrap; /* Allow wrapping of cards */\r\n");
      out.write("            justify-content: center; /* Center cards horizontally */\r\n");
      out.write("            padding: 20px; /* Padding around cards */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .card {\r\n");
      out.write("            background: linear-gradient(135deg,  #d4fc79, #e3f2fd);\r\n");
      out.write("            border-radius: 8px; /* Rounded corners */\r\n");
      out.write("            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Card shadow */\r\n");
      out.write("            margin: 15px; /* Margin between cards */\r\n");
      out.write("            padding: 20px; /* Padding inside cards */\r\n");
      out.write("            width: 300px; /* Fixed width for cards */\r\n");
      out.write("            text-align: center; /* Center text */\r\n");
      out.write("            transition: transform 0.2s; /* Animation for hover effect */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .card:hover {\r\n");
      out.write("            transform: translateY(-10px); /* Lift card on hover */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .card img {\r\n");
      out.write("            width: 100%; /* Make image responsive */\r\n");
      out.write("            height: 200px; /* Maintain aspect ratio */\r\n");
      out.write("            border-radius: 8px; /* Match card border radius */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .card h4 {\r\n");
      out.write("            color: #2c6fbb; /* Heading color */\r\n");
      out.write("            margin: 10px 0; /* Margin for spacing */\r\n");
      out.write("            font-weight: bold; /* or */\r\n");
      out.write("    		font-weight: 700;\r\n");
      out.write("            font-size: 2.0em;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .card p {\r\n");
      out.write("            color: #2c6fbb; /* Gray text for description */\r\n");
      out.write("            font-weight: bold; /* or */\r\n");
      out.write("    		font-weight: 700;\r\n");
      out.write("            font-size: 1.0em;\r\n");
      out.write("            \r\n");
      out.write("        }\r\n");
      out.write("        .alert {\r\n");
      out.write("            text-align: center; /* Center alert text */\r\n");
      out.write("            margin: 10px 0; /* Margin for spacing */\r\n");
      out.write("            color: #4caf50; /* Green text for success */\r\n");
      out.write("            font-size: 2.0em; /* Font size for alerts */\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h1>My Cart <i class='fas fa-cart-arrow-down'></i></h1>\r\n");
      out.write("        ");

        String msg = request.getParameter("msg");
        if (msg != null) {
            if ("increase".equals(msg)) {
        
      out.write("\r\n");
      out.write("        <h3 class=\"alert alert-success\">Product Quantity successfully Increased!</h3>\r\n");
      out.write("        ");

            } else if ("decrease".equals(msg)) {
        
      out.write("\r\n");
      out.write("        <h3 class=\"alert alert-success\">Product Quantity successfully decreased!</h3>\r\n");
      out.write("        ");

            } else if ("removed".equals(msg)) {
        
      out.write("\r\n");
      out.write("        <h3 class=\"alert alert-danger\">Product successfully Removed!</h3>\r\n");
      out.write("        ");

            } else if ("not_found".equals(msg)) {
        
      out.write("\r\n");
      out.write("        <h3 class=\"alert alert-danger\">Product not found in your cart!</h3>\r\n");
      out.write("        ");

            } else if ("error".equals(msg)) {
        
      out.write("\r\n");
      out.write("        <h3 class=\"alert alert-danger\">Something went wrong! Try Again!</h3>\r\n");
      out.write("        ");

            }
        }
        
      out.write("\r\n");
      out.write("        ");

            double totalAmount = 0.0;
            String userId = session.getAttribute("user_id").toString(); 

            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement(
                    "SELECT p.product_id, p.name, p.description, p.category, p.available_qty, p.unit, c.quantity, p.price_per_unit, c.price, p.image " +
                    "FROM cart c JOIN products p ON c.product_id = p.product_id " +
                    "WHERE c.user_id = ? AND c.status = 'active'"
                );
                ps.setString(1, userId);
                ResultSet rs = ps.executeQuery();

                if (!rs.isBeforeFirst()) {
        
      out.write("\r\n");
      out.write("                    <h3 class=\"alert alert-success\">Your cart is empty!</h3>\r\n");
      out.write("        ");

                } else {
                    // Display items in card format
        
      out.write("\r\n");
      out.write("                    <h3 class=\"alert alert-danger\">Items in your cart:</h3>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("        ");

                    while (rs.next()) {
                        int productId = rs.getInt("product_id");
                        String productName = rs.getString("name");
                        String category = rs.getString("category");
                        double price = rs.getBigDecimal("price_per_unit").doubleValue();
                        int quantity = rs.getInt("quantity");
                        double subTotal = price * quantity;
                        double availableQty = rs.getBigDecimal("available_qty").doubleValue();
                        totalAmount += subTotal;
        
      out.write("\r\n");
      out.write("                        <div class=\"col-md-4\">\r\n");
      out.write("                            <div class=\"card\">\r\n");
      out.write("                                <img src=\"data:image/jpg;base64,");
      out.print( Base64.getEncoder().encodeToString(rs.getBytes("image")) );
      out.write("\" alt=\"Product Image\">\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <h5 class=\"card-title\">");
      out.print( productName );
      out.write("</h5>\r\n");
      out.write("                                    <p class=\"card-text\">Category: ");
      out.print( category );
      out.write("</p>\r\n");
      out.write("                                    <p class=\"card-text\">Price: <i class=\"fa fa-inr\"></i> ");
      out.print( price );
      out.write("</p>\r\n");
      out.write("                                    \r\n");
      out.write("                                    <form action=\"UpdateCartServlet\" method=\"post\" style=\"display:inline;\">\r\n");
      out.write("                                        <input type=\"hidden\" name=\"product_id\" value=\"");
      out.print( productId );
      out.write("\">\r\n");
      out.write("                                        <p class=\"card-text\">Quantity:</p>\r\n");
      out.write("                                        <button type=\"submit\" name=\"action\" value=\"increase\" class=\"btn btn-success btn-sm\"><i class='fas fa-plus-circle'></i></button>\r\n");
      out.write("                                         ");
      out.print( quantity );
      out.write("\r\n");
      out.write("                                        <button type=\"submit\" name=\"action\" value=\"decrease\" class=\"btn btn-warning btn-sm\"><i class='fas fa-minus-circle'></i></button>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                    \r\n");
      out.write("                                    <p class=\"card-text\">Available Quantity: ");
      out.print( availableQty );
      out.write("</p>\r\n");
      out.write("                                    <p class=\"card-text\">Sub Total: <i class=\"fa fa-inr\"></i> ");
      out.print( subTotal );
      out.write("</p>\r\n");
      out.write("                                    \r\n");
      out.write("                                    <form action=\"RemoveFromCartServlet\" method=\"post\" style=\"display:inline;\">\r\n");
      out.write("                                        <input type=\"hidden\" name=\"product_id\" value=\"");
      out.print( productId );
      out.write("\">\r\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-danger btn-sm\">Remove <i class='fas fa-trash-alt'></i></button>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("        ");

                    }
        
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <h3 style=\"color: yellow;\">Total: <i class=\"fa fa-inr\"></i> ");
      out.print( totalAmount );
      out.write("</h3>\r\n");
      out.write("                    <div style=\"text-align: center;\">\r\n");
      out.write("                   ");
session.setAttribute("total", totalAmount); 
      out.write("\r\n");
      out.write("                        <a href=\"addressPaymentForOrder.jsp\">Proceed to Order</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("        ");

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("<head>\r\n");
      out.write("	<style>\r\n");
      out.write("	.footer {\r\n");
      out.write("            background: linear-gradient(135deg,  #d4fc79, #e3f2fd); /* Gradient navbar */\r\n");
      out.write("            padding: 10px; /* Padding around navbar */\r\n");
      out.write("            box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.5);\r\n");
      out.write("            margin-bottom: 10; /* Subtle shadow for depth */\r\n");
      out.write("            text-align: center; /* Center text */\r\n");
      out.write("            padding: 1px; /* Padding around footer */\r\n");
      out.write("            margin-top: auto; /* Push footer to the bottom */\r\n");
      out.write("            width: 100%; /* Full width */\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"footer\">\r\n");
      out.write("        <p>&copy; 2024 DigiMart. All rights reserved.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
