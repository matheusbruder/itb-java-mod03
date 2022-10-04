package br.com.mpbruder.terceiro_exemplo.dto;

import br.com.mpbruder.terceiro_exemplo.model.Veiculo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class VeiculoDto implements Serializable {
    private String placa;
    private String modelo;

    public VeiculoDto(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.modelo = veiculo.getModelo();
    }
}
