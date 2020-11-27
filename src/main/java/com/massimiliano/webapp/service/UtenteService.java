package com.massimiliano.webapp.service;

import com.massimiliano.webapp.entities.Utente;

import java.util.Date;
import java.util.List;

public interface UtenteService {

    List<Utente> selezionaUtenti();

    Utente selezionaById(String id);

    void Salva(Utente utente);

    void Aggiorna(Utente utente);

    void Elimina(Utente utente);

    boolean validate(String username, String password);


    // metodi da implementare per il filtraggio --------

    public List<Utente> trovaPerNome(String nome);

    public List<Utente> trovaPerCognome(String cognome);

    public Utente trovaPerEmail(String email);

    public List<Utente> trovaPerAnnoNascita(Date annoNascita);

    // -------------------------------------------------

    Utente trovaPerPassword(String password);

}
