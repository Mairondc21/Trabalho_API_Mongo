package com.example.clima.controller;

import com.example.clima.model.ClimaEntity;
import com.example.clima.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clima")
public class ClimaController {
    @Autowired
    private ClimaService climaService;

    @GetMapping
    public String preverTempo() {
        return climaService.preverTempo();
    }
    @PostMapping
    public ClimaEntity inserir(@RequestBody ClimaEntity user) { return climaService.inserir(user);}
}
