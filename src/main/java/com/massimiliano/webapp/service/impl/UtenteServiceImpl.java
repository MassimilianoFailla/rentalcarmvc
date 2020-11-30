package com.massimiliano.webapp.service.impl;

import com.massimiliano.webapp.dao.UtenteDao;
import com.massimiliano.webapp.entities.Utente;
import com.massimiliano.webapp.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

    /*Le implementazioni nello strato di servizio sono le medesime di quelle DaoImplement utilizzate nelle servlet
    e si costruiscono allo stesso modo*/

// ma devono avere l'annotazione service e transactional. In caso constrario non funzioneranno

@Service("utenteService")
@Transactional
public class UtenteServiceImpl implements UtenteService {

    // devono avere anche l'annotazione di Autowired
    @Autowired
    private UtenteDao utenteDaoRepository;


    @Override
    public List<Utente> selezionaUtenti() {
        return utenteDaoRepository.selezionaUtenti();
    }

    @Override
    public Utente selezionaById(int id) {
        Utente utente = utenteDaoRepository.selezionaById(id);

        return utente;
    }

    @Override
    public List<Utente> selezionaUtentiByRole(String role) {
        return utenteDaoRepository.selezionaUtentiByRole(role);
    }

    @Override
    public void Salva(Utente utente) {
        utenteDaoRepository.Salva(utente);
    }

    @Override
    public void Aggiorna(Utente utente) {
        utenteDaoRepository.Aggiorna(utente);
    }

    @Override
    public void Elimina(Utente utente) {
        utenteDaoRepository.Elimina(utente);
    }


    @Override
    public Utente validate(String username, String password) {
        return utenteDaoRepository.validate(username, password);
    }

    @Override
    public List<Utente> trovaPerNome(String nome) {

        return utenteDaoRepository.trovaPerNome(nome);
    }

    @Override
    public List<Utente> trovaPerCognome(String cognome) {

        return utenteDaoRepository.trovaPerCognome(cognome);
    }

    @Override
    public Utente trovaPerEmail(String email) {

        return utenteDaoRepository.trovaPerEmail(email);
    }

    @Override
    public List<Utente> trovaPerAnnoNascita(Date annoNascita) {

        return utenteDaoRepository.trovaPerAnnoNascita(annoNascita);
    }

    @Override
    public Utente trovaPerPassword(String password) {

        return utenteDaoRepository.trovaPerPassword(password);
    }

}
