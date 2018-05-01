/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Repository;

import com.ProjetoDrone.ModuloGerenciamento.Classes.Funcionario.Funcionario;
import com.ProjetoDrone.ModuloGerenciamento.Services.FuncionarioService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Josué
 */
public class FuncionarioRepository implements FuncionarioService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Funcionario> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT f FROM Funcionario f");
        List<Funcionario> resultados = query.getResultList();
        return resultados;
    }

    @Override
    public Funcionario obter(long idFuncionario) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT f FROM Funcionario f "
                + "WHERE f.idFunc = :idFuncionario");
        query.setParameter("idFuncionario", idFuncionario);
        Funcionario resultado = (Funcionario) query.getSingleResult();
        return resultado;
    }

    @Override
    @Transactional
    public void incluir(Funcionario f) {
        if (f.getIdCli() == null) {
            entityManager.persist(f);
        } else {
            entityManager.merge(f);
        }
        entityManager.persist(f);
    }

    @Override
    @Transactional
    public void alterar(Funcionario f) {
        if (f.getIdCli() == null) {
            entityManager.persist(f);
        } else {
            entityManager.merge(f);
        }
        entityManager.persist(f);
    }

    @Override
    @Transactional
    public void remover(long idFuncionario) {
        Funcionario f = entityManager.find(Funcionario.class, idFuncionario);
        entityManager.remove(f);
    }
}
