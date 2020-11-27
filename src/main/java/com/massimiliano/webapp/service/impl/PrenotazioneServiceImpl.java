package com.massimiliano.webapp.service.impl;

import com.massimiliano.webapp.dao.PrenotazioneDao;
import com.massimiliano.webapp.entities.Prenotazione;
import com.massimiliano.webapp.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// devono avere anche l'annotazione di Autowired

@Service("prenotazioneService")
@Transactional
public class PrenotazioneServiceImpl implements PrenotazioneService {


    @Autowired
    private PrenotazioneDao prenotazioneDaoRepository;


    @Override
    public void Salva(Prenotazione prenotazione) {
        prenotazioneDaoRepository.Salva(prenotazione);
    }

    @Override
    public void Aggiorna(Prenotazione prenotazione) {
        prenotazioneDaoRepository.Aggiorna(prenotazione);
    }

    @Override
    public void Elimina(Prenotazione prenotazione) {
        prenotazioneDaoRepository.Elimina(prenotazione);
    }

    @Override
    public Prenotazione trovaPrenotazionePerId(int id) {

        return prenotazioneDaoRepository.trovaPrenotazionePerId(id);
    }

    @Override
    public List<Prenotazione> trovaPrenotazioniPerId(int id) {
        return prenotazioneDaoRepository.trovaPrenotazioniPerId(id);
    }

    @Override
    public List<Prenotazione> selezionaPrenotazioni() {
        return prenotazioneDaoRepository.selezionaPrenotazioni();
    }
}
