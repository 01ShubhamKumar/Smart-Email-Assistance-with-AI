package com.email.writer.service;

import com.email.writer.dto.EmailRequest;

public interface EmailGenerator {

    public  String generateEmailReply(EmailRequest emailRequest);
}
