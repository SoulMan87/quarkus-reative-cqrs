# Quarkus Reactive CQRS Bank Account

This repository showcases the implementation of a Command Query Responsibility Segregation (CQRS) architecture for a bank account application using Quarkus.

# Features

1. **[Quarkus](https://quarkus.io/):** A cloud-native, Kubernetes-native Java framework.
2. **[Reactive Programming](https://www.reactivemanifesto.org/):** Utilizes reactive programming techniques for improved scalability and responsiveness.
3. **[Docker](https://www.docker.com/) & [Kubernetes](https://kubernetes.io/):** Containerization and orchestration using Docker and Kubernetes for easy deployment and scalability.
4. **[Swagger](https://swagger.io/tools/swagger-ui/):** Interactive API documentation for easy testing and exploration.
5. **[Makefile](https://www.gnu.org/software/make/manual/make.html):** Simplified build and project management with Makefile.
6. **[Kafka](https://kafka.apache.org/uses):** Event sourcing and message queuing with Apache Kafka.
7. **[Grafana](https://grafana.com/) & [Prometheus](https://prometheus.io/):** Monitoring and metrics collection for performance analysis.
8. **[Jaeger](https://www.jaegertracing.io/):** Distributed tracing for improved visibility and debugging.
9. **[MongoDB](https://www.mongodb.com/):** NoSQL database for storing application data.
10. **[Redis](https://redis.io/):** In-memory data store for caching and quick data access.
11. **[ZooKeeper](https://zookeeper.apache.org/):** Distributed coordination service.
12. **[PostgreSQL](https://www.postgresql.org/):** Relational database for data persistence.

## Getting Started

To run this project, follow these steps:

```shell
# Clone the repository
git clone https://github.com/SoulMan87/quarkus-reative-cqrs
# Change to master branch
git checkout master
```

## Build and deploy the application using the provided Makefile
```bash
make build
make deploy
```
## Usage
This application allows you to perform various banking operations, including creating accounts, transferring funds, and retrieving account balances. Refer to the Swagger documentation for detailed information on available endpoints and their usage.

## Contributions
Feel free to contribute to this project by creating issues or submitting pull requests. Your input is highly appreciated!

## License
This project is licensed under the [MIT License](https://opensource.org/license/mit/).

## Contact
If you have any questions or need further assistance, please contact me at jonathanhinestroza87@gmail.com.

## Acknowledgments
Special thanks to the Quarkus community and the maintainers of the libraries and tools used in this project for their invaluable contributions.