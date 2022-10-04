package br.com.mpbruder.terceiro_exemplo.service;

import br.com.mpbruder.terceiro_exemplo.model.Proprietario;
import br.com.mpbruder.terceiro_exemplo.model.Veiculo;
import br.com.mpbruder.terceiro_exemplo.repository.ProprietarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProprietarioService implements IProprietario {

    @Autowired
    private VeiculoService veiculoService;
    @Autowired
    private ProprietarioRepo proprietarioRepo;

    @Override
    public List<Proprietario> getAllProprietarios() {
        List<Veiculo> veiculoList = new ArrayList<>(veiculoService.getAllVeiculo());
        List<Proprietario> proprietarioList = new ArrayList<>(proprietarioRepo.getAllProprietario());

        proprietarioList.forEach(proprietario -> {
            for (Veiculo veiculo : veiculoList) {
                if (veiculo.getId_proprietario() == proprietario.getId()) {
                    proprietario.addVeiculo(veiculo);
                }
            }
        });
        return proprietarioList;
    }
}