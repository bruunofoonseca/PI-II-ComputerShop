/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.validador;

import com.ComputerShop.exceptions.VendaException;
import com.ComputerShop.models.PedidoModel;

/**
 *
 * @author BruunoFoonseca
 */
public class ValidarVenda {
    public static void validar(PedidoModel pedido) throws VendaException{
        
        if(pedido == null) {
            throw new VendaException("O Pedido não é válido!");
        }
        
        if(pedido.getCliente() == null) {
            throw new VendaException("Um cliente não foi selecionado "
                + "nesta venda");
        }
        
        if(pedido.getItens() == null ||
            pedido.getItens().isEmpty()) {
            throw new VendaException("É preciso escolher pelo menos um produto "
                + "para venda");
        }
    }
}
