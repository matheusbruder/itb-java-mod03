package br.com.mpbruder.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Pessoa {
    private int id;
    private String nome;
    private String sobrenome;
    private int idade;
}
