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
        
        if(prod.getNome() == null || "".equals(prod.getNome())){
            throw new ProdutoException("É necessario informar a NOME do produto");
        }
        
        if (prod.getFabricante() == null || "".equalsIgnoreCase(prod.getFabricante())){
            throw new ProdutoException("Não foi informado FABRICANTE do produto");
        }
        
        if(prod.getTipoProduto() == null || "".equalsIgnoreCase(prod.getTipoProduto())){
            throw new ProdutoException("Não foi informado TIPO do produto");
        }
        
        if(prod.getQtdProduto() == 0 || "".equals(prod.getQtdProduto())){
            throw new ProdutoException("Não foi informado QUANTIDADE do produto");
        }
        
        if(prod.getValorProduto() == null || "".equals(prod.getValorProduto())){
           throw new ProdutoException("O VALOR do produto não pode estar vazio ou zero");
        }
        
        if(prod.getDtFabricacao() == null || prod.getDtFabricacao().equals("") || prod.getDtFabricacao().equals("  /  /    ")) {
            throw new ProdutoException("Não foi informado Data de Fabricação!");
        }
        
        if(prod.getGarantia() < 0) {
            throw new ProdutoException("Garantia não pode ser menor que zero!");
        }
    }
}