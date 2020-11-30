package com.massimiliano.webapp.controller;

import com.massimiliano.webapp.entities.Prenotazione;
import com.massimiliano.webapp.entities.Utente;
import com.massimiliano.webapp.service.PrenotazioneService;
import com.massimiliano.webapp.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


// pagina principale dopo il login di un utente Customer

@Controller
@RequestMapping("/homeCustomerUser")
public class IndexCustomerUser {

    @Autowired
    PrenotazioneService prenotazioneService;

    @Autowired
    UtenteService utenteService;

    //    -------------------------------- Visualizzazione Lista Prenotazioni ------------------------------------------

    @ModelAttribute("/homeCustomerUser")
    public String visPrenotazioni(Model model, HttpSession session) {

        model.addAttribute("Titolo", "listaPrenotazioni");
        model.addAttribute("listaPrenotazioni", getListaPrenotazioni(session));

        return "visualizzaPrenotazioni";
    }

    //    -------------------------------- Get Utente After Login ------------------------------------------------------

    private String getUtente(HttpSession session) {

        int idUtente = (int) session.getAttribute("idUtente");
        Utente utente = utenteService.selezionaById(idUtente);
        String nomeU = utente.getNome();
        String cognU = utente.getCognome();

        return " " + nomeU + " " + cognU;

    }

    //    -------------------------------- Get Lista Prenotazioni CU ---------------------------------------------------

    private List<Prenotazione> getListaPrenotazioni(HttpSession session) {

        int idUtente = (int) session.getAttribute("idUtente");

        List<Prenotazione> listaPrenotazioni;
        listaPrenotazioni = prenotazioneService.trovaPrenotazioniPerIdUtente(idUtente);

        return listaPrenotazioni;
    }

    //    -------------------------------- Index Pagina Principale CU --------------------------------------------------

    @RequestMapping(value = "indexCustomerUser")
    public String getWelcome(Model model, HttpSession session) {

        model.addAttribute("intestazione", "Benvenuto CU " + getUtente(session) + " in RentalCar");
        model.addAttribute("listaPrenotazioni", getListaPrenotazioni(session));
        return "indexCustomerUser";
    }

    //    -------------------------------- Index Pagina Principale CU --------------------------------------------------
    @RequestMapping
    public String getWelcome2(Model model, HttpSession session) {

        model.addAttribute("intestazione", "Benvenuto CU " + getUtente(session) + " in RentalCar");
        model.addAttribute("listaPrenotazioni", getListaPrenotazioni(session));

        return "indexCustomerUser";
    }


}
