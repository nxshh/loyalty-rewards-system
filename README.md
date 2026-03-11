# Loyalty Rewards System

A Spring Boot backend service that simulates a customer loyalty rewards platform with concurrent reward processing.

## Tech Stack
Java 17  
Spring Boot  
Spring Data JPA  
MySQL  
Maven  

## Features
- Create customers
- Add reward points
- Redeem reward points
- View all customers
- Simulate concurrent reward updates using multithreading
- REST API with Swagger documentation

## API Endpoints

POST /customers  
Create new customer

GET /customers  
List all customers

POST /customers/{id}/addPoints  
Add reward points

POST /customers/{id}/redeem  
Redeem reward points

POST /customers/{id}/simulate  
Simulate concurrent reward updates

## Run Project

Clone repository


git clone <repo-link>


Run application


mvn spring-boot:run


Swagger UI


http://localhost:6060/swagger-ui.html


## Database

MySQL database used for persistence.


database: loyalty_db
table: customer


## Author

Nisarg Murthy