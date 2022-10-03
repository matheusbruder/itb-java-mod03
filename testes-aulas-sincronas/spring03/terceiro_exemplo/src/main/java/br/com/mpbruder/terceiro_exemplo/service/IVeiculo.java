package br.com.mpbruder.terceiro_exemplo.service;

import br.com.mpbruder.terceiro_exemplo.exception.VehicleNotFoundException;
import br.com.mpbruder.terceiro_exemplo.model.Veiculo;

import java.util.List;

public interface IVeiculo {

    Veiculo getVeiculo(String placa) throws VehicleNotFoundException;
    List<Veiculo> getAllVeiculo() throws VehicleNotFoundException;

}
