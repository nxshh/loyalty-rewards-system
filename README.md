# 🚀Loyalty Rewards System

A backend service built with Spring Boot that simulates a customer loyalty rewards platform.
The system provides REST APIs to manage customers, track reward points, and simulate concurrent reward updates using multithreading.

## Tech Stack
- Technology	Purpose
- Java 17	Core programming language
- Spring Boot	Backend framework
- Spring Data JPA	Database interaction
- MySQL	Data persistence
- Maven	Dependency management & build tool
- Swagger	API documentation

## Features
- Create and manage customers
- Add reward points to customer accounts
- Redeem reward points
- Retrieve all registered customers
- Simulate concurrent reward updates using multithreading
- Interactive Swagger API documentation

## API Endpoints
POST - /customers - Create a new customer <br>
GET - /customers - Retrieve all customers <br>
POST - /customers/{id}/addPoints - Add reward points <br>
POST - /customers/{id}/redeem	- Redeem reward points <br>
POST - /customers/{id}/simulate	- Run concurrent reward simulation

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

## API Documentation
Once the application is running, open: <br>
http://localhost:6060/swagger-ui.html <br>
Swagger provides an interactive interface to test all APIs directly from the browser.

## Concurrency Simulation

The endpoint below triggers multiple threads that update reward points simultaneously. <br>
POST /customers/{id}/simulate <br>

This demonstrates handling of concurrent reward processing, similar to real-world loyalty systems where multiple transactions occur at the same time.

## Database Schema

Database: loyalty_db <br>
Table: customer <br>
id: customer ID <br>
name:	Customer name <br>
reward_points:	Current reward balance

## 👤 Author

Nisarga Murthy
