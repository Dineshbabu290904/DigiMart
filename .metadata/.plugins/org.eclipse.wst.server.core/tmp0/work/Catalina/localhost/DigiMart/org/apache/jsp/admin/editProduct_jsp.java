/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-10-24 12:43:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.digimart.project.ConnectionProvider;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Base64;

public final class editProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.LinkedHashSet<>(4);
    _jspx_imports_classes.add("java.math.BigDecimal");
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/addNewProduct-style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("    <title>Edit Product</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            background: linear-gradient(135deg, #d4fc79 0%, #96e6a1 100%); /* Light green gradient */\r\n");
      out.write("            font-family: Arial, sans-serif;\r\n");
      out.write("            color: #333; /* Dark text color for contrast */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .back {\r\n");
      out.write("            color: white;\r\n");
      out.write("            margin-left: 2.5%;\r\n");
      out.write("            font-size: 1.2em;\r\n");
      out.write("            text-decoration: none; /* Remove underline */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .input-style {\r\n");
      out.write("            border-radius: 25px;\r\n");
      out.write("            background-color: #e0f7fa; /* Light cyan background */\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h3.card-title {\r\n");
      out.write("            color: #2c6fbb; /* Cool blue for headings */\r\n");
      out.write("            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Subtle shadow for depth */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button {\r\n");
      out.write("            background-color: #28a745; /* Green background */\r\n");
      out.write("            color: white; /* White text */\r\n");
      out.write("            border: none; /* No border */\r\n");
      out.write("            padding: 10px 20px; /* Padding */\r\n");
      out.write("            font-size: 16px; /* Font size */\r\n");
      out.write("            cursor: pointer; /* Pointer cursor on hover */\r\n");
      out.write("            border-radius: 25px; /* Rounded corners */\r\n");
      out.write("            transition: background-color 0.3s; /* Smooth background transition */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button:hover {\r\n");
      out.write("            background-color: #218838; /* Darker green on hover */\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <h2><a class=\"back\" href=\"allProductEditProduct.jsp\"><i class='fas fa-arrow-circle-left'></i> Back</a></h2>\r\n");
      out.write("\r\n");
      out.write("    ");

        String productId = request.getParameter("product_id");
        if (productId != null) {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE product_id = ?");
                ps.setInt(1, Integer.parseInt(productId));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    // Retrieve data from the database
                    int userId = rs.getInt("user_id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String category = rs.getString("category");
                    BigDecimal pricePerUnit = rs.getBigDecimal("price_per_unit");
                    String unit = rs.getString("unit");
                    BigDecimal availableQty = rs.getBigDecimal("available_qty");
                    Timestamp dateListed = rs.getTimestamp("date_listed");
                    byte[] imageBytes = rs.getBytes("image");
                    String status = rs.getString("status");

                    // Convert image to base64 for displaying
                    String imageBase64 = (imageBytes != null) ? Base64.getEncoder().encodeToString(imageBytes) : null;
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <form action=\"UpdateProductServlet\" method=\"get\" enctype=\"multipart/form-data\">\r\n");
      out.write("        <input type=\"hidden\" name=\"product_id\" value=\"");
      out.print( productId );
      out.write("\">\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row mb-4\"> <!-- Added mb-4 for vertical spacing -->\r\n");
      out.write("                <div class=\"col-md-6\">\r\n");
      out.write("                    <div class=\"card\">\r\n");
      out.write("                        <div class=\"card-body\">\r\n");
      out.write("                            <h3 class=\"card-title\">User ID</h3>\r\n");
      out.write("                            <input class=\"input-style\" type=\"number\" name=\"user_id\" value=\"");
      out.print( userId );
      out.write("\" required />\r\n");
      out.write("                            <hr>\r\n");
      out.write("                            \r\n");
      out.write("                            <h3 class=\"card-title\">Name</h3>\r\n");
      out.write("                            <input class=\"input-style\" type=\"text\" name=\"name\" value=\"");
      out.print( name );
      out.write("\" required />\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-md-6\">\r\n");
      out.write("                    <div class=\"card\">\r\n");
      out.write("                        <div class=\"card-body\">\r\n");
      out.write("                            <h3 class=\"card-title\">Category</h3>\r\n");
      out.write("                            <input class=\"input-style\" type=\"text\" name=\"category\" value=\"");
      out.print( category );
      out.write("\" required />\r\n");
      out.write("                            <hr>\r\n");
      out.write("\r\n");
      out.write("                            <h3 class=\"card-title\">Price per Unit</h3>\r\n");
      out.write("                            <input class=\"input-style\" type=\"number\" name=\"price_per_unit\" value=\"");
      out.print( pricePerUnit );
      out.write("\" required step=\"0.01\" />\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row mb-4\"> <!-- Added mb-4 for vertical spacing -->\r\n");
      out.write("                <div class=\"col-md-6\">\r\n");
      out.write("                    <div class=\"card\">\r\n");
      out.write("                        <div class=\"card-body\">\r\n");
      out.write("                            <h3 class=\"card-title\">Description</h3>\r\n");
      out.write("                            <textarea class=\"input-style\" name=\"description\" required>");
      out.print( description );
      out.write("</textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <hr>\r\n");
      out.write("                        <h3 class=\"card-title\">Status</h3>\r\n");
      out.write("                            <select class=\"input-style\" name=\"status\" required>\r\n");
      out.write("                                <option value=\"Available\" ");
      out.print( status.equals("Available") ? "selected" : "" );
      out.write(">Available</option>\r\n");
      out.write("                                <option value=\"Out of Stock\" ");
      out.print( status.equals("Out of Stock") ? "selected" : "" );
      out.write(">Out of Stock</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-md-6\">\r\n");
      out.write("                    <div class=\"card\">\r\n");
      out.write("                        <div class=\"card-body\">\r\n");
      out.write("                            <h3 class=\"card-title\">Unit</h3>\r\n");
      out.write("                            <input class=\"input-style\" type=\"text\" name=\"unit\" value=\"");
      out.print( unit );
      out.write("\" required />\r\n");
      out.write("                            <hr>\r\n");
      out.write("\r\n");
      out.write("                            <h3 class=\"card-title\">Available Quantity</h3>\r\n");
      out.write("                            <input class=\"input-style\" type=\"number\" name=\"available_qty\" value=\"");
      out.print( availableQty );
      out.write("\" required />\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div style=\"text-align: center; margin-top: 20px;\">\r\n");
      out.write("                <button type=\"submit\" name=\"update\">Update Product</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    ");

                } else {
                    out.println("<h3 style='color:red;'>Product not found!</h3>");
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<h3 style='color:red;'>Error fetching product data!</h3>");
            }
        } else {
            out.println("<h3 style='color:red;'>Invalid Product ID!</h3>");
        }
    
      out.write("\r\n");
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
