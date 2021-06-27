# Messaging Application using RabbitMQ - Backend

### RabbitMQ Installation
- Download and Install [Erlang](https://www.erlang.org/downloads) first and then [RabbitMQ](https://www.rabbitmq.com/install-windows.html)
- Install using [Chocolatey](https://community.chocolatey.org/packages/rabbitmq).
> This installs Erlang as well as RabbitMQ.
- Run using [Docker](https://hub.docker.com/_/rabbitmq)
```
docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```
> This image has Erlang as well as RabbitMQ.

### Microservices (User-A & User-B)

- Both the microservices create its own *Topic Exchange* and *Queue*.
- Message can be sent from *User-A* to *User-B* and vice versa.
- The messages are logged in both the microservices to look like a messaging application.
