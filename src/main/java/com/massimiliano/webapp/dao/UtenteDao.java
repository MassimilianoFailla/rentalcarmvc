package com.massimiliano.webapp.dao;

import com.massimiliano.webapp.entities.Utente;

import java.util.Date;
import java.util.List;

public interface UtenteDao {

    List<Utente> selezionaUtenti();

    Utente selezionaById(int id);

    void Salva(Utente utente);

    void Aggiorna(Utente utente);

    void Elimina(Utente utente);

    Utente validate(String username, String password);

    List<Utente> selezionaUtentiByRole(String role);

    // metodi da implementare per il filtraggio --------

     List<Utente> trovaPerNome(String nome);

     List<Utente> trovaPerCognome(String cognome);

     Utente trovaPerEmail(String email);

     List<Utente> trovaPerAnnoNascita(Date annoNascita);

    // -------------------------------------------------


    Utente trovaPerPassword(String password);

}
