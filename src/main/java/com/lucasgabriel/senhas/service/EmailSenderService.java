package com.lucasgabriel.senhas.service;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String message);
}
