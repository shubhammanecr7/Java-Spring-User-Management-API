# Java-Spring-User-Management-API

Welcome to the Java-Spring-User-Management-API repository! This project demonstrates a user management API built with Java Spring, highlighting fundamental concepts of RESTful architecture, CRUD operations, and exception handling.

## Features

- Perform Create, Read, Update, and Delete (CRUD) operations on user entities.
- Utilizes Spring annotations for mapping HTTP methods to controller methods.
- Demonstrates handling of custom exceptions for resource not found scenarios.
- Built-in Spring Data JPA integration for seamless database interaction.

## Getting Started

Follow these steps to set up and run the project locally:

1. Clone the repository using `git clone <repository-url>`.
2. Navigate to the project directory.
3. Ensure you have Java and Maven installed.
4. Run the project using `mvn spring-boot:run`.
5. Access the API documentation at `http://localhost:8080/swagger-ui.html` to explore available endpoints.

## Usage

1. Create a new user: Use a POST request to `/api/users` with user details in the request body.
2. Get user by ID: Use a GET request to `/api/users/{id}` to retrieve user details by ID.
3. Update user: Use a PUT request to `/api/users/{id}` with updated user details in the request body.
4. Delete user: Use a DELETE request to `/api/users/{id}` to remove a user by ID.

---

Feel free to explore the project, learn from the code, and adapt it for your own projects. If you have any questions or feedback, don't hesitate to reach out!
