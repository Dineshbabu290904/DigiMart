/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-10-17 16:18:58 UTC
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

public final class addressPaymentForOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(6);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
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
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/addressPaymentForOrder-style.css\">\r\n");
      out.write("    <script src='https://kit.fontawesome.com/a076d05399.js'></script>\r\n");
      out.write("    <title>Checkout</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            background: linear-gradient(135deg, #96e6a1 0%, #d4fc79 100%);\r\n");
      out.write("            min-height: 100vh;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            font-family: Arial, sans-serif;\r\n");
      out.write("        }\r\n");
      out.write("        .alert {\r\n");
      out.write("            color: red;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("        .input-style {\r\n");
      out.write("            width: 90%;\r\n");
      out.write("            margin: 10px auto;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("        }\r\n");
      out.write("        .btn {\r\n");
      out.write("            padding: 10px 20px;\r\n");
      out.write("            background-color: #4CAF50;\r\n");
      out.write("            color: white;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("        }\r\n");
      out.write("        .btn:hover {\r\n");
      out.write("            background-color: #45a049;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <br>\r\n");
      out.write("    ");

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
    
      out.write("\r\n");
      out.write("                <h3 class=\"alert\">Your cart is empty!</h3>\r\n");
      out.write("    ");

            } else {
    
      out.write("\r\n");
      out.write("                <table>\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th scope=\"col\"><a href=\"myCart.jsp\"><i class='fas fa-arrow-circle-left'></i> Back</a></th>\r\n");
      out.write("                            <th scope=\"col\" style=\"background-color: yellow;\">Total: <i class=\"fa fa-inr\"></i> ");
      out.print( totalParam );
      out.write("</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th scope=\"col\">S.No</th>\r\n");
      out.write("                            <th scope=\"col\">Product Name</th>\r\n");
      out.write("                            <th scope=\"col\">Category</th>\r\n");
      out.write("                            <th scope=\"col\"><i class=\"fa fa-inr\"></i> Price</th>\r\n");
      out.write("                            <th scope=\"col\">Quantity</th>\r\n");
      out.write("                            <th scope=\"col\">Sub Total</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <tbody>\r\n");
      out.write("    ");

                int sNo = 1;
                while (rsCart.next()) {
                    String productName = rsCart.getString("name");
                    String category = rsCart.getString("category");
                    double price = rsCart.getBigDecimal("price_per_unit").doubleValue();
                    int quantity = rsCart.getInt("quantity");
                    double subTotal = price * quantity;
    
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>");
      out.print( sNo++ );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( productName );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( category );
      out.write("</td>\r\n");
      out.write("                            <td><i class=\"fa fa-inr\"></i> ");
      out.print( price );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( quantity );
      out.write("</td>\r\n");
      out.write("                            <td><i class=\"fa fa-inr\"></i> ");
      out.print( subTotal );
      out.write("</td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("    ");

                }
    
      out.write("\r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("    \r\n");
      out.write("                <hr style=\"width: 100%\">\r\n");
      out.write("\r\n");
      out.write("                <!-- Address Form -->\r\n");
      out.write("                <form action=\"AddressPaymentForOrderServlet\" method=\"post\">\r\n");
      out.write("                    <div class=\"left-div\">\r\n");
      out.write("                        <h3>Enter Full Name</h3>\r\n");
      out.write("                        <input class=\"input-style\" type=\"text\" name=\"full_name\" value=\"");
      out.print( hasDefaultAddress ? fullName : "" );
      out.write("\" required placeholder=\"Enter your Full Name\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"right-div\">\r\n");
      out.write("                        <h3>Enter Phone Number</h3>\r\n");
      out.write("                        <input class=\"input-style\" type=\"text\" name=\"phone_number\" value=\"");
      out.print( hasDefaultAddress ? phoneNumber : "" );
      out.write("\" required placeholder=\"Enter your phone number\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"left-div\">\r\n");
      out.write("                        <h3>Enter Address</h3>\r\n");
      out.write("                        <input class=\"input-style\" type=\"text\" name=\"street_address\" value=\"");
      out.print( hasDefaultAddress ? streetAddress : "" );
      out.write("\" required placeholder=\"Enter your address\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"right-div\">\r\n");
      out.write("                        <h3>Enter Apartment Number (optional)</h3>\r\n");
      out.write("                        <input class=\"input-style\" type=\"text\" name=\"apartment_number\" value=\"");
      out.print( hasDefaultAddress ? apartmentNumber : "" );
      out.write("\" placeholder=\"Enter your apartment number\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"left-div\">\r\n");
      out.write("                        <h3>Enter City</h3>\r\n");
      out.write("                        <input class=\"input-style\" type=\"text\" name=\"city\" value=\"");
      out.print( hasDefaultAddress ? city : "" );
      out.write("\" required placeholder=\"Enter your city\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"right-div\">\r\n");
      out.write("                        <h3>Enter State</h3>\r\n");
      out.write("                        <input class=\"input-style\" type=\"text\" name=\"state\" value=\"");
      out.print( hasDefaultAddress ? state : "" );
      out.write("\" required placeholder=\"Enter your state\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"left-div\">\r\n");
      out.write("                        <h3>Enter Postal Code</h3>\r\n");
      out.write("                        <input class=\"input-style\" type=\"text\" name=\"postal_code\" value=\"");
      out.print( hasDefaultAddress ? postalCode : "" );
      out.write("\" required placeholder=\"Enter your postal code\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"right-div\">\r\n");
      out.write("                        <h3>Enter Country</h3>\r\n");
      out.write("                        <input class=\"input-style\" type=\"text\" name=\"country\" value=\"");
      out.print( hasDefaultAddress ? country : "" );
      out.write("\" required placeholder=\"Enter your country\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <h3 style=\"color: red;\">*This address will also be updated in your profile</h3>\r\n");
      out.write("\r\n");
      out.write("                    <hr style=\"width: 100%\">\r\n");
      out.write("                    \r\n");
      out.write("                    <!-- Payment Options -->\r\n");
      out.write("                    <div class=\"left-div\">\r\n");
      out.write("                        <h3>Select Way of Payment</h3>\r\n");
      out.write("                        <select class=\"input-style\" name=\"payment_method\">\r\n");
      out.write("                            <option value=\"cod\">Cash on Delivery</option>\r\n");
      out.write("                            <option value=\"online\">Online Payment</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"right-div\">\r\n");
      out.write("                        <h3>Pay Online to: <strong>btechdays@pay.com</strong></h3>\r\n");
      out.write("                        <h3 style=\"color: red;\">*If you select online payment, enter your transaction ID here, otherwise leave it blank</h3>\r\n");
      out.write("                        <input class=\"input-style\" type=\"text\" name=\"transaction_id\" placeholder=\"Enter Transaction ID\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <hr style=\"width: 100%\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- Mobile Number -->\r\n");
      out.write("                    <div class=\"left-div\">\r\n");
      out.write("                        <h3>Enter your mobile number</h3>\r\n");
      out.write("                        <input class=\"input-style\" type=\"text\" name=\"mobile_number\" value=\"");
      out.print( phoneNumber );
      out.write("\" required placeholder=\"Enter your mobile number\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"right-div\">\r\n");
      out.write("                        <h3 style=\"color: red;\">*If you enter a wrong transaction ID, your order may be cancelled!</h3>\r\n");
      out.write("                        <h3 style=\"color: red;\">*Fill the form correctly</h3>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <br><br>\r\n");
      out.write("\r\n");
      out.write("                    <!-- Submit Button -->\r\n");
      out.write("                    <div style=\"text-align: center;\">\r\n");
      out.write("                        <button type=\"submit\" class=\"btn\">Place Order <i class='fas fa-arrow-right'></i></button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("                <br><br><br>\r\n");
      out.write("    ");

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
    
      out.write("\r\n");
      out.write("</body>\r\n");
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
