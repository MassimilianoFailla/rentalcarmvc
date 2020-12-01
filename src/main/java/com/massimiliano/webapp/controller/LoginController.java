package com.massimiliano.webapp.controller;

import com.massimiliano.webapp.entities.Utente;
import com.massimiliano.webapp.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UtenteService utenteService;

    //    -------------------------------- GET Utente ------------------------------------------------------------

    @ModelAttribute("Login")
    private Utente getUtente(Utente utente) {
        return utente;
    }

    @GetMapping("/loginUtente")
    public String login(Model model) {

        Utente utente = new Utente();

        model.addAttribute("Titolo", "Login");
        model.addAttribute("Utente", utente);
        model.addAttribute("Utente", getUtente(utente));

        return "loginUtente";

    }

    @PostMapping("/loginUtente")
    public String login(@Valid @ModelAttribute("Login") Utente utente, HttpServletRequest request) {

        try {
            return authenticate(request, utente);
        } catch (Exception e) {
            e.printStackTrace();
            return "errorlogin.jsp";
        }

    }

    //    -------------------------------- Metodo Validate --------------------------------------------------------------
    private String authenticate(HttpServletRequest request, Utente utente) {

        HttpSession session = request.getSession();
        utente = utenteService.validate(utente.getUsername(), utente.getPassword());

        if (utente != null) {

            int idUtente = utente.getId();
            String role = utente.getRole();

            if (role.equals("SuperUser")) {
                session.setAttribute("idUtente", idUtente);
                return "redirect:/homeSuperUser";

            } else {
                session.setAttribute("idUtente", idUtente);
                return "redirect:/homeCustomerUser";
            }
        } else {
            return "redirect:/errorlogin.jsp";


        }
    }
}
