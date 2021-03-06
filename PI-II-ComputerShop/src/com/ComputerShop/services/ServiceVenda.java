/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.services;

import com.ComputerShop.exceptions.VendaException;
import com.ComputerShop.exceptions.DataSourceException;
import com.ComputerShop.memoria.MemoriaVenda;
import com.ComputerShop.models.PedidoModel;
import com.ComputerShop.memoria.DBVenda;
import com.ComputerShop.validador.ValidarVenda;
import java.util.List;

/**
 *
 * @author BruunoFoonseca
 */
public class ServiceVenda {
    
    public static void cadastraPedido (PedidoModel pedido) throws VendaException, DataSourceException {
        
        ValidarVenda.validar(pedido);
        
        try {
//            MemoriaVenda.inserir(pedido);
            
            DBVenda.inserir(pedido);
        }catch(Exception e){
            //Informar erro
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static List<PedidoModel> listarPedidos() throws VendaException, DataSourceException {
        try{
//            return MemoriaVenda.listar();
            
            //Chama função do DB
            return DBVenda.listar();
        } catch (Exception e){
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}