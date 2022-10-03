package br.com.mpbruder.terceiro_exemplo.repository;

import br.com.mpbruder.terceiro_exemplo.exception.FilesException;
import br.com.mpbruder.terceiro_exemplo.model.Veiculo;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class VeiculoRepo {

    private final String linkFile = "src/main/resources/veiculos.json";
    private final ObjectMapper objectMapper = new ObjectMapper();


    public Optional<Veiculo> getVeiculo(String placa) {
        List<Veiculo> veiculoList = readFile(linkFile);
        for (Veiculo v : veiculoList) {
            if (v.getPlaca().equals(placa)) {
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }

    public Optional<List<Veiculo>> getAllVeiculo() {
        List<Veiculo> veiculoList = readFile(linkFile);
        return Optional.of(veiculoList);
    }

    public void addVeiculo(Veiculo veiculo) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        // Adicionar novo veículo
        List<Veiculo> veiculoList = readFile(linkFile);
        veiculoList = new ArrayList<>(veiculoList);
        veiculoList.add(veiculo);

        // Gravar no arquivo
        try {
            writer.writeValue(new File(linkFile), veiculoList);
        } catch (Exception ex) {
            System.out.println("Erro ao gravar arquivo");
        }

    }

    public List<Veiculo> readFile(String linkFile) {
        List<Veiculo> veiculoList;
        try {
            veiculoList = Arrays.asList(objectMapper.readValue(new File(linkFile), Veiculo[].class));
        } catch (IOException ex) {
            throw new FilesException("Problema leitura do arquivo: '" + linkFile + "'");
        }
        return veiculoList;
    }
}
