package com.ComputerShop.memoria;

import com.ComputerShop.models.ProdutoModel;
import java.util.ArrayList;
import java.util.List;


// essa clase ira armazenar na memoria do java

public class memoriaProduto {
    
    private static int numProdutos = 0;
    
    private static List<ProdutoModel> listaProdutos = new ArrayList<ProdutoModel>();
    
    
    // Inserindo clientes
    public static void inserir(ProdutoModel prod)
        throws Exception{
        
        prod.setId(numProdutos++);
        listaProdutos.add(prod);
        
    }
}
