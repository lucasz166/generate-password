package com.lucasgabriel.senhas.controller;

import com.lucasgabriel.senhas.resource.EmailMessage;
import com.lucasgabriel.senhas.service.EmailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/enviar-email")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage) {
        this.emailSenderService.sendEmail(emailMessage.getTo(),
                                          emailMessage.getSubject(),
                                          emailMessage.getMessage());
        return ResponseEntity.ok("Email enviado com sucesso");
    }
}
