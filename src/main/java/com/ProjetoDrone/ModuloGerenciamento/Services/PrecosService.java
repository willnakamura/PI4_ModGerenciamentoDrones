/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Services;

import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Precos;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Josué
 */
public interface PrecosService extends Serializable {

    public List<Precos> listar(int offset, int quantidade);

    public Precos obter(long idPrecos);

    public void incluir(Precos p);

    public void alterar(Precos p);

    public void remover(long idProduto);

}
