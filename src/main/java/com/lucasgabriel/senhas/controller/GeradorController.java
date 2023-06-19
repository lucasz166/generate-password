package com.lucasgabriel.senhas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/gerar")
public class GeradorController {

    @GetMapping
    public ResponseEntity<char[]> senha_Forte(@RequestParam int tam) {
        System.out.println("Gerando sua senha aleatoria!!!");
        System.out.println("Sua nova senha é: ");
        String Maiuscula_char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Minuscula_char = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String simbolos = "!@#$%&*<>?";
        String valor = Maiuscula_char + Minuscula_char + numeros + simbolos;

        Random random_metodo = new Random();
        char[] senha = new char[tam];
        for (int i = 0; i < tam; i++) {
            senha[i] = valor.charAt
                    (random_metodo.nextInt(valor.length()));
        }
        return new ResponseEntity<char[]>(senha, HttpStatus.OK);

    }

}
