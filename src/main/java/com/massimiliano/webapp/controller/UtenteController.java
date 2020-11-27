package com.massimiliano.webapp.controller;

import com.massimiliano.webapp.entities.Utente;
import com.massimiliano.webapp.service.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

// questa sarà la classe di gestione dell'utente, dove potremo effettuare tutte le operazioni
// che riguardano i vari utenti


@Controller
@RequestMapping("/utente")
public class UtenteController {

    private static final Logger logger = LoggerFactory.getLogger(UtenteController.class);

    @Autowired
    private UtenteService utenteService;

    // creo la lista degli utenti
    List<Utente> mainRecordSet;

    // per l'ordinamento
    private String OrderType = "DESC";
    private int OrderBy = 0;
    private boolean IsClienti = true;
    private boolean IsSaved = false;


    private void GetAllUtenti() {

        mainRecordSet = utenteService.selezionaUtenti();
    }

    // inserimento utenti

    @ModelAttribute("Utente")
    public Utente getUtente() {
        return new Utente();
    }


    @GetMapping(value = "/inserisci")
    public String InsUtente(Model model) {
//        int LastCodFid = Integer.parseInt(utenteService.selezionaUtenti());
//
//        cliente.setCodFidelity(Integer.toString(LastCodFid + 1));

        model.addAttribute("Titolo", "Inserimento Nuovo Utente");
        model.addAttribute("Utente", getUtente());
        model.addAttribute("edit", false);
        model.addAttribute("saved", false);

        return "insUtente";
    }

    @PostMapping(value = "/inserisci")
    public String GestInsCliente(@Valid @ModelAttribute("Utente") Utente utente, BindingResult result, Model model,
                                 RedirectAttributes redirectAttributes, HttpServletRequest request) {
        //Date date = new Date();

        if (result.hasErrors()) {
            return "insUtente";
        }

//        utente.setDataCreaz(date);

        // parametri che passo alla post
        String utenteId = request.getParameter("id");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String dataNascita = request.getParameter("dataNascita");
        String codiceFiscale = request.getParameter("codiceFiscale");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        utente = new Utente();

        if (utenteId == null || utenteId == "")
            utenteService.Salva(utente);
        else {
            int id = Integer.parseInt(utenteId);
            utente.setId(id);
            utenteService.Aggiorna(utente);
        }

        utenteService.Salva(utente);

        redirectAttributes.addFlashAttribute("saved", true);

        return "redirect:/";
//                ù+ cliente.getCodFidelity().trim();
    }


}
