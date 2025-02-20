package com.bancoxyz.clientepersona.microservice.comunication;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@EnableRabbit
public class ProductorRabbitMQ {

    private static final Logger LOGGER = Logger.getLogger(ProductorRabbitMQ.class.getName());
    private final RabbitTemplate plantillaRabbit;
    private final Queue queue;

    public ProductorRabbitMQ(RabbitTemplate plantillaRabbit, Queue queue) {
        this.plantillaRabbit = plantillaRabbit;
        this.queue = queue;
    }

    public void enviarMensaje(Object mensaje) {
        plantillaRabbit.convertAndSend(queue.getName(), mensaje);
        LOGGER.info("Mensaje enviado: " + mensaje);
    }
}
