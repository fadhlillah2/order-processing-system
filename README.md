# MyMiniProjectRestAPI

This is a Spring Boot REST API application for managing orders, products and customers.

## Prerequisites

To run this project, you need the following tools:

- Java Development Kit (JDK) 8 or later
- Maven 3.6 or later
- A SQL Database (e.g., MySQL, PostgreSQL)

## Features

The API provides the following features:

- Managing customers, products, and orders.
- Many-To-Many relationship between orders and products.
- One-To-Many relationship between customers and orders.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

1. Clone the project to your local machine.

```bash
git clone https://github.com/yourusername/MyMiniProjectRestAPI.git
```

2. Navigate into the project directory.

```bash
cd MyMiniProjectRestAPI
```

3. Build the project.

```bash
mvn clean install
```

4. Run the project.

```bash

mvn spring-boot:run
```

Now, your service should be up and running at `http://localhost:8080`.

## API Endpoints

Here are some of the API endpoints that are available:

- `GET /api/customers`: Retrieves all customers
- `POST /api/customers`: Creates a new customer
- `GET /api/customers/{customerId}`: Retrieves a specific customer
- `PUT /api/customers/{customerId}`: Updates a specific customer
- `DELETE /api/customers/{customerId}`: Deletes a specific customer

This pattern is followed for the `products` and `orders` endpoints as well.

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
