package com.massimiliano.webapp.controller;

import com.massimiliano.webapp.entities.Utente;
import com.massimiliano.webapp.service.UtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.List;

// questa sarà la classe di gestione dell'utente, dove potremo effettuare tutte le operazioni
// che riguardano i vari utenti


@Controller
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;


    @ModelAttribute("Utente")
    public Utente getUtente() {
        return new Utente();
    }

    private List<Utente> getListaUtenti() {

        List<Utente> listaUtenti = utenteService.selezionaUtenti();

        return listaUtenti;
    }

    @GetMapping("/visualizzaUtenti")
    public ModelAndView visUtenti(ModelAndView model) {

        model.addObject("Titolo", "Elenco utenti registrati");
        model.addObject("listaUtenti", getListaUtenti());

        model.setViewName("visualizzaUtenti");

        return model;
    }


    @GetMapping("/registrazione")
    public String InsUtente(Model model) {

        Utente utente = new Utente();

        model.addAttribute("Titolo", "Inserimento nuovo utente");
        model.addAttribute("Utente", utente);
        model.addAttribute("Utente", getUtente());

        return "inserisciUtente";
    }


    @PostMapping("/registrazione")
    public String GestInsUtente(@Valid @ModelAttribute("Utente") Utente utente, BindingResult result) {

        if (result.hasErrors()) {
            return "inserisciUtente";
        }

        utenteService.Salva(utente);

        return "redirect:/home";
    }

    //    -------------------------------- Aggiorna Utente ------------------------------------------------------------

    @GetMapping("/aggiorna")
    public String AggUtente(Model model, @Valid @ModelAttribute("Utente") Utente utente) {

        model.addAttribute("Titolo", "Aggiornamento utente con Id -> " +utente.getId());
        model.addAttribute("Utente", utente);
        model.addAttribute("utente.id", utente.getId());

        return "inserisciUtente";
    }

    @PostMapping("/aggiorna")
    public String GestAggUtente(@Valid @ModelAttribute("Utente") Utente utente, BindingResult result) {

        if (result.hasErrors()) {
            return "inserisciUtente";
        }

        utenteService.Aggiorna(utente);

        return "redirect:/homeSuperUser";
    }

    //-------------------------------- Cancellazione Utente --------------------------------------------------------

    @RequestMapping(value = "/elimina", method = RequestMethod.GET)
    public String eliUtente(@PathVariable("id") int idUtente, ModelAndView model) {

        Utente utente = utenteService.selezionaById(idUtente);

        model.addObject("Titolo", "EliminaUtente");
        model.addObject("Utente", getUtente());
        model.addObject("edit", true);

        utenteService.Elimina(utente);

        return "redirect:/homeSuperUser";
    }

    @RequestMapping(value = "/elimina", method = RequestMethod.POST)
    public String GestEliUtente(@Valid @ModelAttribute("Utente") Utente utente, BindingResult result,
                                ModelAndView model) {

        if (utente.getId() != 0) {
            if (result.hasErrors()) {

                model.addObject("Titolo", "EliminaUtente");
                model.addObject("edit", true);

                return "redirect:/homeSuperUser";
            }
            utenteService.Elimina(utente);
        }
        return "redirect:/homeSuperUser";
    }

}
