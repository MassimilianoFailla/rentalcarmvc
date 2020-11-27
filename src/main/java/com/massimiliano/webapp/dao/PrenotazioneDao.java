package com.massimiliano.webapp.dao;

import com.massimiliano.webapp.entities.Prenotazione;

import java.util.List;

public interface PrenotazioneDao {

    void Salva(Prenotazione prenotazione);

    void Aggiorna(Prenotazione prenotazione);

    void Elimina(Prenotazione prenotazione);

    public Prenotazione trovaPrenotazionePerId(int id);

    public List<Prenotazione> trovaPrenotazioniPerId(int id);

    List<Prenotazione> selezionaPrenotazioni();
}
