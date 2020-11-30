package com.massimiliano.webapp.controller;

import com.massimiliano.webapp.entities.Prenotazione;
import com.massimiliano.webapp.entities.Utente;
import com.massimiliano.webapp.entities.Veicolo;
import com.massimiliano.webapp.service.PrenotazioneService;
import com.massimiliano.webapp.service.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

// gestione delle prenotazioni

@Controller
@RequestMapping("/prenotazione")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private VeicoloService veicoloService;


    //    -------------------------------- GET Prenotazione ------------------------------------------------------------

    @ModelAttribute("prenotazione")
    public Prenotazione getPrenotazione() {
        return new Prenotazione();
    }

    //    -------------------------------- GET Lista Prenotazioni ------------------------------------------------------

    private List<Prenotazione> getListaPrenotazioni() {

        List<Prenotazione> listaPrenotazioni = prenotazioneService.selezionaPrenotazioni();

        return listaPrenotazioni;
    }

    //    -------------------------------- Visualizza Prenotazioni -----------------------------------------------------

    @GetMapping("/visualizzaPrenotazioni")
    public ModelAndView visPrenotazioni(ModelAndView model) {

        model.addObject("Titolo", "Elenco prenotazioni effettuate");
        model.addObject("listaPrenotazioni", getListaPrenotazioni());

        model.setViewName("visualizzaPrenotazioni");

        return model;
    }

    /* -------------------------------- Registra Prenotazione ------------------------------------------------------ */

    @GetMapping("/registrazione")
    public String InsPrenotazione(Model model) {

        Prenotazione prenotazione = new Prenotazione();

        model.addAttribute("Titolo", "Registrazione nuova prenotazione");
        model.addAttribute("Prenotazione", prenotazione);
        model.addAttribute("Prenotazione", getPrenotazione());
        model.addAttribute("listaMezzi", veicoloService.trovaMezzi());

        return "inserisciPrenotazione";
    }

    @PostMapping("/registrazione")
    public String GestInsPrenotazione(@Valid @ModelAttribute("prenotazione") Prenotazione prenotazione,
                                      HttpSession session) {


        int idUtente = (int) session.getAttribute("idUtente");

        Utente utente = new Utente();
        utente.setId(idUtente);

        Veicolo veicolo = veicoloService.trovaPerTarga(prenotazione.getMezzo().getTarga());

        prenotazione.setMezzo(veicolo);
        prenotazione.setUtente(utente);

        prenotazioneService.Salva(prenotazione);

        return "redirect:/prenotazione/visualizzaPrenotazioni";
    }


    //    -------------------------------- Aggiornamento Prenotazione --------------------------------------------------

    @RequestMapping(value = "/modifica/{prenotazione.id}", method = RequestMethod.GET)
    public String modPrenotazione(ModelAndView model, @PathVariable("id") int id) {

        Prenotazione prenotazione = prenotazioneService.trovaPrenotazionePerId(id);

        model.addObject("Titolo", "Modifica Prenotazione");
        model.addObject("Prenotazione", prenotazione);
        model.addObject("edit", true);

        prenotazioneService.Aggiorna(prenotazione);

        return "inserisciPrenotazione";
    }

    @RequestMapping(value = "/modifica/{prenotazione.id}", method = RequestMethod.POST)
    public String GestModPrenotazione(@Valid @ModelAttribute("Prenotazione") Prenotazione prenotazione, BindingResult result,
                                      ModelAndView model, @PathVariable("id") int id) {

        if (prenotazione.getId() != 0) {
            if (result.hasErrors()) {

                model.addObject("Titolo", "Modifica Prenotazione");
                model.addObject("Prenotazione", prenotazioneService.trovaPrenotazionePerId(id));
                model.addObject("edit", true);

                return "inserisciPrenotazione";
            }

            prenotazioneService.Aggiorna(prenotazione);
        }
        return "redirect:/homeSuperUser";
    }

    //    -------------------------------- Cancellazione Prenotazione -------------------------------------------------------

    @RequestMapping(value = "/elimina", method = RequestMethod.GET)
    public String eliPrenotazione(@PathVariable("id") int idPrenotazione, ModelAndView model) {

        Prenotazione prenotazione = prenotazioneService.trovaPrenotazionePerId(idPrenotazione);

        model.addObject("Titolo", "EliminaPrenotazione");
        model.addObject("Prenotazione", getPrenotazione());
        model.addObject("edit", true);

        prenotazioneService.Elimina(prenotazione);

        return "redirect:/homeSuperUser";
    }

    @RequestMapping(value = "/elimina", method = RequestMethod.POST)
    public String GestEliPrenotazione(@Valid @ModelAttribute("Prenotazione") Prenotazione prenotazione, BindingResult result,
                                      ModelAndView model) {

        if (prenotazione.getId() != 0) {
            if (result.hasErrors()) {

                model.addObject("Titolo", "EliminaPrenotazione");
                model.addObject("edit", true);

                return "redirect:/homeSuperUser";
            }
            prenotazioneService.Elimina(prenotazione);
        }
        return "redirect:/homeSuperUser";
    }

}