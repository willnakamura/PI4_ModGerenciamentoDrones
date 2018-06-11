/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Classes.Produto;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

/**
 *
 * @author Rafael Rodrigues
 */
@Entity
@Table(name = "Precos")
public class Precos implements Serializable {

    @Id
    @Column(name = "preco_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPreco;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_alteracao", insertable = false)
    private Date dataAlteracao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_criacao", updatable = false)
    private Date dataCriacao;

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
    private Double preco;
    
    @Column(name = "desconto")
    private double desconto;
    
    @Column(name = "desconto_ativo")
    private boolean desconto_ativo;

    //-------------------------Construtor-----------------------
    public Precos() {
    }

    public Precos(double preco) {
        this.preco = preco;
    }

    //------------------------Fim dos construtores---------------
    public Long getIdPrrco() {
        return IdPreco;
    }

    public void setIdPrrco(Long IdPrrco) {
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

    public Double getPreco() {
        return preco;
    }

    public String getPrecoFormatado() {
        String precoFormatado;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        precoFormatado = nf.format(preco);
        return precoFormatado;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getIdPreco() {
        return IdPreco;
    }

    public void setIdPreco(Long IdPreco) {
        this.IdPreco = IdPreco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public boolean isDesconto_ativo() {
        return desconto_ativo;
    }

    public void setDesconto_ativo(boolean desconto_ativo) {
        this.desconto_ativo = desconto_ativo;
    }
    
    
}
