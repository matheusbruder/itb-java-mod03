package br.com.mpbruder.codigo_morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/traducao")
public class TraducaoCodigoMorse {

    @GetMapping("morse/{morseCode}")
    public String morseToPortuguese(@PathVariable String morseCode) {
        return convertMorseToPortuguese(morseCode);
    }

    private String convertMorseToPortuguese(String morseCode) {

        StringBuilder textConverted = new StringBuilder();

        String[] code
                = {".-", "-...", "-.-.", "-..", ".",
                "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---",
                ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--",
                "--..", "|" };

        String[] morseCodeArray = morseCode.split(" ");

        for (String s : morseCodeArray) {
            for (int j = 0; j < code.length; j++) {
                if (s.compareTo(code[j]) == 0) {
                    textConverted.append((char) (j + 'a'));
                    break;
                }
            }
        }

        return textConverted.toString().toUpperCase();
    }

}
