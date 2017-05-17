/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.validador;

import com.ComputerShop.exceptions.ProdutoException;
import com.ComputerShop.models.ProdutoModel;
/**
 *
 * @author diogo
 */
public class ValidarProduto {
    public static void validar(ProdutoModel prod) throws ProdutoException{
        
        if(prod == null){ // verificar se houve algum produto cadastrado
            throw new ProdutoException("Não foi informado nenhum produto");
        }
        
        if(prod.getNome() == null || "".equalsIgnoreCase(prod.getNome())){
            throw new ProdutoException("É necessario informar a DESCRICAO do produto");
        }
        
        if (prod.getFabricante() == null || "".equalsIgnoreCase(prod.getFabricante())){
            throw new ProdutoException("Não foi informado FABRICANTE do produto");
        }
        
        if(prod.getQtdProduto() == 0 || "".equals(prod.getQtdProduto())){
            throw new ProdutoException("Não foi informado QUANTIDADE do produto");
        }
        
        if(prod.getValorProduto() == 0 || "".equals(prod.getValorProduto())){
            throw new ProdutoException("O VALOR do produto não pode estar vazio ou zero");
        }
        
        if(prod.getTipoProduto() == null || "".equalsIgnoreCase(prod.getTipoProduto())){
            throw new ProdutoException("Não foi informado TIPO do produto");
        }
        
    }
    
}
