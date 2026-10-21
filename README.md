# Payment Tracker

Payment Tracker is a personal project I developed to improve my skills in Java, Spring Boot, and backend development.

The goal of this application is to manage payments, track expenses, and perform calculations using a REST API.

## Technologies

- Java
- Spring Boot
- Spring Data JPA / Hibernate
- MySQL
- Maven
- REST API

## Features

The application currently includes:

- Add new payments
- View all payments
- Find a payment by ID
- Update existing payments
- Delete payments
- Calculate the total amount of payments
- Count the number of payments
- Check if a payment already exists
- Find payments above or below a specified amount
- Find the highest and lowest payment amounts
- Calculate the average payment amount
- Search payments by title
- Validate payment titles and amounts

## Project Structure

The backend is organized into different layers:

- Controller: handles HTTP requests and REST endpoints
- Service: contains business logic, validations, and calculations
- Repository: manages database operations using Spring Data JPA
- Entity: represents the payment data stored in the database

## Database

The application uses MySQL to store payment information.

Each payment contains:

- ID
- Title
- Amount

## Project Status

This project is part of my learning journey in Java backend development. I am continuing to improve my coding skills and deepen my understanding of Spring Boot, REST APIs, and database management.
