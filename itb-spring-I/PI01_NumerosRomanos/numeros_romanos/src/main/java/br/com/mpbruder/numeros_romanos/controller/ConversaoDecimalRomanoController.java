package br.com.mpbruder.numeros_romanos.controller;

import br.com.mpbruder.numeros_romanos.exceptions.InvalidDecimalNumberException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversao")
public class ConversaoDecimalRomanoController {

    @GetMapping
    public String conversao() {
        return "Bem-vindo à conversão!";
    }

    @GetMapping("/decimal-romano/{decimal}")
    public String resultado(@PathVariable String decimal) {
        String romano = conversao(decimal);
        return decimal + " → " + romano;
    }

    public String conversao(String numero) {
        int decimal, rom_dec, rom_unit;
        String result;

        String[] rom_dec_array = {"", "X", "XX", "XXX", "XL", "L" };
        String[] rom_unit_array = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

        while (true) {
            try {
                decimal = Integer.parseInt(numero);
                if (decimal > 0 && decimal < 60) {
                    rom_dec = decimal / 10;
                    rom_unit = decimal % 10;
                    result = rom_dec_array[rom_dec] + rom_unit_array[rom_unit];
                    return result;
                } else {
                    throw new InvalidDecimalNumberException("<h4>ERROR!</h4><br>O " + numero + " é um número inválido.");
                }
            } catch (InvalidDecimalNumberException e) {
                return e.getMessage();
            }
        }
    }


}
