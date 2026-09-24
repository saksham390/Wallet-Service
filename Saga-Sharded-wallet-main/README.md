# Sharded Saga Wallet Service

A **Spring Boot–based Wallet Service** implementing **Saga Orchestration** for distributed transactions and **database sharding** using **Apache ShardingSphere**.  
The system is designed to handle high-concurrency wallet operations with consistency guarantees.

---

## 🚀 Features

- **Saga Orchestration Pattern**
  - Ensures data consistency across wallet and transaction operations
  - Handles compensating transactions on failure

- **Database Sharding (Horizontal)**
  - Implemented using **Apache ShardingSphere JDBC**
  - Data distributed across multiple MySQL databases
  - Sharding based on `user_id` / `id`

- **Spring Boot + JPA**
  - Clean layered architecture (Controller → Service → Repository)
  - Hibernate ORM for persistence

- **Dockerized Local Setup**
  - Multi-MySQL shard setup using Docker Compose
  - Easy local testing of sharding behavior

---

## 🧱 Tech Stack

- **Java 21**
- **Spring Boot 3.5.x**
- **Spring Data JPA**
- **Apache ShardingSphere 5.5.x**
- **MySQL 8**
- **Docker & Docker Compose**
- **HikariCP**
- **Hibernate ORM**

---

## 🗂️ Architecture Overview

```text
Client
  ↓
Wallet Service (Spring Boot)
  ↓
Saga Orchestrator
  ↓
ShardingSphere JDBC
  ↓
┌───────────────┐   ┌───────────────┐
│ MySQL Shard 1 │   │ MySQL Shard 2 │
│ shardWallet1  │   │ shardWallet2  │
└───────────────┘   └───────────────┘
```
## API-ENDPOINTS
<img width="1837" height="893" alt="image" src="https://github.com/user-attachments/assets/303da27e-4f39-46b7-85ef-0a05b2395326" />
