/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Controller;

import com.ProjetoDrone.ModuloGerenciamento.Relatorios.VendasRelatorio;
import com.ProjetoDrone.ModuloGerenciamento.Repository.RelatoriosRepository;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nakamura-PC
 */
@Controller
@RequestMapping("/relatorio/venda")
public class RelatorioVendasController {

    @Autowired
    RelatoriosRepository repository;

    @PostMapping
    public ModelAndView gerarRelatorio(@ModelAttribute("vendRelatorio") VendasRelatorio vendRelatorio,
            HttpSession sessao) {

        List<VendasRelatorio> vendasRel = new ArrayList<VendasRelatorio>();

        //fazer um if se o campo de pesquisa for null, retorna toda a lista.
//        try {
//            produtos = repository.porNome(prod.getNome());
//            sessao.setAttribute("produtos", produtos);
//        } catch (Exception e) {
//            return new ModelAndView("consultarProd");
//        }
        return new ModelAndView("consultarProd");
    }
}
