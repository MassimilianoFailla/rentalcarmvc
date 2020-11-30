package com.massimiliano.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// pagina principale all'avvio della webapp

@Controller
@RequestMapping("/home")
public class IndexController {

    @RequestMapping(value = "index")
    public String getWelcome(Model model) {

        model.addAttribute("intestazione", "Benvenuti nel sito di RentalCar ");
        model.addAttribute("saluti", "Accedi o Registrati");

        return "index";

    }

    @RequestMapping
    public String getWelcome2(Model model) {

        model.addAttribute("intestazione", "Benvenuti nel sito di RentalCar");
        model.addAttribute("saluti", "Accedi o Registrati");

        return "index";

    }

}
