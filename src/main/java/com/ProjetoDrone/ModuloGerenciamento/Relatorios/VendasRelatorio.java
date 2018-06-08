/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Relatorios;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Subselect;

/**
 *
 * @author Josué
 */
@Entity
@Subselect("select v.dt_venda, v.codigo_compra, v.status_pedido, "
        + "c.nome nome_cliente, p.nome produto, vp.qtd, v.total_venda "
        + "from vendas v "
        + "inner join venda_prod vp on vp.venda_id = v.vendaid "
        + "inner join produtos p on p.produto_id = vp.produto_id "
        + "inner join clientes c on c.cliente_id = v.cliente_id "
        + "where v.dt_venda >= ?1 and v.dt_venda < date_add(?2, interval 1 day)")
public class VendasRelatorio implements Serializable {
    private Date dt_venda;
    @Id
    private String codigo_compra, status_pedido, nome_cliente, produto;
    private int qtd;        
    private double total_venda;

    public Date getDt_venda() {
        return dt_venda;
    }

    public void setDt_venda(Date dt_venda) {
        this.dt_venda = dt_venda;
    }

    public String getCodigo_compra() {
        return codigo_compra;
    }

    public void setCodigo_compra(String codigo_compra) {
        this.codigo_compra = codigo_compra;
    }

    public String getStatus_pedido() {
        return status_pedido;
    }

    public void setStatus_pedido(String status_pedido) {
        this.status_pedido = status_pedido;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getTotal_venda() {
        return total_venda;
    }

    public void setTotal_venda(double total_venda) {
        this.total_venda = total_venda;
    }
    
    
}
