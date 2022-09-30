package br.com.mpbruder.segundo_exemplo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private int id;
    private String nome;
    private double valor;

//    public Produto(int id, String nome, double valor) {
//        this.id = id;
//        this.nome = nome;
//        this.valor = valor;
//    }

}
