package com.massimiliano.webapp.service;

import com.massimiliano.webapp.entities.Veicolo;

import java.util.List;

public interface VeicoloService {

    void Salva(Veicolo veicolo);

    void Aggiorna(Veicolo veicolo);

    void Elimina(Veicolo veicolo);

    Veicolo trovaById(int id);

    Veicolo trovaPerTarga(String targa);

    List<Veicolo> trovaMezzi();

    //metodi da implementare nel filtraggio

    List<Veicolo> trovaPerModello(String modello);

    List<Veicolo> trovaPerCasaCostruttrice(String casaCostruttrice);

    List<Veicolo> trovaPerAnnoImmatricolazione(String annoImmatricolazione);

}