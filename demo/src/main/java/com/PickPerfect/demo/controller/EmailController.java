package com.PickPerfect.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PickPerfect.demo.model.EmailRequest;
import com.PickPerfect.demo.service.EmailQueueService;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailQueueService emailQueueService;

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            // Send the email request to the RabbitMQ queue
            emailQueueService.queueEmail(emailRequest);
            System.out.println("the request is " + emailRequest);
            return ResponseEntity.ok("Email is being processed.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing email: " + e.getMessage());
        }
    }
}
