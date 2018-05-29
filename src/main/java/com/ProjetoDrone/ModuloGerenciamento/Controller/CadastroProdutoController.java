package com.ProjetoDrone.ModuloGerenciamento.Controller;

import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Precos;
import com.ProjetoDrone.ModuloGerenciamento.Repository.ProdutoRepository;
import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Produto;
import com.ProjetoDrone.ModuloGerenciamento.Repository.PrecosRepository;
import java.util.ArrayList;
import java.util.List;
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

@Controller
@RequestMapping("/cadastrar/produto")
public class CadastroProdutoController {

    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private PrecosRepository precosRepo;

    @GetMapping("/cadastro")
    public ModelAndView cadastroProd(HttpSession sessao) {

        List<Precos> listPrecos = new ArrayList<>();
        listPrecos = precosRepo.listar();

        sessao.setAttribute("listPrecos", listPrecos);
        return new ModelAndView("cadastrarProd").addObject("produto", new Produto());
    }

    @PostMapping("/salvar")
    public ModelAndView realizarCadastro(@ModelAttribute("produto")
            @Valid Produto produto, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("cadastrarProd");
        }

        Precos preco = precosRepo.obter(produto.getIdPreco());
        produto.setPrecos(preco);

        try {
            repository.incluir(produto);
        } catch (Exception e) {
            return new ModelAndView("cadastrarProd");
        }

        return new ModelAndView("redirect:/home/paginaInicial");
    }

    @GetMapping("/{id}")
    public ModelAndView obterProd(@PathVariable("id") long id, HttpSession sessao) {
        List<Precos> listPrecos = new ArrayList<>();
        listPrecos = precosRepo.listar();

        sessao.setAttribute("listPrecos", listPrecos);

        Produto produto = repository.obter(id);
        sessao.setAttribute("prodAlterar", produto);
        return new ModelAndView("alterarProd").addObject("produto", produto);
    }

    @PostMapping("/alterar")
    public ModelAndView alterarProduto(@ModelAttribute("produto") @Valid Produto produto, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("alterarProd");
        }

        Precos preco = precosRepo.obter(produto.getIdPreco());
        produto.setPrecos(preco);

        try {
            repository.alterar(produto);
        } catch (Exception e) {
            return new ModelAndView("alterarProd");
        }

        return new ModelAndView("redirect:/home/paginaInicial");
    }
}
