package br.com.mpbruder.terceiro_exemplo.repository;

import br.com.mpbruder.terceiro_exemplo.model.Proprietario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProprietarioRepo {
    private String linkFile = "src/main/resources/proprietarios.json";

    public List<Proprietario> getAllProprietario() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return Arrays.asList(objectMapper.readValue(new File(linkFile), Proprietario[].class));
        } catch (Exception ex) {
            System.out.println("Erro ao ler o arquivo");
        }
        return null;
    }
}
