/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Relatorios;
import java.io.Serializable;
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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Rafael Rodrigues
 */
@Entity
@Table(name = "Clientes")
public class Cliente implements Serializable {

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY,
          cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinColumn(name = "cliente_id", nullable = false)
    private Set<Venda> venda;
    
    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCli;

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
    //sobrenome
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sobrenome", length = 45, nullable = false, unique = false)
    private String sobrenome;
    //email
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email", length = 45, nullable = false, unique = false)
    private String email;
    //CPF
    @NotNull
    @Size(min = 11, max = 11)
    @Column(name = "cpf", length = 11, nullable = false, unique = false)
    private String cpf;
    //celular
    @NotNull
    @Size(min = 9, max = 11)
    @Column(name = "celular", length = 11, nullable = false, unique = false)
    private String celular;
    //sexo
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexo", length = 1, nullable = false, unique = false)
    private String sexo;
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
    //Senha
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "senha", length = 45, nullable = false, unique = false)
    private String senha;
    //Data de nascimento
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @Column(name = "dataNascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    //----------------Construtores-------------------
    public Cliente() {
    }

    public Cliente(int numero, String nome, String sobrenome, String email, String cpf, String celular, String sexo, String estado, String cidade, String rua, String cep, String senha, Date dataNascimento) {
        this.numero = numero;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.celular = celular;
        this.sexo = sexo;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.cep = cep;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    //--------------------fim construtores---------------------
    public Integer getIdCli() {
        return idCli;
    }

    public void setIdCli(Integer idCli) {
        this.idCli = idCli;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
