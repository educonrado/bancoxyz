/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.cuentasmovimientos.microservice.comunication;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class Consumer {

    private static final Logger log = Logger.getLogger(Consumer.class.getName());
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void recibirDatos(@Payload String mensaje) {
        log.info("Mensaje recibido: " + mensaje);
    }
}
