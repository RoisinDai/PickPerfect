package com.PickPerfect.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, String jsonBody) throws MessagingException {
        // Parse the JSON and construct the HTML content
        String htmlBody = convertJsonToHtml(jsonBody);

        // Create a MimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("pickperfectproject@gmail.com");
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(htmlBody, true); // true indicates the body is HTML

        // Send the email
        mailSender.send(message);
        System.out.println("Mail Sent...");
    }

    private String convertJsonToHtml(String jsonBody) {
        StringBuilder html = new StringBuilder();

        try {
            // Parse the JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonBody);

            // Extract fields from the JSON
            String name = rootNode.path("name").asText();
            JsonNode howToPickNode = rootNode.path("how_to_pick");

            // Construct the HTML content
            html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
            html.append("<p><strong>How to Pick:</strong></p>");
            html.append("<ul>");

            for (JsonNode item : howToPickNode) {
                html.append("<li>").append(item.asText()).append("</li>");
            }

            html.append("</ul>");
            html.append("<p><strong>Best Pick:</strong> ").append(rootNode.path("best_pick").asText()).append("</p>");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return html.toString();
    }
}
