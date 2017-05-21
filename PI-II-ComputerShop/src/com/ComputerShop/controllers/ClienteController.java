/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.controllers;
  
import java.util.List;
 
import com.ComputerShop.models.CadastraCliente;
import java.util.ArrayList;
 
/**
 *
 * @author BruunoFoonseca
 */
 
public class ClienteController {
      
    List<CadastraCliente> cliente = new ArrayList<CadastraCliente>();
     
    public void insereCliente(CadastraCliente cliente) {
        this.cliente.add(cliente);
    }
    
    public List<CadastraCliente> listarClientes() {
        return this.cliente;
    }
}