/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Relatorios;


import java.util.Date;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Nakamura-PC
 */
public class DatasRelat {
    
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataInicio;
    
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataFim;

    public DatasRelat() {
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
}
