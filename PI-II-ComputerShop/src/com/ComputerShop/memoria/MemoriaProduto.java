package com.ComputerShop.memoria;

import com.ComputerShop.models.ProdutoModel;
import java.util.ArrayList;
import java.util.List;


// essa clase ira armazenar na memoria do java

public class MemoriaProduto {
    
    private static int numProdutos = 0;
    
    private static List<ProdutoModel> listaProdutos = new ArrayList<ProdutoModel>();
    
    
    // Inserindo Produto
    public static void inserir(ProdutoModel prod)
        throws Exception{
        
        prod.setId(numProdutos++);
        listaProdutos.add(prod);
        
    }
    
    // Localizar ou listar todos os Produto
    public static List<ProdutoModel> listarTodosProdutos()
            throws Exception{
        // ira retorna a lista do objeto produto
        return listaProdutos;
    }
    
    public static List<ProdutoModel> listarSomentePalavra(String valor)
            throws Exception {
        
        List<ProdutoModel> listaResultadoProdutos = new ArrayList<ProdutoModel>();
        
        if(valor != null && !listaProdutos.isEmpty()){
            
            for (ProdutoModel prodLista : listaProdutos){
                if(prodLista != null && prodLista.getNome() != null){
                    if(prodLista.getNome().toUpperCase().contains(valor.toUpperCase())){
                        listaResultadoProdutos.add(prodLista);
                    }
                }
            }
            
        }
        
        return listaResultadoProdutos;
        
    }
    
    
    public static ProdutoModel obter(Integer id)
        throws Exception{
        
        if(id != null && ! listaProdutos.isEmpty()){
            for (int i = 0; i < listaProdutos.size(); i++) {
                if(listaProdutos.get(i) != null && listaProdutos.get(i).getId() == id){
                    return listaProdutos.get(i);
                }
            }
        }
        
        return null;
    }
    
    
    // excluir
    
    public static void excluir(Integer id) throws Exception {
        if(id != null && !listaProdutos.isEmpty()){
            for(int i = 0; i < listaProdutos.size(); i++){
                ProdutoModel prod = listaProdutos.get(i);
                if(prod != null && prod.getId() == id){
                    listaProdutos.remove(i);
                    break;
                }
            }
        }
    }
    
    
    
}
