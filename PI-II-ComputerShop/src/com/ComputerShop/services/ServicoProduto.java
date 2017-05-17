/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.services;

import com.ComputerShop.exceptions.ProdutoException;
import com.ComputerShop.models.ProdutoModel;
import com.ComputerShop.model.validador.ValidarProduto;
import com.ComputerShop.memoria.memoriaProduto;

/**
 *
 * @author diogo
 */
public class ServicoProduto {
    
    // Inserir cliente
    
    public static void inserirProduto (ProdutoModel prod)
            throws ProdutoException {
        
        
        // estou validando se houve algum erro no objeto ProdutoModel
        ValidarProduto.validar(prod);
        
        try {
            
            memoriaProduto.inserir(prod);
            
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println("Verifique a classe ProdutoModel");
        }
    }
    
    
}
