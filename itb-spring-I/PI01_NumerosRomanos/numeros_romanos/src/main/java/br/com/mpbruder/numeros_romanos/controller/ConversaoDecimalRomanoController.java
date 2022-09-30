package br.com.mpbruder.numeros_romanos.controller;

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

    @GetMapping("/decimal-romano/{integer}")
    public String resultado(@PathVariable int integer) {
        String roman = intToRoman(integer);
        return integer + " → " + roman;
    }

    public String intToRoman(int numero) {
        String[] thousands = {"", "M", "MM", "MMM" };
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        return thousands[numero / 1000] + hundreds[(numero % 1000) / 100] + tens[(numero % 100) / 10] + units[numero % 10];
    }


}
