package br.com.mpbruder.covid19.controller;

import br.com.mpbruder.covid19.dto.SintomaDto;
import br.com.mpbruder.covid19.model.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/findSymptom")
public class SintomasController {

    List<Sintoma> sintomasList = new ArrayList<>();

    public SintomasController() {
        sintomasList.add(new Sintoma(1, "Febre", "Emergência"));
        sintomasList.add(new Sintoma(2, "Cansaço", "Emergência"));
        sintomasList.add(new Sintoma(3, "Tosse", "Urgente"));
        sintomasList.add(new Sintoma(4, "Perda paladar", "Pouco urgente"));
        sintomasList.add(new Sintoma(5, "Perda olfato", "Pouco urgente"));
    }

    @PostMapping
    public ResponseEntity<SintomaDto> newSymptom(@RequestBody SintomaDto sintomaDto) {
        Sintoma sintoma = new Sintoma(sintomasList.size() + 1, sintomaDto.getNome(), sintomaDto.getNivelGravidade());
        sintomasList.add(sintoma);
        return new ResponseEntity<>(sintomaDto, HttpStatus.CREATED);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<String> getSymptom(@PathVariable String nome) {
        Optional<Sintoma> sintoma = sintomasList.stream()
                .filter(s -> s.getNome().equals(nome))
                .findFirst();

        if (sintoma.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            String response = "Nível gravidade: " + sintoma.get().getNivelGravidade();
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<SintomaDto>> getAllSymptons() {
        List<SintomaDto> sintomaDtoList = new ArrayList<>();
        for (Sintoma sintoma : sintomasList) {
            sintomaDtoList.add(new SintomaDto(sintoma));
        }
        return new ResponseEntity<>(sintomaDtoList, HttpStatus.OK);
    }


    public boolean findSymptom(String nome) {
        Optional<Sintoma> sintoma = sintomasList.stream()
                .filter(s -> s.getNome().equals(nome))
                .findFirst();

        return sintoma.isPresent();
    }


}
