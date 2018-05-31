package com.ProjetoDrone.ModuloGerenciamento.Controller;

import com.ProjetoDrone.ModuloGerenciamento.Repository.ProdutoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Produto;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nakamura-PC
 */
@Controller
@RequestMapping("/consultar/produto")
public class ConsultaProdController {

    @Autowired
    ProdutoRepository repository;

    @PostMapping
    public ModelAndView consulta(@ModelAttribute("prod")
            Produto prod, HttpSession sessao) {
        List<Produto> produtos = new ArrayList<Produto>();

        try {
            produtos = repository.porNome(prod.getNome());
            sessao.setAttribute("produtos", produtos);
        } catch (Exception e) {
            return new ModelAndView("consultarProd");
        }
        return new ModelAndView("consultarProd");
    }
}
