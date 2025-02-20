package com.bancoxyz.clientepersona.microservice.comunication;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionRabbitMQ {

    @Value("${rabbitmq.queue.name}")
    private String cliente;

    @Bean
    public Queue queue() {
        return new Queue(cliente, true);
    }
}
