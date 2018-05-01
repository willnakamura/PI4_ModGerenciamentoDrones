/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author presuporte01
 */
@Controller
@RequestMapping("/home")
public class RedirecionamentosController {

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("index");
    }

    @GetMapping("/paginaInicial")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping("/cadastroProduto")
    public ModelAndView cadastrarProd() {
        return new ModelAndView("cadastrarProd");
    }
}
