# Saga Microservice Pattern

Básico exemplo de arquitetura de microsserviços utilizando o padrão SAGA.

![image1](https://github.com/viniciusnrgarcia/saga-microservice-pattern/blob/main/assets/storming.png)

## Instalação

```shell
# build dos artefatos
mvn clean install 

# build images
sh docker-build-images.sh

# inicializa o ambiente
docker-compose -f docker-compose.yml up -d
```

## License
[MIT](https://choosealicense.com/licenses/mit/)

### Referências

# OpenAPI 3
https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin
https://openapi-generator.tech/docs/plugins/
https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc
https://openapi-generator.tech/docs/generators/spring

### Cloud Events
https://cloudevents.io/
https://cloudevents.github.io/sdk-java/

### RabbitMQ
#### AMQP – Advanced Message Queuing Protocol
https://docs.spring.io/spring-amqp/docs/current/reference/html
https://docs.spring.io/spring-amqp/docs/current/reference/html/#spring-rabbit-json
http://tryrabbitmq.com/
https://www.baeldung.com/spring-amqp
https://www.javainuse.com/messaging/rabbitmq/exchange
