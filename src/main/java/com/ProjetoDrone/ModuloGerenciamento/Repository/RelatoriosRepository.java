/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Repository;

import com.ProjetoDrone.ModuloGerenciamento.Relatorios.Cliente;
import com.ProjetoDrone.ModuloGerenciamento.Services.RelatoriosService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josué
 */
@Repository
public class RelatoriosRepository implements RelatoriosService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cliente> listar() {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT c FROM Cliente c");
        List<Cliente> resultados = query.getResultList();
        return resultados;
    }

}
