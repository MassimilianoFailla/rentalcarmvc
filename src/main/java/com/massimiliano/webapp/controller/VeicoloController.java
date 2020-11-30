package com.massimiliano.webapp.controller;

import com.massimiliano.webapp.entities.Veicolo;
import com.massimiliano.webapp.service.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

// gestione dei veicoli

@Controller
@RequestMapping("/veicolo")
public class VeicoloController {

    @Autowired
    private VeicoloService veicoloService;

    //    -------------------------------- GET Veicolo -----------------------------------------------------------------

    @ModelAttribute("Veicolo")
    public Veicolo getVeicolo() {
        return new Veicolo();
    }

    //    -------------------------------- GET Lista Veicoli -----------------------------------------------------------

    private List<Veicolo> getListaVeicoli() {

        List<Veicolo> listaVeicoli = veicoloService.trovaMezzi();

        return listaVeicoli;
    }

    //    -------------------------------- Visualizzazione Lista Veicoli -----------------------------------------------

    @GetMapping("/visualizzaVeicoli")
    public ModelAndView visUtenti(ModelAndView model) {

        model.addObject("Titolo", "Elenco veicoli");
        model.addObject("listaVeicoli", getListaVeicoli());

        model.setViewName("visualizzaVeicoli");

        return model;
    }

    //    -------------------------------- Registrazione Veicolo -------------------------------------------------------

    @GetMapping("/registrazione")
    public String InsVeicolo(Model model) {

        Veicolo veicolo = new Veicolo();

        model.addAttribute("Titolo", "Inserimento nuovo veicolo");
        model.addAttribute("Veicolo", veicolo);
        model.addAttribute("Veicolo", getVeicolo());

        return "inserisciVeicolo";
    }

    @PostMapping("/registrazione")
    public String GestInsVeicolo(@Valid @ModelAttribute("Veicolo") Veicolo veicolo, BindingResult result) {

        if (result.hasErrors()) {
            return "inserisciVeicolo";
        }

        veicoloService.Salva(veicolo);

        return "redirect:/homeSuperUser";
    }

    //    -------------------------------- Aggiornamento Veicolo -------------------------------------------------------

    @RequestMapping(value = "/modifica/{veicolo.id}", method = RequestMethod.GET)
    public String modVeicolo(ModelAndView model, @PathVariable("id") int id) {

        Veicolo veicolo = veicoloService.trovaById(id);

        model.addObject("Titolo", "Modifica veicolo");
        model.addObject("Veicolo", getVeicolo());
        model.addObject("edit", true);

        veicoloService.Aggiorna(veicolo);

        return "inserisciVeicolo";
    }

    @RequestMapping(value = "/modifica/{veicolo.id}", method = RequestMethod.POST)
    public String GestModVeicolo(@Valid @ModelAttribute("Veicolo") Veicolo veicolo, BindingResult result,
                                 ModelAndView model) {

        if (veicolo.getId() != 0) {
            if (result.hasErrors()) {

                model.addObject("Titolo", "Modifica Veicolo");
                model.addObject("edit", true);

                return "inserisciVeicolo";
            }

            veicoloService.Aggiorna(veicolo);
        }
        return "redirect:/homeSuperUser";
    }

    //    -------------------------------- Cancellazione Veicolo -------------------------------------------------------

    @RequestMapping(value = "/elimina", method = RequestMethod.GET)
    public String eliVeicolo(@PathVariable("id") int idVeicolo, ModelAndView model) {

        Veicolo veicolo = veicoloService.trovaById(idVeicolo);

        model.addObject("Titolo", "Elimina Veicolo");
        model.addObject("Veicolo", getVeicolo());
        model.addObject("edit", true);

        veicoloService.Elimina(veicolo);

        return "redirect:/homeSuperUser";
    }

    @RequestMapping(value = "/elimina", method = RequestMethod.POST)
    public String GestEliVeicolo(@Valid @ModelAttribute("Veicolo") Veicolo veicolo, BindingResult result,
                                 ModelAndView model) {

        if (veicolo.getId() != 0) {
            if (result.hasErrors()) {

                model.addObject("Titolo", "Elimina Veicolo");
                model.addObject("edit", true);

                return "redirect:/homeSuperUser";
            }
            veicoloService.Elimina(veicolo);
        }
        return "redirect:/homeSuperUser";
    }

}
