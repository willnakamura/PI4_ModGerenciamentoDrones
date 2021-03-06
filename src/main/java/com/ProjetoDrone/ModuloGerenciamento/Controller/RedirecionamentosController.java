/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Controller;

import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Precos;
import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Produto;
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

    @GetMapping("/paginaInicial")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping("/consultarProduto")
    public ModelAndView consultarProd() {
        return new ModelAndView("consultarProd").addObject("prod", new Produto());
    }
}
