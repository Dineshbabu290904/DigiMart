/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-10-24 12:20:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.digimart.project.ConnectionProvider;
import java.sql.*;

public final class addNewProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1729186277053L));
    _jspx_dependants.put("/admin/adminHeader.jsp", Long.valueOf(1729168602355L));
  }

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
      			"../error.jsp", true, 8192, true);
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
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("    <script src='https://kit.fontawesome.com/a076d05399.js'></script>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            background: linear-gradient(135deg, #d4fc79 0%, #96e6a1 100%); /* Light green gradient */\r\n");
      out.write("        }\r\n");
      out.write("        .navbar {\r\n");
      out.write("            background: linear-gradient(135deg, #4caf50, #b2ebf2, #ffccbc); /* Green to Light Blue to Light Pink */\r\n");
      out.write("            padding: 10px; /* Padding around navbar */\r\n");
      out.write("        }\r\n");
      out.write("        .navbar a {\r\n");
      out.write("            color: #2c6fbb; /* Cool blue for headings */\r\n");
      out.write("            text-shadow: 1px 1px 4px rgba(0, 0, 0, 0.5); /* Subtle shadow for depth */\r\n");
      out.write("            margin: 0 15px; /* Spacing between links */\r\n");
      out.write("            text-decoration: none; /* Remove underline */\r\n");
      out.write("            font-size: 18px; /* Larger font size */\r\n");
      out.write("        }\r\n");
      out.write("        .navbar a:hover {\r\n");
      out.write("            text-decoration: underline; /* Underline on hover */\r\n");
      out.write("        }\r\n");
      out.write("        h1 {\r\n");
      out.write("            color: #2c6fbb; /* Cool blue for headings */\r\n");
      out.write("            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Subtle shadow for depth */\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <nav class=\"navbar\">\r\n");
      out.write("        <a href=\"adminHome.jsp\"><h2>Online Shopping</h2></a>\r\n");
      out.write("        <a href=\"addNewProduct.jsp\">Add New Product</a>\r\n");
      out.write("        <a href=\"allProductEditProduct.jsp\">All Products & Edit</a>\r\n");
      out.write("        <a href=\"messagesReceived.jsp\">Messages Received</a>\r\n");
      out.write("        <a href=\"ordersReceived.jsp\">Orders Received</a>\r\n");
      out.write("        <a href=\"cancelOrders.jsp\">Cancel Orders</a>\r\n");
      out.write("        <a href=\"deliveredOrders.jsp\">Delivered Orders</a>\r\n");
      out.write("        <a href=\"../logout.jsp\">Logout</a>\r\n");
      out.write("    </nav>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/addNewProduct-style.css\">\r\n");
      out.write("    <title>Add New Product</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            background: linear-gradient(135deg, #d4fc79 0%, #96e6a1 100%); /* Light green gradient */\r\n");
      out.write("        }\r\n");
      out.write("        .container {\r\n");
      out.write("            margin-top: 30px;\r\n");
      out.write("        }\r\n");
      out.write("        .alert {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        .input-style {\r\n");
      out.write("            border-radius: 25px;\r\n");
      out.write("            height: 50px;\r\n");
      out.write("            background-color: #e0f7fa; /* Light cyan background for inputs */\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("        }\r\n");
      out.write("        .button {\r\n");
      out.write("            border-radius: 25px;\r\n");
      out.write("            background-color: #4caf50; /* Green background */\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 12px 25px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            transition: background 0.3s;\r\n");
      out.write("        }\r\n");
      out.write("        .button:hover {\r\n");
      out.write("            background-color: #45a049; /* Darker green on hover */\r\n");
      out.write("        }\r\n");
      out.write("        h3 {\r\n");
      out.write("            color: #2c6fbb; /* Cool blue for headings */\r\n");
      out.write("            text-shadow: 1px 1px 3px rgba(0, 0, 0, .25);\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");

    int id = 1; // Default product ID
    String msg = request.getParameter("msg"); // Get message parameter from the request
    try {
        Connection con = ConnectionProvider.getCon();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT MAX(product_id) FROM products");
        if (resultSet.next()) {
            id = resultSet.getInt(1) + 1; // Get the next product ID
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("SQL Error: " + e.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error: " + e.getMessage());
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    ");
 if (msg != null) { 
      out.write("\r\n");
      out.write("        <div class=\"alert alert-");
      out.print( msg.equals("done") ? "success" : "danger" );
      out.write("\">\r\n");
      out.write("            ");
      out.print( msg.equals("done") ? "Product Added Successfully!" : "Something went wrong! Try Again!" );
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <h3>Product ID: ");
      out.print( id );
      out.write("</h3>\r\n");
      out.write("    \r\n");
      out.write("    <form action=\"AddProductServlet\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("        <input type=\"hidden\" name=\"id\" value=\"");
      out.print( id );
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-6\">\r\n");
      out.write("                <h3>Enter Name</h3>\r\n");
      out.write("                <input class=\"input-style form-control\" type=\"text\" name=\"P_name\" placeholder=\"Enter Name\" required maxlength=\"100\">\r\n");
      out.write("                <hr>\r\n");
      out.write("                \r\n");
      out.write("                <h3>Enter Description</h3>\r\n");
      out.write("                <textarea class=\"input-style form-control\" name=\"description\" placeholder=\"Enter Product Description\" required maxlength=\"500\"></textarea>\r\n");
      out.write("                <hr>\r\n");
      out.write("                \r\n");
      out.write("                <h3>Unit</h3>\r\n");
      out.write("                <input class=\"input-style form-control\" type=\"text\" name=\"unit\" placeholder=\"Enter Unit (e.g., kg, lb)\" required maxlength=\"20\">\r\n");
      out.write("                <hr>\r\n");
      out.write("\r\n");
      out.write("                <h3>Product Image (optional)</h3>\r\n");
      out.write("                <input class=\"input-style form-control\" type=\"file\" name=\"productImage\" accept=\"image/*\">\r\n");
      out.write("                <hr>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-md-6\">\r\n");
      out.write("                <h3>Enter Category</h3>\r\n");
      out.write("                <input class=\"input-style form-control\" type=\"text\" name=\"category\" placeholder=\"Enter Category\" required maxlength=\"100\">\r\n");
      out.write("                <hr>\r\n");
      out.write("\r\n");
      out.write("                <h3>Enter Price</h3>\r\n");
      out.write("                <input class=\"input-style form-control\" type=\"number\" step=\"0.01\" name=\"price\" placeholder=\"Enter Price per unit\" required min=\"0\">\r\n");
      out.write("                <hr>\r\n");
      out.write("\r\n");
      out.write("                <h3>Available Quantity</h3>\r\n");
      out.write("                <input class=\"input-style form-control\" type=\"number\" name=\"available_qty\" placeholder=\"Enter Available Quantity\" required min=\"0\">\r\n");
      out.write("                <hr>\r\n");
      out.write("\r\n");
      out.write("                <h3>Status</h3>\r\n");
      out.write("                <select name=\"status\" class=\"input-style form-control\">\r\n");
      out.write("                    <option value=\"Available\">Available</option>\r\n");
      out.write("                    <option value=\"Out of Stock\">Out of Stock</option>\r\n");
      out.write("                </select>\r\n");
      out.write("                <hr>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <button type=\"submit\" class=\"button\">Save <i class='far fa-arrow-alt-circle-right'></i></button>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap JS and dependencies -->\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
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
