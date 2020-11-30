package com.massimiliano.webapp.service;

import com.massimiliano.webapp.entities.Utente;

import java.util.Date;
import java.util.List;

public interface UtenteService {

    List<Utente> selezionaUtenti();

    Utente selezionaById(int id);

    List<Utente> selezionaUtentiByRole(String role);

    void Salva(Utente utente);

    void Aggiorna(Utente utente);

    void Elimina(Utente utente);

    Utente validate(String username, String password);


    // metodi da implementare per il filtraggio --------

     List<Utente> trovaPerNome(String nome);

     List<Utente> trovaPerCognome(String cognome);

     Utente trovaPerEmail(String email);

     List<Utente> trovaPerAnnoNascita(Date annoNascita);

    // -------------------------------------------------

    Utente trovaPerPassword(String password);

}
