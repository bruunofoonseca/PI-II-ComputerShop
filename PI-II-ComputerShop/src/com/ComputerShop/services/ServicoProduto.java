/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.services;

import com.ComputerShop.exceptions.ProdutoException;
import com.ComputerShop.models.ProdutoModel;
import com.ComputerShop.validador.ValidarProduto;
import com.ComputerShop.memoria.memoriaProduto;
import java.util.List;

/**
 *
 * @author diogo
 */
public class ServicoProduto {
    
    // Inserir produto
    
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
    
    
    // Procura Cliente
    public static List<ProdutoModel> localizarProduto(String nomeProd)
                throws ProdutoException{
                
        try {
            // Exceção vai verificar se houve preenchimento do campo de pesquisa
            // caso tenha algo digitado traz resultado
            if (nomeProd == null || "".equalsIgnoreCase(nomeProd)) {
                return memoriaProduto.listarTodosProdutos();
                
            } else {
                return memoriaProduto.listarSomentePalavra(nomeProd);

            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
    }
    
}
