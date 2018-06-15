/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoDrone.ModuloGerenciamento.Services;

import com.ProjetoDrone.ModuloGerenciamento.Relatorios.Venda;
import com.ProjetoDrone.ModuloGerenciamento.Relatorios.Cliente;
import com.ProjetoDrone.ModuloGerenciamento.Relatorios.VendasRelatorio;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Josué
 */
public interface RelatoriosService extends Serializable {

    public List<Cliente> listar();
    
    public List<VendasRelatorio> listarVendas(Date data_inicial, Date data_final);
    
    public List<VendasRelatorio> listarVendas(String codigoCompra);
    
    public Venda obter(String codigoCompra);
    
    public void alterar(int id, String status);
}
