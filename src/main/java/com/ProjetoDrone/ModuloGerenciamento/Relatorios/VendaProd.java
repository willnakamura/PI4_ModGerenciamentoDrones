/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Relatorios;
import com.ProjetoDrone.ModuloGerenciamento.Classes.Produto.Produto;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Rafael Rodrigues
 */
@Entity
@Table(name = "VendaProd")
public class VendaProd implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

//    @Id
//    @Transient
//    @Column(name = "venda_id")
//    private int vendaId;

    @NotNull
    @Digits(integer = 3, fraction = 0)
    private int qtd;

//    @Id
//    @Transient
//    @Column(name = "produtoID")
//    private int produtoId;

    public VendaProd() {
    }

    public VendaProd(int qtd) {
        this.qtd = qtd;
    }

//    public int getVendaId() {
//        return vendaId;
//    }
//
//    public void setVendaId(int vendaId) {
//        this.vendaId = vendaId;
//    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

//    public int getProdutoId() {
//        return produtoId;
//    }
//
//    public void setProdutoId(int produtoId) {
//        this.produtoId = produtoId;
//    }

}
