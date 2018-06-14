/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Controller;

import com.ProjetoDrone.ModuloGerenciamento.Classes.Funcionario.Funcionario;
import com.ProjetoDrone.ModuloGerenciamento.Relatorios.CodVenda;
import com.ProjetoDrone.ModuloGerenciamento.Relatorios.DatasRelat;
import com.ProjetoDrone.ModuloGerenciamento.Relatorios.VendasRelatorio;
import com.ProjetoDrone.ModuloGerenciamento.Repository.RelatoriosRepository;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/relatorio/venda")
public class RelatorioVendasController {

    @Autowired
    RelatoriosRepository repository;

    @GetMapping("/tela")
    public ModelAndView telaRelatorio() {
        return new ModelAndView("relatorioVendas").addObject("dataRela", new DatasRelat());
    }

    @PostMapping
    public ModelAndView gerarRelatorio(@ModelAttribute("dataRela")
            @Valid DatasRelat dataRela, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, HttpSession sessao) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("relatorioVendas");
        }

        List<VendasRelatorio> vendasRel = new ArrayList<VendasRelatorio>();

        try {
            vendasRel = repository.listarVendas(dataRela.getDataInicio(), dataRela.getDataFim());
            sessao.setAttribute("relatorio", vendasRel);
        } catch (Exception e) {
            return new ModelAndView("relatorioVendas");
        }
        return new ModelAndView("relatorioVendas");
    }

    @GetMapping("/consulta")
    public ModelAndView telaConsulta() {
        return new ModelAndView("consultaVenda").addObject("codVenda", new CodVenda());
    }

    @PostMapping("/listarVendas")
    public ModelAndView listarVenda(@ModelAttribute("codVenda")
            @Valid CodVenda codVenda, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, HttpSession sessao) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("consultaVenda");
        }

        List<VendasRelatorio> vendasRel = new ArrayList<VendasRelatorio>();

        try {
            vendasRel = repository.listarVendas(codVenda.getCodCompra());
            sessao.setAttribute("listaVenda", vendasRel);
        } catch (Exception e) {
            return new ModelAndView("consultaVenda");
        }
        return new ModelAndView("consultaVenda");
    }
}
