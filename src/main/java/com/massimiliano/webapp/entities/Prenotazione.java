package com.massimiliano.webapp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Prenotazione")
public class Prenotazione implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "inizioPrenotazione")
    private Date inizioPrenotazione;

    @Column(name = "finePrenotazione")
    private Date finePrenotazione;

    @ManyToOne
    @JoinColumn(name = "idUtente", referencedColumnName = "id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "targa", referencedColumnName = "id")
    private Veicolo veicolo;

    public Prenotazione() {

    }

    public Prenotazione(Date inizioPrenotazione, Date finePrenotazione, Utente utente, Veicolo veicolo) {
        this.inizioPrenotazione = inizioPrenotazione;
        this.finePrenotazione = finePrenotazione;
        this.utente = utente;
        this.veicolo = veicolo;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setInizioPrenotazione(Date inizioPrenotazione) {

        this.inizioPrenotazione = inizioPrenotazione;
    }

    public void setFinePrenotazione(Date finePrenotazione) {

        this.finePrenotazione = finePrenotazione;
    }

    public Date getInizioPrenotazione() {

        return inizioPrenotazione;
    }

    public Date getFinePrenotazione() {

        return finePrenotazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Veicolo getMezzo() {
        return veicolo;
    }

    public void setMezzo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public String toString() {
        return "Prenotazione -> Data Inizio: " + inizioPrenotazione + " - Data Fine: " + finePrenotazione
                + "\nVeicolo Prenotato: " + veicolo + "\n Da ->  " + utente + " ;";
    }
}