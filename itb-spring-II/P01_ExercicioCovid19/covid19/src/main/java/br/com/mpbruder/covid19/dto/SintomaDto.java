package br.com.mpbruder.covid19.dto;

import br.com.mpbruder.covid19.model.Sintoma;
import lombok.Data;

@Data
public class SintomaDto {
    private String nome;
    private String nivelGravidade;

    public SintomaDto (Sintoma sintoma) {
        this.nome = sintoma.getNome();
        this.nivelGravidade = sintoma.getNivelGravidade();
    }

    public SintomaDto (String nome, String nivelGravidade) {
        this.nome = nome;
        this.nivelGravidade = nivelGravidade;
    }


}
