/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.controllers;

import java.util.List;

import com.ComputerShop.models.ClienteModel;
import java.util.ArrayList;

/**
 *
 * @author BruunoFoonseca
 */

public class ClienteController {
    
    List<ClienteModel> cliente = new ArrayList<ClienteModel>();
    
    public void insereCliente(ClienteModel cliente) {
        this.cliente.add(cliente);
    }
    
    public List<ClienteModel> listarClientes() {
        return this.cliente;
    }
}
