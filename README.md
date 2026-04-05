💰 Finance Dashboard — Backend
A robust, production-ready  Finance Dashboard REST API built with Spring Boot 3.2.1 and Java 21. 
The backend supports secure user authentication via JWT, full expense/income management, email notifications, and a clean layered architecture designed for seamless frontend integration.

📌 Table of Contents
Features
Tech Stack
Project Structure
Prerequisites
Getting Started
Environment Configuration
API Endpoints
Security
Database Schema
Contributing
Author


✨ Features
🔐 JWT-based Authentication — Secure login & registration with token-based access control
👤 User Profile Management — Profile picture upload support (uploads/user/profile)
💸 Expense & Income Tracking — Full CRUD operations for financial transactions
📊 Dashboard Analytics — Aggregated financial data for frontend dashboard rendering
📧 Email Notifications — Spring Mail integration for alerts and OTP/verification emails
✅ Input Validation — Bean Validation (@Valid) on all request DTOs
🔒 Spring Security — Role-based access control with CORS configuration
🗄️ MySQL Persistence — JPA/Hibernate with relational data modeling


🛠 Tech Stack
Layer         Technology
Language      Java 21
Framework     Spring Boot 3.2.1
Security      Spring Security + JWT (jjwt 0.11.5)
Persistence   Spring Data JPA + Hibernate
Database      MySQL 8.0+
Email         Spring Boot Mail
HTTP Client   Unirest Java 1.4.9
Validation    Spring Boot Validation
Build Tool    Maven (Maven Wrapper included)
Boilerplate   Lombok


📁 Project Structure
Finance_Dashboard_Backend/
├── src/
│   └── main/
│       ├── java/com/finance_dashobard/backend/
│       │   ├── controllers/       # REST controllers (Auth, User, Transaction, etc.)
│       │   ├── services/          # Business logic layer
│       │   ├── repositories/      # Spring Data JPA repositories
│       │   ├── models/            # JPA entity classes
│       │   ├── dto/               # Request/Response DTOs
│       │   ├── security/          # JWT filter, UserDetailsService, SecurityConfig
│       │   └── ExpenseTrackerApplication.java
│       └── resources/
│           └── application.properties
├── uploads/
│   └── user/
│       └── profile/               # Uploaded profile images
├── .mvn/wrapper/                  # Maven wrapper binaries
├── pom.xml
├── mvnw / mvnw.cmd
└── .gitignore


✅ Prerequisites
Make sure you have the following installed:

Java 21 (JDK)
Maven 3.8+ (or use the included ./mvnw wrapper)
MySQL 8.0+
Git
A mail account (Gmail recommended) for email features


🚀 Getting Started
1. Clone the repository
bashgit clone https://github.com/AnshikaKumrawat/Finance_Dashboard_Backend.git
cd Finance_Dashboard_Backend

3. Create the MySQL database
sqlCREATE DATABASE finance_dashboard;

4. Configure environment variables
Copy and update src/main/resources/application.properties (see Environment Configuration below).

5. Build and run
bash# Using Maven Wrapper (recommended)
./mvnw spring-boot:run

# Or using installed Maven
mvn spring-boot:run
The server starts at: http://localhost:8080

⚙️ Environment Configuration
Update src/main/resources/application.properties:
properties# ── Server ──────────────────────────────────────────────
server.port=8080

# ── Database ────────────────────────────────────────────
spring.datasource.url=jdbc:mysql://localhost:3306/finance_dashboard
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# ── JPA / Hibernate ─────────────────────────────────────
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# ── JWT ─────────────────────────────────────────────────
app.jwt.secret=YOUR_JWT_SECRET_KEY
app.jwt.expiration-ms=86400000

# ── Mail ────────────────────────────────────────────────
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_EMAIL@gmail.com
spring.mail.password=YOUR_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# ── File Upload ─────────────────────────────────────────
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB
file.upload-dir=uploads/user/profile

⚠️ Never commit real credentials to version control. Use environment variables or a secrets manager in production.


📡 API Endpoints
🔑 Auth
Method     Endpoint                   Description                 Auth Required
POST       /api/auth/register         Register a new user         No
POST       /api/auth/login            Login and receive JWT       No
POST       /api/auth/verify-otp       Verify email OTP            No
POST       /api/auth/forgot-password  Send password reset email   No
POST       /api/auth/reset-password   Reset password with token   No

👤 User
Method     Endpoint                    Description                   Auth Required
GET        /api/user/profile           Get logged-in user profile    Yes
PUT        /api/user/profile           Update user details           Yes
POST       /api/user/profile/picture   Upload profile picture        Yes

💳 Transactions
Method      Endpoint                    Description                   Auth Required
GET         /api/transactions           Get all transactions          Yes
POST        /api/transactions           Add a new transaction         Yes
PUT         /api/transactions/{id}      Update a transaction          Yes
DELETE      /api/transactions/{id}      Delete a transaction          Yes

📊 Dashboard
Method      Endpoint                    Description                    Auth Required
GET         /api/dashboard/summary      Get income/expense summary     Yes
GET         /api/dashboard/monthly      Get monthly breakdown          Yes

Note: All protected endpoints require the header: Authorization: Bearer <your_jwt_token>


🔐 Security
Passwords are hashed using BCrypt before storage.
JWT tokens are signed with a configurable secret and have a configurable expiry (default: 24 hours).
Spring Security filters validate every incoming request token before allowing access to protected resources.
CORS is configured to allow requests from whitelisted frontend origins.


🗄️ Database Schema (Overview)
users
  ├── id (PK)
  ├── name
  ├── email (unique)
  ├── password (BCrypt hash)
  ├── profile_picture_path
  └── created_at

transactions
  ├── id (PK)
  ├── user_id (FK → users.id)
  ├── type (INCOME / EXPENSE)
  ├── category
  ├── amount
  ├── description
  └── transaction_date

Tables are auto-generated by Hibernate (ddl-auto=update). Adjust to validate or none in production.


🤝 Contributing
Contributions, suggestions, and bug reports are welcome!

Fork the repository
Create your feature branch (git checkout -b feature/your-feature)
Commit your changes (git commit -m 'Add your feature')
Push to the branch (git push origin feature/your-feature)
Open a Pull Request

