# SPRING CLOUD STREAM AND KAFKA
Sample project using [Spring Cloud Stream](https://cloud.spring.io/spring-cloud-stream/) with 
[Kafka](https://kafka.apache.org). It consists in a message producer, that generates a message when a get petition is
made, and a consumer, that log the received message.

To run this project you need to run start Kafka, following [this instructions](https://kafka.apache.org/quickstart), 
and run the next commands:

```bash
# Start the producer
cd producer
mvn clean spring-boot:run

# Start the consumer
cd receiver
mvn clean spring-boot:run
```

Once started, a GET petition will be needed to generate a message. An petition
example is:

```http request
http://localhost:8080/send?message=hello
```