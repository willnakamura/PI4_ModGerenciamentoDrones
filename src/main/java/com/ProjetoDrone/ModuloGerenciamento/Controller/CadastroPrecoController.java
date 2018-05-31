package com.ProjetoDrone.ModuloGerenciamento.Controller;

import com.ProjetoDrone.ModuloGerenciamento.Repository.PrecosRepository;
import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Precos;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Nakamura-PC
 */
@Controller
@RequestMapping("/cadastrar/preco")
public class CadastroPrecoController {

    @Autowired
    private PrecosRepository repository;

    @GetMapping("/cadastro")
    public ModelAndView cadastroPreco() {
        return new ModelAndView("cadastrarPreco").addObject("preco", new Precos());
    }

    @PostMapping("/salvar")
    public ModelAndView realizarCadastro(@ModelAttribute("preco")
            @Valid Precos preco, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("cadastrarPreco");
        }

        try {
            repository.incluir(preco);
        } catch (Exception e) {
            return new ModelAndView("cadastrarPreco");
        }

        return new ModelAndView("redirect:/home/paginaInicial");
    }

    @GetMapping("/{id}")
    public ModelAndView obterProd(@PathVariable("id") long id, HttpSession sessao) {

        Precos preco = repository.obter(id);
        sessao.setAttribute("precoAlterar", preco);
        return new ModelAndView("alterarPreco").addObject("preco", preco);
    }

    @PostMapping("/alterar")
    public ModelAndView alterarPreco(@ModelAttribute("preco") @Valid Precos preco, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("alterarPreco");
        }

        try {
            repository.alterar(preco);
        } catch (Exception e) {
            return new ModelAndView("alterarPreco");
        }

        return new ModelAndView("redirect:/home/consultarPreco");
    }
}
