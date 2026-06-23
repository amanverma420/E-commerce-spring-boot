# E-Commerce Store (Spring Boot & Thymeleaf)

A modern, responsive, and full-featured E-Commerce web application built using **Spring Boot**, **Spring Security**, **Spring Data JPA**, and **Thymeleaf** with professional **Bootstrap 5** frontend designs.

---

## 🚀 Key Features

* **User Authentication & Authorization**: Integrated security with user registration, login, profile management, and password reset functionalities.
* **Product Catalog**: Dynamic categorization and search filters. Product detail views displaying specifications, pricing, discount calculations, and real-time inventory status.
* **Shopping Cart & Checkout**: Real-time cart quantity adjustments, order placement, and receipt processing.
* **Admin Dashboard**: Comprehensive control panel to add/edit products, manage categories, track orders, and configure system status.
* **Responsive, Stretched-Free Layouts**: Refined frontend styling to ensure all category avatars, carousel banners, and product cards preserve their native aspect ratios across all resolutions using CSS `object-fit`.

---

## 🛠️ Technology Stack

* **Backend**: Spring Boot 3.x, Spring Data JPA, Spring Security, Spring Mail
* **Frontend**: Thymeleaf, Bootstrap 5.3, FontAwesome, JQuery Validation
* **Database**: MySQL Database
* **Build Tool**: Maven Wrapper (`mvnw`)

---

## 🖼️ Application Screenshots

### 🏠 Home Page
Features a sleek promotional carousel, a grid of categories with smooth hover effects, and a section displaying the latest products.
![Home Page](images/home_page.png)

### 🛍️ Product Directory & Filter
Enables filtering of products by category and searching by title, dynamically showing discount prices and availability.
![Products Page](images/products_page.png)

### 🔍 Product Details
Provides in-depth product information, stock status, delivery policies, and an add-to-cart call to action.
![Product Details](images/product_detail.png)

### 🔐 Register & Login Forms
Modern, centered login and sign-up interfaces using clean illustrations.
![Register Page](images/register_page.png)
![Login Page](images/login_page.png)

---

## ⚙️ Configuration & Setup

### 1. Database Setup
Ensure you have **MySQL Server** installed and running on your local machine.
Create a database named `ecommerce_db`:
```sql
CREATE DATABASE ecommerce_db;
```

### 2. Configure Environment Properties
Edit the `src/main/resources/application.properties` file with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db?createDatabaseIfNotExist=true
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

# SMTP Mail Settings for password reset functionality
spring.mail.username=YOUR_GMAIL_ADDRESS
spring.mail.password=YOUR_GMAIL_APP_PASSWORD
```

### 3. Build and Run the Application
From the root directory of the project, run the following command to start the server:

**For PowerShell:**
```powershell
.\mvnw.cmd spring-boot:run
```

**For Command Prompt:**
```cmd
mvnw.cmd spring-boot:run
```

The application will start on [http://localhost:8080](http://localhost:8080).

---

## 📂 Project Structure
```text
shopping-cart-spring-boot/
│
├── src/main/
│   ├── java/com/ecom/           # Spring Boot Controller, Service, and Repository layers
│   └── resources/
│       ├── static/              # CSS styles, JS validation scripts, and default static assets
│       ├── templates/           # Thymeleaf layouts, user views, and admin panels
│       └── application.properties
│
├── images/                      # Project feature screenshots
├── pom.xml                      # Maven project dependencies
└── README.md                    # Project documentation
```
