package com.massimiliano.webapp.service.impl;

import com.massimiliano.webapp.dao.VeicoloDao;
import com.massimiliano.webapp.entities.Veicolo;
import com.massimiliano.webapp.service.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("veicoloService")
@Transactional
public class VeicoloServiceImpl implements VeicoloService {


    @Autowired
    VeicoloDao veicoloDaoRepository;

    @Override
    public void Salva(Veicolo veicolo) {
        veicoloDaoRepository.Salva(veicolo);
    }

    @Override
    public void Aggiorna(Veicolo veicolo) {
        veicoloDaoRepository.Aggiorna(veicolo);
    }

    @Override
    public void Elimina(Veicolo veicolo) {
        veicoloDaoRepository.Elimina(veicolo);
    }

    @Override
    public Veicolo trovaById(int id) {
        return veicoloDaoRepository.trovaById(id);
    }

    @Override
    public Veicolo trovaPerTarga(String targa) {
        return veicoloDaoRepository.trovaPerTarga(targa);
    }

    @Override
    public List<Veicolo> trovaMezzi() {
        return veicoloDaoRepository.trovaMezzi();
    }

    @Override
    public List<Veicolo> trovaPerModello(String modello) {
        return veicoloDaoRepository.trovaPerModello(modello);
    }

    @Override
    public List<Veicolo> trovaPerCasaCostruttrice(String casaCostruttrice) {
        return veicoloDaoRepository.trovaPerCasaCostruttrice(casaCostruttrice);
    }

    @Override
    public List<Veicolo> trovaPerAnnoImmatricolazione(String annoImmatricolazione) {
        return veicoloDaoRepository.trovaPerAnnoImmatricolazione(annoImmatricolazione);
    }
}
