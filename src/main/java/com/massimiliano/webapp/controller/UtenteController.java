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

// gestione degli utenti

@Controller
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    //    -------------------------------- Get Utente ------------------------------------------------------------------

    @ModelAttribute("Utente")
    public Utente getUtente() {
        return new Utente();
    }

    //    --------------------------------  Get Lista Utenti -----------------------------------------------------------

    private List<Utente> getListaUtenti() {

        List<Utente> listaUtenti = utenteService.selezionaUtenti();

        return listaUtenti;
    }

    //    -------------------------------- Visualizza Lista Utente Nella Pagina Principale  ----------------------------

    @GetMapping("/visualizzaUtenti")
    public ModelAndView visUtenti(ModelAndView model) {

        model.addObject("Titolo", "Elenco utenti registrati");
        model.addObject("listaUtenti", getListaUtenti());

        model.setViewName("visualizzaUtenti");

        return model;
    }

    //    -------------------------------- Registrazione Utente --------------------------------------------------------

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

        return "redirect:/homeSuperUser";
    }

    //    -------------------------------- Modifica Utente --------------------------------------------------------


    @RequestMapping(value = "/modifica/{utente.id}", method = RequestMethod.GET)
    public String modUtente(@PathVariable("id") int idUtente, ModelAndView model) {

        Utente utente = utenteService.selezionaById(idUtente);

        model.addObject("Titolo", "Modifica Utente");
        model.addObject("Utente", getUtente());
        model.addObject("edit", true);

        utenteService.Aggiorna(utente);

        return "redirect:/homeSuperUser";
    }

    @RequestMapping(value = "/modifica/{utente.id}", method = RequestMethod.POST)
    public String GestModUtente(@Valid @ModelAttribute("Utente") Utente utente, BindingResult result,
                                ModelAndView model) {

        if (utente.getId() != 0) {
            if (result.hasErrors()) {

                model.addObject("Titolo", "Modifica Utente");
                model.addObject("edit", true);

                return "redirect:/homeSuperUser";
            }
            utenteService.Aggiorna(utente);
        }
        return "redirect:/homeSuperUser";
    }


//    @RequestMapping(value = "/modifica/{utente.id}", method = RequestMethod.GET)
//    public String modUtente(ModelAndView model, @PathVariable("id") int idUtente){
//
//        Utente utente = utenteService.selezionaById(idUtente);
//
//        model.addObject("Titolo", "Modifica utente");
//        model.addObject("Utente", utente);
//        model.addObject("edit", true);
//
//        utenteService.Aggiorna(utente);
//
//        return "inserisciUtente";
//     }
//
//     @RequestMapping(value = "/modifica/{utente.id}", method = RequestMethod.POST)
//    public String GestModUtente(@Valid @ModelAttribute("Utente") Utente utente, BindingResult result,
//                                ModelAndView model, @PathVariable("id") int idUtente){
//
//        if(utente.getId() != 0) {
//            if (result.hasErrors()) {
//
//                model.addObject("Titolo", "Modifica Utente");
//                model.addObject("Utente", utenteService.selezionaById(idUtente));
//                model.addObject("edit", true);
//
//                return "inserisciUtente";
//            }
//
//            utenteService.Aggiorna(utente);
//        }
//         return "redirect:/homeSuperUser";
//    }

    //    -------------------------------- Cancellazione Utente --------------------------------------------------------

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