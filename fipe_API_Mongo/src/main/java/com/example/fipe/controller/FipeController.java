package com.example.fipe.controller;

import com.example.fipe.model.FipeEntity;
import com.example.fipe.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marcas")
public class FipeController {
    @Autowired
    private FipeService service;

    @GetMapping
    public String consultarMarcas() {
        return service.consultarMarcas();
    }

    @GetMapping("/modelos/{marca}")
    public String consultarModelos(@PathVariable int marca) {
        return service.consultarModelos(marca);
    }

    @GetMapping("/anos/{marca}/{modelo}")
    public String consultarAnos(@PathVariable int marca, @PathVariable int modelo) {
        return service.consultarAno(marca, modelo);
    }

    @GetMapping("/valor/{marca}/{modelo}/{ano}")
    public String consultarAnos(@PathVariable int marca, @PathVariable int modelo, @PathVariable String ano) {
        return service.consultarValor(marca, modelo, ano);
    }

    @PostMapping
    public FipeEntity inserir(@RequestBody FipeEntity user ){return service.inserir(user); }

}
