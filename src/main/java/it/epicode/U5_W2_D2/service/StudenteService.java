package it.epicode.U5_W2_D2.service;

import it.epicode.U5_W2_D2.exception.StudenteNotFoundException;
import it.epicode.U5_W2_D2.model.Studente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
//è un'annotazione che deriva da @Component e quindi è gestita automaticamente da Spring
public class StudenteService {

    private List<Studente> studenti = new ArrayList<>();

    //questo metodo andrà a creare un nuovo studente nella lista, in base ai dati dello studente
    //ricevuto dal client
    public Studente saveStudente(Studente studente) {
        studente.setMatricola(new Random().nextInt(1, 2000));
        studenti.add(studente);
        return studente;
    }

    public Studente getStudente(int matricola) throws StudenteNotFoundException {

        return studenti.stream()
                .filter(studente -> studente.getMatricola()==matricola)
                .findFirst().orElseThrow(() -> new StudenteNotFoundException("Non esiste uno studente con la matricola: " + matricola));
    }

    public List<Studente> getAllStudenti() {
        return studenti;
    }

    public Studente updateStudente(int matricola, Studente studente) throws StudenteNotFoundException {

        Studente studenteDaCercare = getStudente(matricola);
        studenteDaCercare.setNome(studente.getNome());
        studenteDaCercare.setCognome(studente.getCognome());
        studenteDaCercare.setDataNascita(studente.getDataNascita());

        return studenteDaCercare;
    }

    public void deleteStudente(int matricola) throws StudenteNotFoundException {
        Studente studenteDaRimuovere = getStudente(matricola);

        studenti.remove(studenteDaRimuovere);
    }
}
