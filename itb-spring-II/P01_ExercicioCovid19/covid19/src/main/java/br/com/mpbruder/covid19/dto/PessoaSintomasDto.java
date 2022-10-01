package br.com.mpbruder.covid19.dto;

import br.com.mpbruder.covid19.model.Pessoa;
import br.com.mpbruder.covid19.model.Sintoma;
import lombok.Data;

import java.util.List;

@Data
public class PessoaSintomasDto {
    private String nome;
    private String sobrenome;
    private int idade;
    private List<Sintoma> sintomas;

    public PessoaSintomasDto(Pessoa pessoa, List<Sintoma> sintomas) {
        this.nome = pessoa.getNome();
        this.sobrenome = pessoa.getSobrenome();
        this.idade = pessoa.getIdade();
        this.sintomas = sintomas;
    }
}
