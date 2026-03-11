# 🚀Loyalty Rewards System

A backend service built with Spring Boot that simulates a customer loyalty rewards platform.
The system provides REST APIs to manage customers, track reward points, simulate concurrent reward updates using multithreading, and run inside a containerized environment using Docker.

## Tech Stack
- Technology	Purpose
- Java 17	Core programming language
- Spring Boot	Backend framework
- Spring Data JPA	Database interaction
- MySQL	Data persistence
- Maven	Dependency management & build tool
- Swagger	API documentation
- Docker Containerized deployment
- Spring Cache Caching frequently accessed data
- Logback Application logging

---

## Features
- Create and manage customers
- Add reward points to customer accounts
- Redeem reward points
- Retrieve all registered customers
- Simulate concurrent reward updates using multithreading
- Global exception handling for API errors
- Response caching for faster customer retrieval
- Structured logging for monitoring application activity
- Containerized backend using Docker
- Run database and backend together using Docker Compose
- Interactive Swagger API documentation

---

## API Endpoints
POST - /customers - Create a new customer <br>
GET - /customers - Retrieve all customers <br>
POST - /customers/{id}/addPoints - Add reward points <br>
POST - /customers/{id}/redeem	- Redeem reward points <br>
POST - /customers/{id}/simulate	- Run concurrent reward simulation

---

## Project Setup
### 1. Clone the Repository
git clone https://github.com/<your-username>/loyalty-rewards-system.git <br>
cd loyalty-rewards-system

### 2. Configure Database
Create a MySQL database: <br>
CREATE DATABASE loyalty_db; <br>
Update application.properties if needed.

### 3. Run the Application
Using Maven: mvn spring-boot:run <br>
or <br>
Using the Maven wrapper: ./mvnw spring-boot:run

### 4. Run with Docker
Build and start containers using Docker Compose: <br>
docker compose up --build <br>
This will start both the backend service and the MySQL database inside Docker containers.

---

## API Documentation
Once the application is running, open: <br>
http://localhost:6060/swagger-ui.html <br>
Swagger provides an interactive interface to test all APIs directly from the browser.

## Concurrency Simulation

The endpoint below triggers multiple threads that update reward points simultaneously. <br>
POST /customers/{id}/simulate <br>

This demonstrates handling of concurrent reward processing, similar to real-world loyalty systems where multiple transactions occur at the same time.


## 👤 Author

Nisarga Murthy
