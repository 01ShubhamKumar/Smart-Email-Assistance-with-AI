package com.email.writer.controller;

import com.email.writer.dto.EmailRequest;
import com.email.writer.service.EmailGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*")
public class EmailGeneratorController {


 private final EmailGenerator emailGenerator;

    public EmailGeneratorController(EmailGenerator emailGenerator) {
        this.emailGenerator = emailGenerator;
    }


    @PostMapping("/generate")
    public ResponseEntity<String>generateEmail(@RequestBody EmailRequest emailRequest){
        String response= emailGenerator.generateEmailReply(emailRequest);
        return ResponseEntity.ok(response);
    }
}
