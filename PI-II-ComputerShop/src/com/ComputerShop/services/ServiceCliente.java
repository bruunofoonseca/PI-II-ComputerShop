package com.ComputerShop.services;

import com.ComputerShop.exceptions.ClienteException;
import com.ComputerShop.exceptions.DataSourceException;
import com.ComputerShop.models.CadastraCliente;
import com.ComputerShop.mock.MockCadastrarCliente;
import com.ComputerShop.models.ValidarCliente;
import java.util.List;

// Classe de serviços de Clientes
public class ServiceCliente {
    
    //Cadastra Cliente nas fonte de dados
    public static void cadastraClien (CadastraCliente cliente)
            throws ClienteException, DataSourceException {
        
        //Chamar a função pra validar cliente
        ValidarCliente.validar(cliente);
        
        try {
            //Chama a função de mock
            MockCadastrarCliente.inserir(cliente);
        }catch(Exception e){
            //Informar erro
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    //Atualizar cliente
    public static void atualizarCliente (CadastraCliente cliente)
            throws ClienteException, DataSourceException {
        
        //Chamar a função pra validar cliente
        ValidarCliente.validar(cliente);
        
        //Realizar chamada de atualização
        try {
            MockCadastrarCliente.atualizar(cliente);
            return; 
        }catch (Exception e){
            /*Imprime qualquer erro técnico no console e devolve
            uma exceção e uma mensagem amigável a camada de visão*/
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    
    //Realizar pesquisa de clientes por nome
    public static List<CadastraCliente> procurarCliente(String nome)
            throws ClienteException, DataSourceException{
        try{
            /*Verificar se foi digite o nome na pesquisa,
            se não, ira retorna uma listagem.
            se sim, ira retorna o que foi pesquisado
            */
            if(nome == null || "".equals(nome)){
                return MockCadastrarCliente.listar();
            }else{
                return MockCadastrarCliente.procurar(nome);
            }
            
        }catch (Exception e){
            /*Imprime qualquer erro técnico no console e devolve
            uma exceção e uma mensagem amigável a camada de visão*/
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    //Obtem o cliente informado pelo ID
    public static CadastraCliente obterCliente(Integer id)
            throws ClienteException, DataSourceException{
        try{
            //Retorna o cliente obtido
           return MockCadastrarCliente.obter(id);
        }catch (Exception e){
            /*Imprime qualquer erro técnico no console e devolve
            uma exceção e uma mensagem amigável a camada de visão*/
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static void excluirCliente(Integer id)
            throws ClienteException, DataSourceException{
        try{
            //Solicita a exlusão do cliente
            MockCadastrarCliente.excluir(id);
        }catch (Exception e){
            /*Imprime qualquer erro técnico no console e devolve
            uma exceção e uma mensagem amigável a camada de visão*/
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
}
