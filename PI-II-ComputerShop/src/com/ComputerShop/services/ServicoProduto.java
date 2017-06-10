/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.services;

import com.ComputerShop.exceptions.ProdutoException;
import com.ComputerShop.exceptions.DataSourceException;
import com.ComputerShop.models.ProdutoModel;
import com.ComputerShop.validador.ValidarProduto;
import com.ComputerShop.memoria.MemoriaProduto;
import java.util.List;

/**
 *
 * @author diogo
 */
public class ServicoProduto {
    
    // Inserir produto
    
    public static void inserirProduto(ProdutoModel prod)
            throws ProdutoException, DataSourceException {
        
        
        // estou validando se houve algum erro no objeto ProdutoModel
        ValidarProduto.validar(prod);
        
        try {
            // nesse momento chama o metodo que vai gravar no atributo da classe
            MemoriaProduto.inserir(prod);
            
        } catch (Exception e) {
            
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    
    public static void atualizarProduto(ProdutoModel prod)
    throws ProdutoException, DataSourceException{
        
        // chama o validado para verificar o produto
        
        try {
            // realiza a chamada de atualizar o produto
            MemoriaProduto.atualiza(prod);
            return;
            
        } catch (Exception e) {
            // imprimir erro tecnico no consile
            throw new DataSourceException("Erro na fonte de dados", e);
        }
        
    }
    
    
    // Procura Cliente
    
    public static List<ProdutoModel> localizarProduto(String nomeProd)
                throws ProdutoException, DataSourceException{
                
        try {
            // Exceção vai verificar se houve preenchimento do campo de pesquisa
            // caso tenha algo digitado traz resultado
            if (nomeProd == null || "".equals(nomeProd)) {
                return MemoriaProduto.listarTodosProdutos();
                
            } else {
                return MemoriaProduto.listarSomentePalavra(nomeProd);

            }
        } catch (Exception e) {
            
            throw new DataSourceException("Erro na fonte de dados, e");
            
        }
        
    }
    
    
    public static ProdutoModel obterProduto (Integer id)
        throws ProdutoException, DataSourceException {
            
        try {
            
            return MemoriaProduto.obter(id);
            
        } catch (Exception e) {
            
            throw new DataSourceException("Erro na fonte de dados", e);
        }
        
    }
    
    
    // excluir produto
    
    public static void excluirProduto(Integer id) throws ProdutoException, DataSourceException{
        
        try {
            // solicita a memoria a exclusão do produto
            MemoriaProduto.excluir(id);
        } catch (Exception e) {
            
            // imprimir algum erro caso não consiga excluir
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
        
        
    }
        
}
    

