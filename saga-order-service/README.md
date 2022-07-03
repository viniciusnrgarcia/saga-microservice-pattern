# Saga Order Service
Order Service é um microsserviço responsável pelo domínio ORDER, recebe requisições, atualizações, controlando o estado, assim como a gerações de eventos sobre as operações realizadas.

## Instalação

```shell
# build dos artefatos
mvn clean install 

# build images
sh docker-build-images.sh

# inicializa o ambiente
docker-compose -f docker-compose.yml up -d


```

## Utilização

```shell

# executa as requisições de novos eventos do tipo ORDER
curl --location --request POST 'localhost:8080/order' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--header 'Cookie: JSESSIONID=8142D1D608B05A91BA9B6DA72736FD93' \
--data-raw '{
    "orderType": 1,
    "orderState": 1,
    "orderDescription": "SALE",
    "orderValue": 48.63,
    "productId": "494d5576-c782-4d67-8b2b-0e7917066f7c",
    "productItems": 2,
    "productDescription": "Gorgeous Metal Pizza",
    "customerId": "1f491df7-fb14-4d38-8454-c382f946df22"
}'
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

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
https://docs.spring.io/spring-amqp/docs/current/reference/html/#spring-rabbit-json
http://tryrabbitmq.com/
https://www.baeldung.com/spring-amqp
https://www.javainuse.com/messaging/rabbitmq/exchange