package com.massimiliano.webapp.service;

import com.massimiliano.webapp.entities.Prenotazione;

import java.util.List;

public interface PrenotazioneService {

    void Salva(Prenotazione prenotazione);

    void Aggiorna(Prenotazione prenotazione);

    void Elimina(Prenotazione prenotazione);

    public Prenotazione trovaPrenotazionePerId(int id);

    public List<Prenotazione> trovaPrenotazioniPerId(int id);

    List<Prenotazione> selezionaPrenotazioni();
}
