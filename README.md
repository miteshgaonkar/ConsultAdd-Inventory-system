# Inventory Management System

## Overview

The Inventory Management System is a RESTful API built using Spring Boot that allows users to manage inventory items, including creating, updating, retrieving, and deleting items. The system is designed to be scalable, secure, and efficient.

## Features

- Create new inventory items
- Retrieve item details by ID
- Retrieve all inventory items
- Update existing items
- Delete items from the inventory
- Exception handling for better error management

## Tech Stack

| Technology | Description |
|------------|-------------|
| Java | Backend Language |
| Spring Boot | Framework for microservices |
| Spring Data JPA | ORM for database operations |
| MySQL | Database |
| Maven | Dependency management |

## Installation & Setup

### Prerequisites

Make sure you have the following installed:

- Java 11+

- Maven 3+

- MySQL 

### Clone the Repository

```yaml
git clone https://github.com/yourusername/ConsultAdd-Inventory-system.git
cd system
```

### Configure Database

Update `application.properties` in `src/main/resources/` for MySQL:

```yaml
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/inventory
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Build & Run the Application

```yaml
 mvn clean install
 mvn spring-boot:run
```

The application will start on [http://localhost:8000](http://localhost:8080).

## API Documentation

### Get All Items

`GET /api/items`

#### Response:

```yaml
[
 {
    "id": 1,
    "name": "Laptop",
    "quantity": 10,
    "price": 50000,
    "description": "High-performance laptop"
  },
  {
    "id": 2,
    "name": "Monitor",
    "quantity": 5,
    "price": 15000,
    "description": "24-inch LED Monitor"
  }
]
```

### Get Item by ID

`GET /api/items/{id}`

#### Response:

```yaml
{
  "id": 1,
  "name": "Laptop",
  "quantity": 10,
  "price": 50000,
  "description": "High-performance laptop"
}
```

### Create a New Item

`POST /api/items`

#### Request Body:

```yaml
{
  "name": "Monitor",
  "quantity": 5,
  "price": 15000,
  "description": "24-inch LED Monitor"
}
```

#### Response:
```yaml
{
  "id": 2,
  "name": "Monitor",
  "quantity": 5,
  "price": 15000,
  "description": "24-inch LED Monitor"
}
```

### Update an Item

`PUT /api/items/{id}`

#### Request Body:
```yaml
{
  "name": "Gaming Laptop",
  "quantity": 8,
  "price": 70000,
  "description": "High-performance gaming laptop"
}
```
#### Response:
```yaml
{
  "id": 1,
  "name": "Gaming Laptop",
  "quantity": 8,
  "price": 70000,
  "description": "High-performance gaming laptop"
}
```
### Delete an Item

`DELETE /api/items/{id}`

#### Response:
```yaml
{
  "message": "Item deleted successfully"
}
```
## Error Handling

Errors are returned in a structured format:
```yaml
{
  "code": 410,
  "message": "Product not found"
}
```
#### Common Error Codes:

- 410: Product not found

- 415: Product out of stock

- 500: Internal Server Error

## Running Tests

To run the test cases, use:
`mvn test`



