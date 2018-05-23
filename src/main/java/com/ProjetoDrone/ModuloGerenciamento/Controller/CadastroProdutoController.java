package com.ProjetoDrone.ModuloGerenciamento.Controller;

import com.ProjetoDrone.ModuloGerenciamento.Repository.ProdutoRepository;
import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Produto;
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
@RequestMapping("/cadastrar/produto")
public class CadastroProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/cadastro")
    public ModelAndView cadastroProd() {
        return new ModelAndView("Cadastro").addObject("produto", new Produto());
    }

    @PostMapping("/salvar")
    public ModelAndView realizarCadastro(@ModelAttribute("produto")
            @Valid Produto produto, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/cadastro");
        }

        try {
            repository.incluir(produto);
        } catch (Exception e) {
            return new ModelAndView("Cadastro");
        }

        return new ModelAndView("redirect:/login/telaLogin");
    }
}
