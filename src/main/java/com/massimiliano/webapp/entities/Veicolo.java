package com.massimiliano.webapp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Veicolo")
public class Veicolo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "casaCostruttrice")
    private String casaCostruttrice;

    @Column(name = "modello")
    private String modello;

    @Column(name = "annoImmatricolazione")
    private Date annoImmatricolazione;

    @Column(name = "targa", unique = true)
    public String targa;

    @OneToMany(mappedBy = "veicolo")
    private List<Prenotazione> listaPrenotazioni;

    public List<Prenotazione> getListaPrenotazioni() {
        return listaPrenotazioni;
    }

    @Column(name = "tipologia")
    private String tipologia;

    public Veicolo() {

    }

    public Veicolo(String casaCostruttrice, String modello, Date annoImmatricolazione, String targa, String tipologia) {
        this.casaCostruttrice = casaCostruttrice;
        this.modello = modello;
        this.annoImmatricolazione = annoImmatricolazione;
        this.targa = targa;
        this.tipologia = tipologia;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getCasaCostruttrice() {

        return casaCostruttrice;
    }

    public void setCasaCostruttrice(String casaCostruttrice) {
        this.casaCostruttrice = casaCostruttrice;
    }

    public String getModello() {

        return modello;
    }

    public void setModello(String modello) {

        this.modello = modello;
    }

    public Date getAnnoImmatricolazione() {

        return annoImmatricolazione;
    }

    public void setAnnoImmatricolazione(Date annoImmatricolazione) {
        this.annoImmatricolazione = annoImmatricolazione;
    }

    public String getTarga() {

        return targa;
    }

    public void setTarga(String targa) {

        this.targa = targa;
    }

    public String getTipologia() {

        return tipologia;
    }

    public void setTipologia(String tipologia) {

        this.tipologia = tipologia;
    }

    public void setListaPrenotazioni(List<Prenotazione> listaPrenotazioni) {
        this.listaPrenotazioni = listaPrenotazioni;
    }


    public String toString() {
        return "Mezzo -> Modello: " + modello + " - Casa Costruttrice: " + casaCostruttrice
                + " - Anno Immatricolazione: " + annoImmatricolazione + " - Targa: " + targa + " - Tipologia Mezzo: "
                + tipologia + ";";
    }
}
