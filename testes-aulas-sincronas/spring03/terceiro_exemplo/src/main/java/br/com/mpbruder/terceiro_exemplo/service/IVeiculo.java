package br.com.mpbruder.terceiro_exemplo.service;

import br.com.mpbruder.terceiro_exemplo.exception.NotFoundException;
import br.com.mpbruder.terceiro_exemplo.model.Veiculo;

import java.util.List;

public interface IVeiculo {

    Veiculo getVeiculo(String placa) throws NotFoundException;
    List<Veiculo> getAllVeiculo() throws NotFoundException;
    List<Veiculo> getAllOrderByValue() throws NotFoundException;

    void addVeiculo(Veiculo veiculo);

    List<Veiculo> getVeiculoByModelo(String modelo);
}
