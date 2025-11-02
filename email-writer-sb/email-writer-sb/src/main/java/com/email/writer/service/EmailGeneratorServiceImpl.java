package com.email.writer.service;

import com.email.writer.dto.EmailRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailGeneratorServiceImpl implements EmailGenerator{

    private final WebClient webClient;
    @Value("${gemini.api.url}")
    private String geminiApi;
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public EmailGeneratorServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public String generateEmailReply(EmailRequest emailRequest) {
             // String Prompt
        String prompt=buildPrompt(emailRequest);

        //Craft a request
        Map<String,Object> requestBody= Map.of("contents",new Object[]{
                Map.of("parts",new Object[]{
                    Map.of("text",prompt)
                })
        });
        //Do request and get response
        String response = webClient.post()
                .uri(geminiApi) // ✅ Only the base URL
                .header("Content-Type", "application/json")
                .header("X-goog-api-key", geminiApiKey) // ✅ Send key here
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

              //return response
        return extractResponseContent(response);
    }

    private String extractResponseContent(String response) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
            return rootNode.path("candidates").get(0).path("content").path("parts").get(0).path("text").asText();
        }
        catch(Exception e){
            return "Error Processing Request"+e.getMessage();
        }
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt =  new StringBuilder();
        prompt.append("Generate the professional email reply for the following email content.Please don't generate the subject line ");
        if(emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()){
            prompt.append("Use a").append(emailRequest.getTone()).append("tone");
        }
        prompt.append("\n Original email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }
}
