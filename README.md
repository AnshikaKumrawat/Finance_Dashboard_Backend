# 💰 Finance Dashboard — Backend

A robust, production-ready **Finance Dashboard** REST API built with **Spring Boot 3.2.1** and **Java 21**. Supports secure JWT authentication, full expense/income management, email notifications, and a clean layered architecture designed for seamless frontend integration.

---

## 📌 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Getting Started](#-getting-started)
- [Environment Configuration](#-environment-configuration)
- [API Endpoints](#-api-endpoints)
- [Security](#-security)
- [Database Schema](#-database-schema)
- [Contributing](#-contributing)
- [Author](#-author)

---

## ✨ Features

- 🔐 **JWT-based Authentication** — Secure login & registration with token-based access control
- 👤 **User Profile Management** — Profile picture upload support
- 💸 **Expense & Income Tracking** — Full CRUD operations for financial transactions
- 📊 **Dashboard Analytics** — Aggregated financial data for frontend dashboard rendering
- 📧 **Email Notifications** — Spring Mail integration for alerts and OTP/verification emails
- ✅ **Input Validation** — Bean Validation (`@Valid`) on all request DTOs
- 🔒 **Spring Security** — Role-based access control with CORS configuration
- 🗄️ **MySQL Persistence** — JPA/Hibernate with relational data modeling

---

## 🛠 Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3.2.1 |
| Security | Spring Security + JWT (jjwt 0.11.5) |
| Persistence | Spring Data JPA + Hibernate |
| Database | MySQL 8.0+ |
| Email | Spring Boot Mail |
| HTTP Client | Unirest Java 1.4.9 |
| Validation | Spring Boot Validation |
| Build Tool | Maven (Maven Wrapper included) |
| Boilerplate | Lombok |

---

## 📁 Project Structure

```
Finance_Dashboard_Backend/
├── src/
│   └── main/
│       ├── java/com/finance_dashboard/backend/
│       │   ├── controllers/       # REST controllers
│       │   ├── services/          # Business logic layer
│       │   ├── repositories/      # Spring Data JPA repositories
│       │   ├── models/            # JPA entity classes
│       │   ├── dto/               # Request/Response DTOs
│       │   ├── security/          # JWT filter, SecurityConfig
│       │   └── finance_dashboard_backend.java
│       └── resources/
│           └── application.properties
├── uploads/
│   └── user/
│       └── profile/
├── pom.xml
├── mvnw
└── .gitignore
```

---

## ✅ Prerequisites

- Java 21 (JDK)
- Maven 3.8+ (or use the included `./mvnw` wrapper)
- MySQL 8.0+
- Git
- A Gmail account (for email/OTP features)

---

## 🚀 Getting Started

**1. Clone the repository**

```bash
git clone https://github.com/AnshikaKumrawat/Finance_Dashboard_Backend.git
cd Finance_Dashboard_Backend
```

**2. Create the MySQL database**

```sql
CREATE DATABASE finance_dashboard;
```

**3. Configure application.properties**

See [Environment Configuration](#-environment-configuration) below.

**4. Build and run**

```bash
./mvnw spring-boot:run
```

Server starts at: `http://localhost:8080`

---

## ⚙️ Environment Configuration

Update `src/main/resources/application.properties`:

```properties
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/finance_dashboard
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

app.jwt.secret=YOUR_JWT_SECRET_KEY
app.jwt.expiration-ms=86400000

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_EMAIL@gmail.com
spring.mail.password=YOUR_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB
file.upload-dir=uploads/user/profile
```

> ⚠️ Never commit real credentials to version control. Use environment variables or a secrets manager in production.

---

## 📡 API Endpoints

### 🔑 Auth

| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| POST | `/api/auth/register` | Register a new user | No |
| POST | `/api/auth/login` | Login and receive JWT | No |
| POST | `/api/auth/verify-otp` | Verify email OTP | No |
| POST | `/api/auth/forgot-password` | Send password reset email | No |
| POST | `/api/auth/reset-password` | Reset password with token | No |

### 👤 User

| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| GET | `/api/user/profile` | Get logged-in user profile | Yes |
| PUT | `/api/user/profile` | Update user details | Yes |
| POST | `/api/user/profile/picture` | Upload profile picture | Yes |

### 💳 Transactions

| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| GET | `/api/transactions` | Get all transactions | Yes |
| POST | `/api/transactions` | Add a new transaction | Yes |
| PUT | `/api/transactions/{id}` | Update a transaction | Yes |
| DELETE | `/api/transactions/{id}` | Delete a transaction | Yes |

### 📊 Dashboard

| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| GET | `/api/dashboard/summary` | Get income/expense summary | Yes |
| GET | `/api/dashboard/monthly` | Get monthly breakdown | Yes |

> All protected endpoints require the header: `Authorization: Bearer <your_jwt_token>`

---

## 🔐 Security

- Passwords are hashed using **BCrypt** before storage
- JWT tokens are signed with a configurable secret (default expiry: 24 hours)
- Spring Security filters validate every incoming request before granting access
- CORS is configured to allow requests from whitelisted frontend origins

---

## 🗄️ Database Schema

**users**

| Column | Type | Notes |
|---|---|---|
| id | BIGINT | Primary Key |
| name | VARCHAR | |
| email | VARCHAR | Unique |
| password | VARCHAR | BCrypt hashed |
| profile_picture_path | VARCHAR | |
| created_at | TIMESTAMP | |

**transactions**

| Column | Type | Notes |
|---|---|---|
| id | BIGINT | Primary Key |
| user_id | BIGINT | FK → users.id |
| type | ENUM | INCOME / EXPENSE |
| category | VARCHAR | |
| amount | DECIMAL | |
| description | VARCHAR | |
| transaction_date | DATE | |

> Tables are auto-generated by Hibernate (`ddl-auto=update`). Use `validate` or `none` in production.
