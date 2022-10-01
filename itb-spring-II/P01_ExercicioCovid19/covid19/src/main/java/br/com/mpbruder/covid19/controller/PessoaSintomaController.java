package br.com.mpbruder.covid19.controller;

import br.com.mpbruder.covid19.dto.PessoaSintomasDto;
import br.com.mpbruder.covid19.model.Pessoa;
import br.com.mpbruder.covid19.model.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("findRiskPerson")
public class PessoaSintomaController {

    private final List<Sintoma> sintomas = new ArrayList<>();

    private final List<PessoaSintomasDto> pessoasSintomas = new ArrayList<>();

    public PessoaSintomaController() {
        // Gerando sintomas
        sintomas.add(new Sintoma(1, "Febre", "Emergência"));
        sintomas.add(new Sintoma(2, "Cansaço", "Emergência"));
        sintomas.add(new Sintoma(3, "Tosse", "Urgente"));
        sintomas.add(new Sintoma(4, "Perda paladar", "Pouco urgente"));
        sintomas.add(new Sintoma(5, "Perda olfato", "Pouco urgente"));

        // Gerando pessoas
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa(1, "Matheus", "Bruder", 23));
        pessoas.add(new Pessoa(2, "Luan", "Silveira", 20));
        pessoas.add(new Pessoa(3, "Kaio", "Kyto", 71));
        pessoas.add(new Pessoa(4, "Abreu", "Mathias", 79));
        pessoas.add(new Pessoa(5, "José", "Bastião", 84));
        pessoas.add(new Pessoa(6, "Mariana", "Nolasco", 80));
        pessoas.add(new Pessoa(7, "Jéssica", "Império", 40));
        pessoas.add(new Pessoa(8, "Bruna", "Guerreiro", 60));
        pessoas.add(new Pessoa(9, "Juliana", "Marinho", 69));
        pessoas.add(new Pessoa(10, "Gabriela", "Blumenau", 50));

        // Gerando pessoas com sintomas (DTO)
        pessoasSintomas.add(new PessoaSintomasDto(pessoas.get(0), getRandomSymptons(0, 3)));
        pessoasSintomas.add(new PessoaSintomasDto(pessoas.get(1), getRandomSymptons(2, 5)));
        pessoasSintomas.add(new PessoaSintomasDto(pessoas.get(2), getRandomSymptons(3, 5)));
        pessoasSintomas.add(new PessoaSintomasDto(pessoas.get(3), getRandomSymptons(0, 6)));
        pessoasSintomas.add(new PessoaSintomasDto(pessoas.get(4), getRandomSymptons(4, 6)));
        pessoasSintomas.add(new PessoaSintomasDto(pessoas.get(5), getRandomSymptons(2, 5)));
        pessoasSintomas.add(new PessoaSintomasDto(pessoas.get(6), getRandomSymptons(1, 5)));
        pessoasSintomas.add(new PessoaSintomasDto(pessoas.get(7), getRandomSymptons(3, 6)));
        pessoasSintomas.add(new PessoaSintomasDto(pessoas.get(8), getRandomSymptons(1, 5)));
        pessoasSintomas.add(new PessoaSintomasDto(pessoas.get(9), getRandomSymptons(0, 1)));

    }

    @GetMapping
    public ResponseEntity<List<PessoaSintomasDto>> getRiskPersonSymptons() {

        if(pessoasSintomas.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<PessoaSintomasDto> pessoasRisco = pessoasSintomas.stream()
                .filter(p -> p.getIdade() >= 60)
                .toList();
        return new ResponseEntity<>(pessoasRisco, HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<PessoaSintomasDto>> getAllPersonSymptons() {
        return new ResponseEntity<>(pessoasSintomas, HttpStatus.OK);
    }

    private List<Sintoma> getRandomSymptons(int i, int j) {
        Random random = new Random();
        int fromIndex = random.nextInt(i, j);
        int toIndex = random.nextInt(i, j);

        if (fromIndex > toIndex) {
            return sintomas.subList(toIndex, fromIndex);
        } else {
            if (fromIndex == toIndex) {
                return sintomas.subList(fromIndex, toIndex + 1);
            } else {
                return sintomas.subList(fromIndex, toIndex);
            }
        }
    }
}
