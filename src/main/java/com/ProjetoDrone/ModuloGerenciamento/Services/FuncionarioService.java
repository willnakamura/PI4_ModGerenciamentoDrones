/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Services;

import com.ProjetoDrone.ModuloGerenciamento.Classes.Funcionario.Funcionario;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Josué
 */
public interface FuncionarioService extends Serializable {

    public List<Funcionario> listar(int offset, int quantidade);

    public Funcionario obter(long idFuncionario);

    public void incluir(Funcionario f);

    public void alterar(Funcionario f);

    public void remover(long idProduto);
    
    public Funcionario logar (String email);
}
