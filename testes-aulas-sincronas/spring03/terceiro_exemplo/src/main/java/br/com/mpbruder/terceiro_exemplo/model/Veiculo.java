package br.com.mpbruder.terceiro_exemplo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String placa;
    private String modelo;
    private int ano;
    private double valor;
    private int id_proprietario;
}
