# Spring Boot Controller Advice Example

This project demonstrates how to use `@ControllerAdvice` in a Spring Boot application to globally handle exceptions and provide better exception management.

### Features:
1. **Add User**: POST endpoint to add a new user to an in-memory list.
2. **Get User by ID**: GET endpoint to retrieve a user by their unique ID.
3. **Division**: GET endpoint to divide two numbers, with exception handling for division by zero.
4. **Global Exception Handling**: Handles exceptions globally through `@ControllerAdvice`.

### User Model

Each `User` has the following properties:
- `userId`: The unique identifier of the user (integer).
- `userName`: The name of the user (string).
- `emailId`: The email address of the user (string).

### Endpoints:

#### 1. POST `/user/addUser`
   - **Description**: Adds a new user to the system.
   - **Request Body**:
     ```json
     {
       "userId": 1,
       "userName": "John Doe",
       "emailId": "john.doe@example.com"
     }
     ```
   - **Response**: Returns a list of all users after adding the new one.
   - **HTTP Status**: 201 (Created)
   
#### 2. GET `/user/getUserById/{userId}`
   - **Description**: Retrieves a user by their unique ID.
   - **URL Parameter**: `userId` (positive integer).
   - **Response**: 
     ```json
     {
       "userId": 1,
       "userName": "John Doe",
       "emailId": "john.doe@example.com"
     }
     ```
   - **HTTP Status**:
     - 200 (OK) if the user is found.
     - 404 (Not Found) if the user is not found.
     - If the `userId` is invalid (e.g., 0 or negative), it will throw a `400` error (Bad Request).
   
#### 3. GET `/user/divide/{num1}/{num2}`
   - **Description**: Divides `num1` by `num2`.
   - **URL Parameters**:
     - `num1`: The numerator (integer).
     - `num2`: The denominator (integer).
   - **Response**: The result of the division as a string.
   - **HTTP Status**: 200 (OK).
   - **Exception Handling**: Division by zero will throw an exception, which is handled globally.

### Exception Handling:

- **IllegalArgumentException**: 
   - If an invalid `userId` is passed to the `getUserById` endpoint (e.g., 0 or negative), an HTTP 400 (Bad Request) response will be returned with a custom error message.
- **Global Exception Handling**: 
   - All other unhandled exceptions will be caught by the global exception handler, and a 500 (Internal Server Error) response will be returned with the exception's message.

# Swagger API Documentation:

Once the application is running, you can access the Swagger UI at:
This will display all the available API endpoints, and you can test the endpoints directly from the Swagger UI interface.

### How to Run:

1. Clone this repository.
2. Run the application using your preferred IDE or by executing `mvn spring-boot:run` from the command line.
3. Access the Swagger UI by visiting `http://localhost:8080/swagger-ui/index.html` in your browser.

### Dependencies:
- Spring Boot
- Swagger (for API documentation)

### Notes:
- The `userArrayList` is used to store users temporarily in memory. For production environments, you should replace this with a persistent database solution.

