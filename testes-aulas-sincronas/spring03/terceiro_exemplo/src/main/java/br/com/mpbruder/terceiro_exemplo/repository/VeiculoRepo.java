package br.com.mpbruder.terceiro_exemplo.repository;

import br.com.mpbruder.terceiro_exemplo.model.Veiculo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class VeiculoRepo {

    private final String linkFile = "src/main/resources/veiculos.json";
    private final ObjectMapper objectMapper = new ObjectMapper();


    public Optional<Veiculo> getVeiculo(String placa) {
        List<Veiculo> veiculoList = null;
        try {
            veiculoList = Arrays.asList(objectMapper.readValue(new File(linkFile), Veiculo[].class));
        } catch (Exception ex) {

        }

        for (Veiculo v : veiculoList) {
            if (v.getPlaca().equals(placa)) {
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }
}
