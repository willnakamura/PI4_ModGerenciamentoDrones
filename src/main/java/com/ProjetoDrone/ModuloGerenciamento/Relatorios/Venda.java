/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Relatorios;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Rafael Rodrigues
 */
@Entity
@Table(name = "Vendas")
public class Venda implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

//    @OneToMany(mappedBy = "venda", fetch = FetchType.LAZY,
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Transient
    private Set<VendaProd> vendaProd;

    @Id
    @Column(name = "vendaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenda;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_venda")
    private Date dataVenda = new Date();

    //private int idCli;
    //parcelas
    @NotNull
    @Digits(integer = 2, fraction = 0)
    @Column(name = "parcelas", precision = 2, scale = 0, nullable = false)
    private int parcelas;
    //forma de pagamento
    @NotNull
    @Size(min = 2, max = 2)
    @Column(name = "formaPagamento", length = 2, nullable = false, unique = false)
    private String formaPagamento;
    //numero do cartão
    @NotNull
    @Size(min = 16, max = 16)
    @Column(name = "numeroCartao", length = 16, nullable = false, unique = false)
    private String numeroCartao;
    
    @Column(name= "codigoCompra", length = 10, nullable = true, unique = false)
    private String codigoCompra;
    
    //validade do cartão
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    @Column(name = "ValidadeCartao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date validadeCartao;
    
    //Codigo de segurança 
    @NotNull
    @Digits(integer = 3, fraction = 0)
    @Column(name = "codigoSeguranca", length =3, nullable = false, unique = false)
    private long codigoSeguranca;

    //total venda
    @Column(name = "totalVenda", precision = 6, scale = 2, nullable = false)
    private double totalVenda;

    //estado
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado", length = 45, nullable = false, unique = false)
    private String estado;
    //cidade
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cidade", length = 45, nullable = false, unique = false)
    private String cidade;
    //rua
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rua", length = 45, nullable = false, unique = false)
    private String rua;
    //cep
    @NotNull
    @Size(min = 8, max = 8)
    @Column(name = "cep", length = 8, nullable = false, unique = false)
    private String cep;

    //numero
    @NotNull
    @Digits(integer = 5, fraction = 0)
    @Column(name = "numero", precision = 5, scale = 0, nullable = false)
    private int numero;
    //nome
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome", length = 45, nullable = false, unique = false)
    private String nome;
    
    @Size(min = 1, max = 45)
    @Column(name = "statusPedido", length = 45, nullable = true, unique = false)
    private String statusPedido;
    
    //celular
    @NotNull
    @Size(min = 9, max = 11)
    @Column(name = "celular", length = 11, nullable = false, unique = false)
    private String celular;
    
    //nome do titular do cartão
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeTitularCard", length = 45, nullable = false, unique = false)
    private String nomeTitular;
    

    public Venda() {
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

//    public int getIdCli() {
//        return idCli;
//    }
//
//    public void setIdCli(int idCli) {
//        this.idCli = idCli;
//    }
    public String getFormaPagamento() {
        return formaPagamento;
    }

    
    
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<VendaProd> getVendaProd() {
        return vendaProd;
    }

    public void setVendaProd(Set<VendaProd> vendaProd) {
        this.vendaProd = vendaProd;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(Date validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    public long getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(long codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
    
    

}
