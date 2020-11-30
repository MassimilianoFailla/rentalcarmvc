package com.massimiliano.webapp.service;

import com.massimiliano.webapp.entities.Prenotazione;

import java.util.List;

public interface PrenotazioneService {

    void Salva(Prenotazione prenotazione);

    void Aggiorna(Prenotazione prenotazione);

    void Elimina(Prenotazione prenotazione);

    Prenotazione trovaPrenotazionePerId(int id);

    List<Prenotazione> trovaPrenotazioniPerIdUtente(int idUtente);

    List<Prenotazione> selezionaPrenotazioni();
}
