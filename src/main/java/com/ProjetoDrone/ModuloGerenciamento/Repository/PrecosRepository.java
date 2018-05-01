/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Repository;

import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Precos;
import com.ProjetoDrone.ModuloGerenciamento.Services.PrecosService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Josué
 */
public class PrecosRepository implements PrecosService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Precos> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT p FROM Precos p");
        List<Precos> resultados = query.getResultList();
        return resultados;
    }

    @Override
    public Precos obter(long idPrecos) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT p FROM Precos p "
                + "WHERE p.IdPreco = :idPrec");
        query.setParameter("idPrec", idPrecos);
        Precos resultado = (Precos) query.getSingleResult();
        return resultado;
    }

    @Override
    @Transactional
    public void incluir(Precos p) {
        if (p.getIdPrrco() == null) {
            entityManager.persist(p);
        } else {
            entityManager.merge(p);
        }
        entityManager.persist(p);
    }

    @Override
    @Transactional
    public void alterar(Precos p) {
        if (p.getIdPrrco() == null) {
            entityManager.persist(p);
        } else {
            entityManager.merge(p);
        }
        entityManager.persist(p);
    }

    @Override
    @Transactional
    public void remover(long idPrecos) {
        Precos p = entityManager.find(Precos.class, idPrecos);
        entityManager.remove(p);
    }

}
