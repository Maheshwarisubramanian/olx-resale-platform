package com.olx.resale.app.service.impl;

import com.olx.resale.app.service.EmailService;
import com.sendgrid.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
    @Value("${sendgrid.api.key}")
    private String apiKey;

    @Async
    @Override
    public void sendMail(String mailTo, String subject, String body) {
        log.info("Attempting to sedn an email to "+mailTo);
        Email from = new Email("ajayshindedsa@gmail.com");
        Email to = new Email(mailTo);
        Content content = new Content("text/html", body);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sendGrid = new SendGrid(apiKey);
        try {
            Request request = new Request();
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            log.info("Sending email with subject : "+subject);
            sendGrid.api(request);
            log.info("email successfully sent to : "+mailTo);
        } catch (Exception e) {
            log.info("Error sending email: "+e.getMessage());
            System.out.println(e);
        }
    }
}
