## Calculator API and Calculator Application with Java Microservices

### Overview

This repository contains Java-based microservices, including a `calculator-api` deployed in a Docker container, facilitating communication with a calculator application. Additionally, an automation testing suite using Java and Docker is implemented, deployed in Kubernetes, and communicates through an Ingress Controller.

#### Features

- **Calculator API:**
  - Hosted in a Docker container.
  - Provides endpoints for mathematical calculations.
  
- **Calculator Application:**
  - Communicates with the `calculator-api` for calculations.
  
- **Automated Testing Suite:**
  - Utilizes Java-based testing frameworks in a Dockerized environment.
  - Deployed on Kubernetes with Ingress Controller for testing communication.

#### Technologies Used

- **Spring Boot:** Framework for building Java-based microservices.
- **Docker:** Containerization of `calculator-api` and testing suite.
- **Kubernetes:** Deployment of Docker containers and orchestration.
- **Ingress Controller:** Facilitates communication within Kubernetes.

## Testing

- Execute automated tests by running the testing suite deployed in Kubernetes.
