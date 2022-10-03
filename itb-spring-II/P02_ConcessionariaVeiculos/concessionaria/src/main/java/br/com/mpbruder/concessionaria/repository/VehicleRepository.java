package br.com.mpbruder.concessionaria.repository;

import br.com.mpbruder.concessionaria.VehicleDto;
import br.com.mpbruder.concessionaria.model.Vehicle;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class VehicleRepository {

    private final String linkFile = "src/main/resources/vehicles.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Vehicle saveVehicle(Vehicle vehicle) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        // Adicionar novo veículo
        List<Vehicle> vehicleList = readFile(linkFile);
        vehicleList = new ArrayList<>(vehicleList);
        vehicleList.add(vehicle);

        // Gravar no arquivo
        try {
            writer.writeValue(new File(linkFile), vehicleList);
        } catch (Exception ex) {
            System.out.println("Erro ao gravar arquivo");
        }
        return vehicle;
    }

    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> vehicleList = readFile(linkFile);
        List<VehicleDto> vehicleDtoList = new ArrayList<>();

        for (Vehicle vehicle : vehicleList) {
            vehicleDtoList.add(new VehicleDto(vehicle));
        }
        return vehicleDtoList;
    }

    public List<Vehicle> readFile(String linkFile) {
        List<Vehicle> vehicleList = null;
        try {
            vehicleList = Arrays.asList(objectMapper.readValue(new File(linkFile), Vehicle[].class));
        } catch (IOException ex) {
            // throw new FilesException("Problema leitura do arquivo: '" + linkFile + "'");
            System.out.println("Erro na leitura do arquivo");
        }
        return vehicleList;
    }

}
