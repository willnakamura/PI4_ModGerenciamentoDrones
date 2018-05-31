package com.ProjetoDrone.ModuloGerenciamento.Controller;

import com.ProjetoDrone.ModuloGerenciamento.Repository.PrecosRepository;
import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Precos;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nakamura-PC
 */
@Controller
@RequestMapping("/consultar/preco")
public class ConsultarPrecoController {

    @Autowired
    PrecosRepository repository;    

    @GetMapping("/consultarPreco")
    public ModelAndView consulta(HttpSession sessao) {

        List<Precos> precos = new ArrayList<Precos>();

        try {
            precos = repository.listar();
            sessao.setAttribute("listaPrecos", precos);

        } catch (Exception e) {
            return new ModelAndView("consultarPreco");
        }
        return new ModelAndView("consultarPreco");
    }
}
