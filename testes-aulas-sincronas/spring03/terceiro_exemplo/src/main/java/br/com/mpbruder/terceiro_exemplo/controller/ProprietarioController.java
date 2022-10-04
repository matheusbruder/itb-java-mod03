package br.com.mpbruder.terceiro_exemplo.controller;

import br.com.mpbruder.terceiro_exemplo.model.Proprietario;
import br.com.mpbruder.terceiro_exemplo.service.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @Autowired
    private ProprietarioService proprietarioService;

    @GetMapping
    public ResponseEntity<List<Proprietario>> getAllProprietarios() {
        return new ResponseEntity<>(proprietarioService.getAllProprietarios(), HttpStatus.OK);
    }

}
