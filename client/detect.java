/* This file is to help github detect that this is a JAVA springboot project. For some reasons its been unable to do so. */

public class Detect {

    public static void main(String[] args) {
        System.out.println("This is a large Java file.");

        // Generate a lot of output or perform a large number of operations
        for (int i = 0; i < 100000; i++) {
            System.out.println("Line " + i + ": This is a filler line to increase the size of this Java file.");
        }

        // Create a large array and fill it with data
        int[] largeArray = new int[1000000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i;
        }

        // Perform complex logic in a large method
        performComplexLogic();

        // Handle a large string
        String largeString = generateLargeString();
        System.out.println("Length of large string: " + largeString.length());

        // More filler code to increase size
        additionalFiller();
    }

    public static void performComplexLogic() {
        // Create large methods with lots of content
        for (int i = 0; i < 100000; i++) {
            System.out.println("Complex logic iteration: " + i);
        }
    }

    public static String generateLargeString() {
        StringBuilder largeString = new StringBuilder(
                "This is a very large string to take up space in this Java file.");
        for (int i = 0; i < 100000; i++) {
            largeString.append(" More text to increase file size.");
        }
        return largeString.toString();
    }

    public static void additionalFiller() {
        // Add more filler content to make the file even larger
        for (int i = 0; i < 100000; i++) {
            System.out.println("Filler code line " + i + ": Adding more lines to increase the size of this file.");
        }

        // More large arrays
        double[] largeDoubleArray = new double[100000];
        for (int i = 0; i < largeDoubleArray.length; i++) {
            largeDoubleArray[i] = i * 0.01;
        }

        // Large nested loops
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                System.out.println("Nested loop iteration: i=" + i + ", j=" + j);
            }
        }
    }
}

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }

// package com.PickPerfect.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.IOException;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// public void sendEmail(String toEmail, String subject, String jsonBody) throws
// MessagingException {
// // Parse the JSON and construct the HTML content
// String htmlBody = convertJsonToHtml(jsonBody);

// // Create a MimeMessage
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(message, true);

// helper.setFrom("pickperfectproject@gmail.com");
// helper.setTo(toEmail);
// helper.setSubject(subject);
// helper.setText(htmlBody, true); // true indicates the body is HTML

// // Send the email
// mailSender.send(message);
// System.out.println("Mail Sent...");
// }

// private String convertJsonToHtml(String jsonBody) {
// StringBuilder html = new StringBuilder();

// try {
// // Parse the JSON
// ObjectMapper objectMapper = new ObjectMapper();
// JsonNode rootNode = objectMapper.readTree(jsonBody);

// // Extract fields from the JSON
// String name = rootNode.path("name").asText();
// JsonNode howToPickNode = rootNode.path("how_to_pick");

// // Construct the HTML content
// html.append("<p><strong>Name:</strong> ").append(name).append("</p>");
// html.append("<p><strong>How to Pick:</strong></p>");
// html.append("<ul>");

// for (JsonNode item : howToPickNode) {
// html.append("<li>").append(item.asText()).append("</li>");
// }

// html.append("</ul>");
// html.append("<p><strong>Best Pick:</strong>
// ").append(rootNode.path("best_pick").asText()).append("</p>");

// } catch (IOException e) {
// e.printStackTrace();
// }

// return html.toString();
// }
// }
