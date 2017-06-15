/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.models;

import java.util.List;

/**
 *
 * @author BruunoFoonseca
 */
public class RelatorioModel {
    
    private List<PedidoModel> vendas;

    public List<PedidoModel> getVendas() {
        return vendas;
    }

    public void setVendas(List<PedidoModel> vendas) {
        this.vendas = vendas;
    }
    
}
