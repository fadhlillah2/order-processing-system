# Mini Project Rest Api

This is a Spring Boot REST API application for managing orders, products and customers.

## Prerequisites

To run this project, you need the following tools:

- Java Development Kit (JDK) 8 or later
- Maven 3.6 or later
- A SQL Database (e.g., MySQL, PostgreSQL) (recommended using Docker)

## Features

The API provides the following features:

- Managing customers, products, and orders.
- Many-To-Many relationship between orders and products.
- One-To-Many relationship between customers and orders.
- Order flow
- Handling failed scenario when order process

## System Architecture
This application uses a layered architecture pattern, consisting of:

- Controller Layer: The entry point of the application, where the incoming HTTP requests are handled.
- Service Layer: Contains business logic and calls methods from the repository layer.
- Repository Layer: Responsible for data access logic, communicates directly with the database.
- Model (Entity) Layer: Maps directly to the database tables, includes relationships between tables.
    <img width="468" alt="image" src="https://github.com/fadhlillah2/order-processing-system/assets/73236007/d2b099b3-5c11-40e8-b456-e1d2e2ae85bb">

- DTO (Data Transfer Object): A simple object that carries data between processes. It's like a carrier pigeon—it doesn't do much processing itself, but it helps move data from one place to another, often from the server to the client.
- Exception: Your application's way of saying "something went wrong" and providing information about the problem. This could be anything from a database connection failing to a user entering invalid data

The application uses Spring Data JPA for the Repository layer which provides a way to reduce boilerplate code to implement data access layers for various persistence stores.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

1. Clone the project to your local machine.

```bash
git clone https://github.com/fadhlillah2/order-processing-system.git
```

2. Navigate into the project directory.

```bash
cd mini-project-rest-api
```

3. Running the database (if using docker)

```bash
docker compose up
```

4. Build the project.

```bash
mvn clean install
```

5. Run the project.

```bash

mvn spring-boot:run
```

Now, your service should be up and running at `http://localhost:8080`.

## API Endpoints

Here are some of the API endpoints that are available:

- `POST /api/v1/customers`: Creates a new customer
- `GET /api/v1/customers/{customerId}`: Retrieves a specific customer
- `PUT /api/v1/customers/{customerId}`: Updates a specific customer
- `POST /api/v1/products`: Creates a new product
- `GET /api/v1/products/{productId}`: Retrieves a specific product
- `PUT /api/v1/products/{productId}`: Updates a specific product
- `POST /api/v1/orders`: Creates a new order
- `GET /api/v1/orders/{orderId}`: Retrieves a specific order

For further information, you can check the API documentation: https://documenter.getpostman.com/view/13737145/2s93si1VE8


## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [Maven](https://maven.apache.org/) - Dependency Management
- [JPA](https://spring.io/projects/spring-data-jpa) - Java Persistence API for database operations
- [Hibernate](https://hibernate.org/) - ORM for managing relational databases

## Acknowledgments

- The structure of the application is designed to follow best practices and conventions of Spring Boot applications.
- Exceptions are handled globally to provide meaningful error messages to clients.
- Data is validated before being processed to ensure integrity.
- Entities are set up to handle various relationships (One-To-Many, Many-To-Many).

Please refer to the API documentation for more detailed information about the available endpoints, request formats, and responses.

For any additional questions or suggestions, please feel free to contribute to this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
