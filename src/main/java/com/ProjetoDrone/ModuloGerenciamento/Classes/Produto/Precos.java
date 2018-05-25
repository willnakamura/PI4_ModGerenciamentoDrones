/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Classes.Produto;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Rafael Rodrigues
 */
@Entity
@Table(name = "Precos")
public class Precos implements Serializable {

    @OneToMany(mappedBy = "precos", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinColumn(name = "preco_id", nullable = false)
    private Set<Produto> produto;

    @Id
    @Column(name = "preco_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdPreco;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_alteracao")
    private Date dataAlteracao = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_criacao")
    private Date dataCriacao = new Date();

//    Funcionario func;
//
//    @NotNull
//    @Column(name = "criado_por")
//    private int criadoPor = func.getIdFunc();
//
//    @NotNull
//    @Column(name = "alterado_por")
//    private int AlteradoPor = func.getIdFunc();
    @Digits(integer = 6, fraction = 2)
    @Column(name = "preco", precision = 6, scale = 2, nullable = false)
    private double preco;

    //-------------------------Construtor-----------------------
    public Precos() {
    }

    public Precos(double preco) {
        this.preco = preco;
    }

    //------------------------Fim dos construtores---------------
    public Integer getIdPrrco() {
        return IdPreco;
    }

    public void setIdPrrco(Integer IdPrrco) {
        this.IdPreco = IdPrrco;
    }
//
//    public int getCriadoPor() {
//        return criadoPor;
//    }
//
//    public void setCriadoPor(int criadoPor) {
//        this.criadoPor = criadoPor;
//    }
//
//    public int getAlteradoPor() {
//        return AlteradoPor;
//    }
//
//    public void setAlteradoPor(int AlteradoPor) {
//        this.AlteradoPor = AlteradoPor;
//    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public double getPreco() {
        return preco;
    }

    public String getPrecoFormatado() {
        String precoFormatado;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        precoFormatado = nf.format(preco);
        return precoFormatado;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Set<Produto> getProduto() {
        return produto;
    }

    public void setProduto(Set<Produto> produto) {
        this.produto = produto;
    }

}
