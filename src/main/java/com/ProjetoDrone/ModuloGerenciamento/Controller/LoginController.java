/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Controller;

import com.ProjetoDrone.ModuloGerenciamento.Classes.Funcionario.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ProjetoDrone.ModuloGerenciamento.Classes.Login.Login;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Nakamura-PC
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    /*@Autowired
    private ClienteRepository repository;*/
    //
    @GetMapping("/telaLogin")
    public ModelAndView login() {
        return new ModelAndView("Login").addObject("login", new Login());
    }

    @PostMapping("/logando")
    public ModelAndView logando(@ModelAttribute("login") @Valid Login login, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("Login");
        }

        Funcionario cli = new Funcionario();

       // cli = repository.logar(login.getUser());

        if (cli == null) {
            return new ModelAndView("Login");
        }

        if (cli.getEmail().equals(login.getUser()) && cli.getSenha().equals(login.getSenha())) {
            session.setAttribute("usuario", cli);
            return new ModelAndView("redirect:/home/paginaInicial");
        } else {
            return new ModelAndView("Login");
        }
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("Home");
    }

}
