
# Uber Pricing Module

## Project Description

This project is a part of the Uber Pricing assignment. It is a Spring Boot application designed to calculate the price of a ride based on several factors, including distance, time, and waiting charges. The application stores different pricing configurations, which can be dynamically applied based on the day of the week and other conditions.

## Features
- Pricing Configuration: Configure pricing for rides with parameters such as base price, additional price per km, time multiplier, and waiting charge per minute.
- Ride Management: Create rides and automatically calculate the price based on the curr
ent active pricing configuration.
- Active Pricing: Support for enabling/disabling different pricing configurations.


## Tech Stack

- Java: Programming language used for building the application.
- Spring Boot: Framework used for building the RESTful API.
- MariaDB: Database used for storing ride and pricing data.
- Lombok: Library to reduce boilerplate code.

## Setup and Installation

### Prerequisites

- Java 17 
- Maven 3.3.2
- MariaDB

### Steps to Run the Application

1. Clone the Repository
git clone <repository-url>
cd uber-pricing-module

2. Set Up the Database
- Create a new database in MariaDB/MySQL.
Create a new database in MariaDB/MySQL.

- Update the src/main/resources/application.properties file with your database credentials:

spring.datasource.url=jdbc:mariadb://localhost:3306/uber_pricing
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>

3. Build and Run the Application

- Build the project using Maven:

mvn clean install

- Run the application:

mvn spring-boot:run

4. Test the API Endpoints

- You can use Postman or any other API testing tool to test the API endpoints.

Create a Pricing Configuration

POST /api/pricing/add
Content-Type: application/json

{
  "dayOfWeek": "Saturday",
  "basePrice": 220,
  "additionalPricePerKm": 5,
  "timeMultiplier": 5,
  "waitingChargePerMinute": 10,
  "isActive": true
}


Create a Ride

POST /api/ride/add
Content-Type: application/json

{
  "distanceKm": 10,
  "timeHours": 0.5,
  "waitingMinutes": 5
}

5. Docker Deployment (Optional)

To run the application in Docker, first, ensure Docker is installed on your machine.

Build the Docker image:

docker build -t uber-pricing-module .

- Run the Docker container:

docker run -d -p 8080:8080 uber-pricing-module

## API Documentation

### Endpoints

1. Create Pricing Configuration

- Endpoint: /api/pricing/add
- Method: POST
- Description: Adds a new pricing configuration.
- Request Body:

{
  "dayOfWeek": "Saturday",
  "basePrice": 220,
  "additionalPricePerKm": 5,
  "timeMultiplier": 5,
  "waitingChargePerMinute": 10,
  "isActive": true
}

2. Create Ride

- Endpoint: /api/ride/add
- Method: POST
- Description: Creates a new ride and calculates the price based on the active pricing configuration.
- Request Body:
{
  "distanceKm": 10,
  "timeHours": 0.5,
  "waitingMinutes": 5
}

## Troubleshooting
- 500 Internal Server Error: Ensure that there is at least one active pricing configuration in the database. If not, add one via the /api/pricing/add endpoint.

- Database Connection Issues: Double-check the application.properties file to ensure the correct database credentials are provided.






