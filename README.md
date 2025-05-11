
# **Digimart - An E-Commerce Web Application**

---

## **Overview**
**Digimart** is a comprehensive e-commerce platform built to simplify online shopping and facilitate smooth interactions between consumers and sellers. Developed using Java Servlets, JSP, and MySQL, this project offers core e-commerce functionalities such as product browsing, cart management, user registration, and order placement. Administrators have extended access to product management, order tracking, and customer communication.

## **Features**
- **User Registration & Authentication**: Secure user sign-up and login functionalities.
- **Product Browsing**: Users can search for and view products by categories.
- **Cart Management**: Add items to the cart, update quantities, and remove products.
- **Order Processing**: Users can place orders and track their status.
- **Admin Panel**: Administrators can add/edit/delete products, view orders, and manage customer queries.
- **Profile Management**: Users can update personal details, change their password, and manage addresses.
- **Messaging**: A messaging feature allows users to send queries to the admin.

## **Tech Stack**
- **Frontend**: JSP, HTML, CSS
- **Backend**: Java Servlets, JSP
- **Database**: MySQL
- **Libraries**:
  - JSTL (JavaServer Pages Standard Tag Library)
  - MySQL Connector for Java

## **Project Structure**
```
src/
│
├── main/
│   ├── java/
│   │   ├── com.digimart.project/
│   │   │   └── ConnectionProvider.java
│   │   ├── com.digimart.Servlet/
│   │   │   └── [Servlet files]
│   ├── webapp/
│   │   ├── admin/
│   │   ├── css/
│   │   ├── WEB-INF/
│   │   └── [JSP files]
```

## **Installation**
To run the project locally, follow these steps:

### 1. **Clone the Repository**
```bash
git clone https://github.com/yourusername/digimart.git
```

### 2. **Configure Database**
- Install MySQL and create a database (e.g., `digimart_db`).
- Import the provided SQL file into the database.
- Update the database connection settings in the `ConnectionProvider.java` file to match your MySQL configuration.

### 3. **Setup Java Environment**
- Install Java Development Kit (JDK 8 or later).
- Install Apache Tomcat (version 9.0 or later).
- Set up the environment variables for Java and Tomcat.

### 4. **Deploy to Tomcat**
- Place the project folder into the `webapps` directory of your Tomcat server.
- Start Tomcat and navigate to `http://localhost:8080/digimart` in your browser.

## **How to Use**
- **Sign up/Login**: Users can create an account or log in using their credentials.
- **Browse Products**: Explore the available products on the homepage or use the search feature.
- **Add to Cart**: Add items to your cart, view the cart, and proceed to checkout.
- **Admin Features**: Log in as an admin to manage products and orders.

## **Contributing**
We welcome contributions! Please fork this repository and create a pull request with detailed information on the changes you've made.

## **Future Enhancements**
- Payment gateway integration.
- Mobile-friendly interface.
- Enhanced product recommendation system.
- More secure password management.


## **Contact**
For any inquiries or feedback, please contact:  
- **Project Maintainer and Backend Developer**: Dinesh Babu Surapaneni
- **Frontend Developer**: Balusu Subhodh Kumar
- **Email**: dinesh.surapaneni@outlook.com
---

you can find Screenshots of project here.
[Open PDF](https://github.com/Dineshbabu290904/DigiMart/blob/master/Capstone%20Output.pdf)

