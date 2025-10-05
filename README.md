🧾 Customer Authentication System (Hibernate + Java + MySQL)

A simple Java console-based application built using Hibernate ORM for managing customer registration, login, and account deletion with MySQL database integration.
This project demonstrates Hibernate configuration, entity mapping, and CRUD operations in a practical authentication flow.

-------------------------------------------------------------------------------
✨ Features

✅ Customer Registration
Registers new customers with personal details and automatically generates unique usernames and random passwords.

✅ Login Authentication
Validates user credentials (username and password) against database records.

✅ Account Deletion / Logout
Removes customer records from the database based on registration ID.

✅ Auto Credential Generation
Automatically creates:

Username → <customerName>@auth

Password → Random 8-character string (UUID based)

✅ Database Integration
Uses Hibernate ORM for mapping Java objects to database tables.
-------------------------------------------------------------------------------

🛠️ Tech Stack

-Java (JDK 8 or above) — Core application logic

-Hibernate ORM — Object Relational Mapping and CRUD handling

-MySQL — Database for storing customer data

-JPA Annotations — For entity and column mapping-

-UUID — To generate random passwords

-------------------------------------------------------------------------------

📁 Project Structure

src/
├── com/config/
│   └── HibernateUtil.java     # Hibernate configuration and SessionFactory setup
├── com/model/
│   └── Customer1.java         # Customer entity mapped with JPA annotations
└── com/user/
    └── Test.java              # Console-based UI for user interaction
----------------------------------------------------------------------------------

📦Class Overview
    
🔹 HibernateUtil.java

   -Configures Hibernate using programmatic configuration (no XML).

  -Defines connection properties (driver, URL, user, password).

  -Builds SessionFactory and enables second-level caching with Ehcache.

🔹 Customer1.java

  -Entity class annotated with @Entity and @Id.

  -Fields: regId, name, email, mobNo, age, username, password, TimeStamp.

  -Includes unique constraint on username.

🔹 Test.java

  -Main class containing interactive menu:

  -Register new user

  -Login existing user

  -Delete user/logout

Handles Hibernate sessions, queries, and CRUD transactions.
--------------------------------------------------------------------------------------
💽 Database Configuration

Database Name: customerh
Table: Automatically created by Hibernate (Customer1)

Update your MySQL credentials in HibernateUtil.java:

  map.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/customerh");
  map.put(Environment.JAKARTA_JDBC_USER, "root");
  map.put(Environment.JAKARTA_JDBC_PASSWORD, "root");

