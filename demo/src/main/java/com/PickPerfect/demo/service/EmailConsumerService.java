package com.PickPerfect.demo.service;

import javax.mail.MessagingException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PickPerfect.demo.config.RabbitConfig;
import com.PickPerfect.demo.model.EmailRequest;

@Service
public class EmailConsumerService {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = RabbitConfig.RABBITMQ_HK_TOPIC)
    public void receiveEmailRequest(EmailRequest emailRequest)
            throws MessagingException, javax.mail.MessagingException, jakarta.mail.MessagingException {
        System.out.println("Received email request from queue: " + emailRequest);

        // Send the email using the email service
        emailService.sendEmail(emailRequest.getEmail(), "Your PickPerfect Response", emailRequest.getResponse());
    }
}
