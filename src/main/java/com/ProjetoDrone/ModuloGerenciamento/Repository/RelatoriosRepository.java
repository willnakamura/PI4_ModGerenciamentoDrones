/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Repository;

import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Produto;
import com.ProjetoDrone.ModuloGerenciamento.Relatorios.Cliente;
import com.ProjetoDrone.ModuloGerenciamento.Relatorios.Venda;
import com.ProjetoDrone.ModuloGerenciamento.Relatorios.VendasRelatorio;
import com.ProjetoDrone.ModuloGerenciamento.Services.RelatoriosService;
import java.util.Date;
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

    @Override
    public List<VendasRelatorio> listarVendas(Date data_inicial, Date data_final) {
        Query query = entityManager.createNativeQuery("select v.dt_venda, v.codigo_compra, v.status_pedido, "
                + "c.nome nome_cliente, p.nome produto, vp.qtd, v.total_venda "
                + "from vendas v "
                + "inner join venda_prod vp on vp.venda_id = v.vendaid "
                + "inner join produtos p on p.produto_id = vp.produto_id "
                + "inner join clientes c on c.cliente_id = v.cliente_id "
                + "where v.dt_venda >= ?1 and v.dt_venda < date_add(?2, interval 1 day)", VendasRelatorio.class);
        query.setParameter(1, data_inicial);
        query.setParameter(2, data_final);
        List<VendasRelatorio> resultados = query.getResultList();
        return resultados;
    }

    @Override
    public List<VendasRelatorio> listarVendas(String codigoCompra) {
        Query query = entityManager.createNativeQuery("select v.dt_venda, v.codigo_compra, v.status_pedido, "
                + "c.nome nome_cliente, p.nome produto, vp.qtd, v.total_venda "
                + "from vendas v "
                + "inner join venda_prod vp on vp.venda_id = v.vendaid "
                + "inner join produtos p on p.produto_id = vp.produto_id "
                + "inner join clientes c on c.cliente_id = v.cliente_id "
                + "where v.codigo_compra = ?1", VendasRelatorio.class);
        query.setParameter(1, codigoCompra);
        List<VendasRelatorio> resultados = query.getResultList();
        return resultados;
    }

    @Override
    public Venda obter(long codigoCompra) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT v FROM Venda v "
                + "WHERE v.codigoCompra = :codigoCompra");
        query.setParameter("codigoCompra", codigoCompra);
        Venda resultado = (Venda) query.getSingleResult();
        return resultado;
    }
    
   @Override
    @Transactional
    public void alterar(Venda v){
    if (v.getIdVenda()== null) {
            entityManager.persist(v);
        } else {
            entityManager.merge(v);
        }
    
    }

}
