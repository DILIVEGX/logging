# Implementing Environment-Specific Logging with Spring Profiles

Objectives
By the end of this project, you should be able to:

- Use Spring Profiles to configure environment-specific settings.
- Implement environment-specific logging configurations.
- Understand the use of logging frameworks like Logback and how to customize logging levels.
- Use logs for monitoring and debugging an application in different environments (e.g., development, testing, production).

---

## Project Setup

### Prerequisites

- Java 24 or higher
- Maven 3.6 or higher
- MySQL server running on port 3306
- An IDE such as IntelliJ IDEA, VSCode, or Eclipse

### Database Setup
- Open your MySQL client and create the database:

```sql
CREATE DATABASE logging;
```
## Running the Application

To run the application:

Open a terminal in the project root folder.
Run:
```
mvn clean spring-boot:run
```
The API will start and listen on: http://localhost:8080

## API Endpoints and Sample Requests

## API Endpoints

| Method | Endpoint       | Description                |
|--------|----------------|----------------------------|
| GET    | /users         | Retrieve all users          |
| POST   | /users         | Create a new user           |
| DELETE | /users/{id}    | Delete a user by their ID   |

Data:
- email
- username
- password

## Profiles

The app supports three profiles: **dev**, **test**, and **prod**. Each profile configures:

- The server port.
- Data source URL (if applicable).
- Logging levels and output destinations.

| Profile | Server Port | Logging Level       | Logging Output              |
|---------|-------------|---------------------|----------------------------|
| dev     | 8081        | DEBUG, INFO         | Console                    |
| test    | 8082        | INFO                | Console                    |
| prod    | 8080        | WARN, ERROR         | File (`logs/app.log`)       |

You activate a profile by setting the Spring Boot active profile:

```bash
spring.profiles.active=prod
```
## Logging Configuration

The project uses Logback with logback-spring.xml for flexible logging setup:

- dev: Logs at DEBUG and INFO levels to the console for easy debugging.
- test: Logs at INFO level to the console.
- prod: Logs WARN and ERROR levels only, output to a log file located in logs/app.log.
This separation helps maintain cleaner logs in production while providing verbose logs during development and testing.

# Where logs are saved

In dev and test, logs appear on the console/stdout.
In prod, logs are saved in the logs/ directory at the project root, file named app.log.