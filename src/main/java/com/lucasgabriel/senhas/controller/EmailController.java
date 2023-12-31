package com.lucasgabriel.senhas.controller;

import com.lucasgabriel.senhas.resource.EmailMessage;
import com.lucasgabriel.senhas.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private  EmailSenderService emailSenderService;

    @PostMapping("/enviar-email")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage) {
        this.emailSenderService.sendEmail(emailMessage.getTo(),
                                          emailMessage.getSubject(),
                                          emailMessage.getMessage());
        return ResponseEntity.ok("Email enviado com sucesso");
    }
}
