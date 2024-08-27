package com.PickPerfect.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.PickPerfect.demo.config.OpenAIConfig;

import java.util.Base64;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    @Autowired
    OpenAIConfig openAIConfig;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "question", required = false) String question) {
        try {
            String apiUrl = "https://api.openai.com/v1/chat/completions"; // From ChatGPT Vision API

            StringBuilder contentBuilder = new StringBuilder();
            if (question != null && !question.isEmpty()) {
                contentBuilder.append("{\"type\":\"text\",\"text\":\"").append(question).append("\"},");
            }
            if (file != null) {
                String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
                contentBuilder.append("{\"type\":\"image_url\",\"image_url\":{\"url\":\"data:image/jpeg;base64,")
                        .append(base64Image).append("\", \"detail\":\"low\"}}");
            }

            String payload = "{"
                    + "\"model\":\"gpt-4o-mini\","
                    + "\"messages\":["
                    + "{"
                    + "\"role\":\"user\","
                    + "\"content\":["
                    + "{\"type\":\"text\",\"text\":\"Identify the fruit or vegetable in this image and tell me how to pick a good one. If the image contains multiple fruits, analyze the image to suggest which one is the best pick. If the image is not a fruit or vegetable, respond with the format: {\\\"valid\\\":false}. If it is valid, respond in the following format: {\\\"valid\\\":true, \\\"name\\\":\\\"name\\\", \\\"how_to_pick\\\": [\\\"instruction1\\\", \\\"instruction2\\\", ...], \\\"best_pick\\\":\\\"description\\\"}\"},"
                    + contentBuilder.toString()
                    + "]"
                    + "}"
                    + "],"
                    + "\"max_tokens\":300"
                    + "}";

            // Prepare headers
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + openAIConfig.getOpenaiApiKey());
            headers.add("Content-Type", "application/json");

            HttpEntity<String> entity = new HttpEntity<>(payload, headers);

            // Send the request to OpenAI API
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);

            // return the response
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error uploading file: " + e.getMessage());
        }
    }
}
