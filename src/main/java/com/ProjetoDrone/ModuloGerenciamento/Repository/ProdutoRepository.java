package com.ProjetoDrone.ModuloGerenciamento.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Precos;
import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Produto;
import com.ProjetoDrone.ModuloGerenciamento.Services.ProdutoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josué
 */
@Repository
public class ProdutoRepository implements ProdutoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Produto> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT p FROM Produto p");
        List<Produto> resultados = query.getResultList();
        return resultados;
    }

    @Override
    public Produto obter(long idProduto) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT p FROM Produto p "
                + "WHERE p.idProd = :idProduto");
        query.setParameter("idProduto", idProduto);
        Produto resultado = (Produto) query.getSingleResult();
        return resultado;
    }

    @Override
    public List<Produto> porNome(String nome) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT p FROM Produto p "
                + "WHERE p.nome = :nome");
        query.setParameter("nome", nome);
        List<Produto> resultado = query.getResultList();
        return resultado;
    }

    @Override
    @Transactional
    public void incluir(Produto p) {
        if (p.getIdProd() == null) {
                entityManager.persist(p);
        } else {
            entityManager.merge(p);
        }
        //entityManager.persist(p);
    }

    @Override
    @Transactional
    public void alterar(Produto p) {
        if (p.getIdProd() == null) {
            entityManager.persist(p);
        } else {
            entityManager.merge(p);
        }
        //entityManager.persist(p);
    }

    @Override
    @Transactional
    public void remover(long idProduto) {
        Produto p = entityManager.find(Produto.class, idProduto);
        entityManager.remove(p);
    }
}
