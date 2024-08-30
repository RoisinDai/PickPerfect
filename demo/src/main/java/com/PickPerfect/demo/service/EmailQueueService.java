package com.PickPerfect.demo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PickPerfect.demo.config.RabbitConfig;
import com.PickPerfect.demo.model.EmailRequest;

@Service
public class EmailQueueService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void queueEmail(EmailRequest emailRequest) {
        // Send the email request to the RabbitMQ queue
        rabbitTemplate.convertAndSend(RabbitConfig.HK_EXCHANGE, RabbitConfig.RABBITMQ_DIRECT_ROUTING, emailRequest);
    }
}
