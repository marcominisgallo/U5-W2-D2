package it.epicode.U5_W2_D2.controller;

import it.epicode.U5_W2_D2.exception.StudenteNotFoundException;
import it.epicode.U5_W2_D2.model.Studente;
import it.epicode.U5_W2_D2.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    @PostMapping("/studenti")
    @ResponseStatus(HttpStatus.CREATED)
    public Studente saveStudente(@RequestBody Studente studente){
        return studenteService.saveStudente(studente);
    }

    @GetMapping("/studenti/{matricola}")
    public Studente getStudente(@PathVariable int matricola)throws StudenteNotFoundException {
        return studenteService.getStudente(matricola);
    }

    @GetMapping("/studenti")
    public List<Studente> getAllStudenti() {
        return studenteService.getAllStudenti();
    }

    @PutMapping("/studenti/{matricola}")
    public Studente updateStudente(@PathVariable int matricola, @RequestBody Studente studente) throws StudenteNotFoundException {
        return studenteService.updateStudente(matricola, studente);
    }

    @DeleteMapping("/studenti/{matricola}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudente(int matricola) throws StudenteNotFoundException {
        studenteService.deleteStudente(matricola);
    }
}
