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

    @GetMapping("/registra")
    public String InsVeicolo(Model model) {

        Veicolo veicolo = new Veicolo();

        model.addAttribute("Titolo","Inserimento nuovo veicolo");
        model.addAttribute("Veicolo", veicolo);
        model.addAttribute("Veicolo", getVeicolo());

        return "inserisciVeicolo";
    }

    @PostMapping("/registra")
    public String GestInsVeicolo(@Valid @ModelAttribute("Veicolo") Veicolo veicolo, BindingResult result) {

        if(result.hasErrors()){
            return "inserisciVeicolo";
        }

        veicoloService.Salva(veicolo);

        return "redirect:/homeSuperUser";
    }

    //    -------------------------------- Aggiornamento Veicolo -------------------------------------------------------

    @GetMapping("/aggiorna")
    public String AggVeicolo(Model model, @Valid @ModelAttribute("Veicolo") Veicolo veicolo) {

        model.addAttribute("Titolo", "Aggiornamento veicolo con Id -> " +veicolo.getId());
        model.addAttribute("Veicolo", veicolo);
        model.addAttribute("veicolo.id", veicolo.getId());

        return "inserisciVeicolo";
    }

    @PostMapping("/aggiorna")
    public String GestAggUtente(@Valid @ModelAttribute("Veicolo") Veicolo veicolo, BindingResult result) {

        if (result.hasErrors()) {
            return "inserisciVeicolo";
        }

        veicoloService.Aggiorna(veicolo);

        return "redirect:/veicolo/visualizzaVeicoli";
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
