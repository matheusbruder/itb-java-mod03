package br.com.mpbruder.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Sintoma {
    private int codigo;
    private String nome;
    private String nivelGravidade;
}
