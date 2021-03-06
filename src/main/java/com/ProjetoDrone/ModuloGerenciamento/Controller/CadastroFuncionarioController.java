/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Controller;

import com.ProjetoDrone.ModuloGerenciamento.Repository.FuncionarioRepository;
import com.ProjetoDrone.ModuloGerenciamento.Classes.Funcionario.Funcionario;
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

@Controller
@RequestMapping("/cadastrar/funcionario")
public class CadastroFuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping("/cadastro")
    public ModelAndView cadastroFunc() {
        return new ModelAndView("Cadastro").addObject("funcionario", new Funcionario());
    }

    @PostMapping("/salvar")
    public ModelAndView realizarCadastro(@ModelAttribute("funcionario")
            @Valid Funcionario funcionario, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/cadastro");
        }

        repository.incluir(funcionario);

        return new ModelAndView("redirect:/home/login");
    }
}
