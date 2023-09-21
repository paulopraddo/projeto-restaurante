package com.paulo.praddo.projeto_hamburgueria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping
    public ResponseEntity paginaInicial() {
        return ResponseEntity.ok().build();
    }
}