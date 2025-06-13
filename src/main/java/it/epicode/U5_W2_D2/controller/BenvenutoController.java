package it.epicode.U5_W2_D2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//discende da @Component, quindi è una classe gestita automaticamente da Spring
public class BenvenutoController {

    @GetMapping("/")
    //endpoint ed è costituito da una coppia metodo http e path, coppia che deve essere unica
    public String benvenuto() {
        return "Benvenuto al nostro primo servizio Rest";
    }

    @GetMapping("/benvenuto")
    //endpoint ed è costituito da una coppia metodo http e path, coppia che deve essere unica
    public String benvenuto2(@RequestParam String nome, @RequestParam String cognome) {
        return "Benvenuto " + nome + cognome + " al nostro primo servizio Rest";
    }

    @GetMapping("/{nome}")
    //le graffe indicano ka parte variabile del path che verrà usata per
    //valorizzare il parametro in ingresso
    public String benvenuto(@PathVariable String nome) {
        //@PathVariable permette di far capire a Spring che il parametro di ingresso del metodo
        //deve recuperarlo dalla parte variabile del path
        return "Benvenuto " + nome + " al nostro primo servizio Rest";
    }
}
