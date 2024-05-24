# spring-with-rabbitmq
 
###  Spring boot 3 with RabbitMQ + Docker

Para subir o RabbitMQ, acesse a pasta docker e execute:  
```sh
./run-docker.sh ou docker compose up
```

Serviço estará disponivel na porta: http://localhost:15672/
```sh
User: guest
senha: guest
```
Coloque os dois microsservices no ar com o comando
```sh
mvn spring-boot:run
```
As Aplicações estarão disponives nas seguintes portas
```sh
porta: 8080 - demo-backend-api 
porta: 9090 - demo-backend-worker
```
