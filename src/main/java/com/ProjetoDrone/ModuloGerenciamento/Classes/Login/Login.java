/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Classes.Login;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Nakamura-PC
 */
public class Login {

    @NotNull
    @Size(min = 1, max = 45)
    private String user;

    @NotNull
    @Size(min = 1, max = 20)
    private String senha;

    public Login() {
    }

    public Login(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public String getUser() {
        return user.trim();
    }

    public void setUser(String user) {
        this.user = user.trim();
    }

    public String getSenha() {
        return senha.trim();
    }

    public void setSenha(String senha) {
        this.senha = senha.trim();
    }
}
