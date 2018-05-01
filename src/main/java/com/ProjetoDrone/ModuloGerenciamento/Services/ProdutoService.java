package com.ProjetoDrone.ModuloGerenciamento.Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Produto;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Josué
 */
public interface ProdutoService extends Serializable {

    public List<Produto> listar(int offset, int quantidade);

    public Produto obter(long idProduto);

    public void incluir(Produto p);

    public void alterar(Produto p);

    public void remover(long idProduto);
}
