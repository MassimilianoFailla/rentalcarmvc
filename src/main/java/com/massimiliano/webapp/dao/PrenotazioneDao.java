package com.massimiliano.webapp.dao;

import com.massimiliano.webapp.entities.Prenotazione;

import java.util.List;

public interface PrenotazioneDao {

    void Salva(Prenotazione prenotazione);

    void Aggiorna(Prenotazione prenotazione);

    void Elimina(Prenotazione prenotazione);

    Prenotazione trovaPrenotazionePerId(int id);

    List<Prenotazione> trovaPrenotazioniPerIdUtente(int idUtente);

    List<Prenotazione> selezionaPrenotazioni();
}
