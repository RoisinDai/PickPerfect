package com.PickPerfect.demo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String apiUrl = "https://api.openai.com/v1/images/generations"; // Replace with the actual API URL

            // Prepare the file to be sent
            Map<String, Object> body = new HashMap<>();
            body.put("file", file.getResource());

            // Add headers if needed, such as authorization
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer YOUR_API_KEY");

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

            // Send the file to the external API
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);

            // Return the API response
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error uploading file: " + e.getMessage());
        }
    }
}
