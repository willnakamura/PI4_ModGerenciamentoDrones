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
import com.ProjetoDrone.ModuloGerenciamento.Repository.FuncionarioRepository;
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

    @Autowired
    private FuncionarioRepository repository;

    //
    @GetMapping("/telaLogin")
    public ModelAndView login() {
        return new ModelAndView("index").addObject("login", new Login());
    }

    @PostMapping("/logando")
    public ModelAndView logando(@ModelAttribute("login") @Valid Login login, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, HttpSession session) {

        if (bindingResult.hasErrors()) {
            session.setAttribute("erroLogin", "Usuário e/ou senha incorreto");
            return new ModelAndView("index");
        }
        Funcionario func = new Funcionario();
        try {
            func = repository.logar(login.getUser());
        } catch (Exception e) {
            return new ModelAndView("index");
        }

        if (func == null) {
            session.setAttribute("erroLogin", "Usuário e/ou senha incorreto");
            return new ModelAndView("index");
        }

        if (func.getEmail().equals(login.getUser()) && func.getSenha().equals(login.getSenha())) {
            session.setAttribute("usuario", func);
            session.removeAttribute("erroLogin");
            return new ModelAndView("redirect:/home/paginaInicial");

        } else {
            session.setAttribute("erroLogin", "Usuário e/ou senha incorreto");
            return new ModelAndView("index");

        }
        //return null;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("index").addObject("login", new Login());
    }
}
