package com.massimiliano.webapp.controller;

import com.massimiliano.webapp.entities.Utente;
import com.massimiliano.webapp.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


// pagina principale dopo il login di un utente super
@Controller
@RequestMapping("/homeSuperUser")
public class IndexSuperUser {

    @Autowired
    UtenteService utenteService;

    //    -------------------------------- Visualizzazione Lista Utenti ------------------------------------------------

    @ModelAttribute("/homeSuperUser")
    public String visUtentiCustomer(Model model) {

        model.addAttribute("Titolo", "listaUtenti");
        model.addAttribute("listaUtenti", getListaUtentiCustomer());

        return "visualizzaUtenti";
    }

    //    -------------------------------- Get Lista Utenti Customer ---------------------------------------------------

    private List<Utente> getListaUtentiCustomer() {

        String roleUte = "Customer";
        List<Utente> listaUtenti;
        listaUtenti = utenteService.selezionaUtentiByRole(roleUte);

        return listaUtenti;
    }

    //    -------------------------------- Get Utente after Login ------------------------------------------------------

    private String getUtente(HttpSession session) {

        int idUtente;
        idUtente = (int) session.getAttribute("idUtente");
        Utente utente = utenteService.selezionaById(idUtente);
        String nomeU = utente.getNome();
        String cognU = utente.getCognome();

        return " " + nomeU + " " + cognU;

    }

    //    -------------------------------- Index Pagina Principale SU --------------------------------------------------

    @RequestMapping(value = "indexSuperUser")
    public String getWelcome(Model model, HttpSession session) {

        model.addAttribute("intestazione", "Benvenuto SU " + getUtente(session) + " in RentalCar");
        model.addAttribute("listaUtenti", getListaUtentiCustomer());

        return "indexSuperUser";

    }

    //    -------------------------------- Index2 Pagina Principale SU --------------------------------------------------

    @RequestMapping
    public String getWelcome2(Model model, HttpSession session) {

        model.addAttribute("intestazione", "Benvenuto SU " + getUtente(session) + " in RentalCar");
        model.addAttribute("listaUtenti", getListaUtentiCustomer());

        return "indexSuperUser";

    }


}
