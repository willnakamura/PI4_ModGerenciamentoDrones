/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Classes.Funcionario;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Rafael Rodrigues
 */

@Entity
@Table(name = "Funcionario")
public class Funcionario implements Serializable {

    @Id
    @Column(name = "func_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFunc;

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
    public Funcionario() {
    }

    public Funcionario(String nome, String sobrenome, String email, String cpf,
            String celular, String sexo, String senha, Date dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.celular = celular;
        this.sexo = sexo;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    //--------------------fim construtores---------------------
    public Integer getIdCli() {
        return idFunc;
    }

    public void setIdCli(Integer idFunc) {
        this.idFunc = idFunc;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNome() {
        return nome.trim();
    }

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    public String getSobrenome() {
        return sobrenome.trim();
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome.trim();
    }

    public String getEmail() {
        return email.trim();
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getCpf() {
        return cpf.trim();
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.trim();
    }

    public String getSexo() {
        return sexo.trim();
    }

    public void setSexo(String sexo) {
        this.sexo = sexo.trim();
    }

    public String getSenha() {
        return senha.trim();
    }

    public void setSenha(String senha) {
        this.senha = senha.trim();
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
