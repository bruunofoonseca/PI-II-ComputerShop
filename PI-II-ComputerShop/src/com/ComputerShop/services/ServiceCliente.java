package com.ComputerShop.services;

import com.ComputerShop.exceptions.ClienteException;
import com.ComputerShop.exceptions.DataSourceException;
import com.ComputerShop.models.ClienteModel;
import com.ComputerShop.memoria.MemoriaCliente;
import com.ComputerShop.validador.ValidarCliente;
import com.ComputerShop.memoria.DBCliente;
import java.util.List;

// Classe de serviços de Clientes
public class ServiceCliente {
    
    //Cadastra Cliente nas fonte de dados
    public static void cadastraClien (ClienteModel cliente)
            throws ClienteException, DataSourceException {
        
        //Chamar a função pra validar cliente
        ValidarCliente.validar(cliente);
        
        try {
//            //Chama a função de mock
//            MemoriaCliente.inserir(cliente);
            
            //Chama a função do DB
            DBCliente.inserir(cliente);
        }catch(Exception e){
            //Informar erro
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    //Atualizar cliente
    public static void atualizarCliente (ClienteModel cliente)
            throws ClienteException, DataSourceException {
        
        //Chamar a função pra validar cliente
        ValidarCliente.validar(cliente);
        
        //Realizar chamada de atualização
        try {
//            MemoriaCliente.atualizar(cliente);
            
            //Chama função do DB
            DBCliente.atualizar(cliente);
        }catch (Exception e){
            /*Imprime qualquer erro técnico no console e devolve
            uma exceção e uma mensagem amigável a camada de visão*/
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    //Realizar pesquisa de clientes por nome
    public static List<ClienteModel> procurarCliente(String nome)
            throws ClienteException, DataSourceException{
        try{
            /*Verificar se foi digite o nome na pesquisa,
            se não, ira retorna uma listagem.
            se sim, ira retorna o que foi pesquisado
            */
            if(nome == null || "".equals(nome)){
//                return MemoriaCliente.listar();
                
                //Chama função do DB
                return DBCliente.listar();
            }else{
//                return MemoriaCliente.procurar(nome);
                
                //Chama função do DB
                return DBCliente.procurar(nome);
            }
            
        }catch (Exception e){
            /*Imprime qualquer erro técnico no console e devolve
            uma exceção e uma mensagem amigável a camada de visão*/
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    //Obtem o cliente informado pelo ID
    public static ClienteModel obterCliente(String cpf)
            throws ClienteException, DataSourceException{
        try{
            //Retorna o cliente obtido
           return MemoriaCliente.obter(cpf);
        }catch (Exception e){
            /*Imprime qualquer erro técnico no console e devolve
            uma exceção e uma mensagem amigável a camada de visão*/
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static void excluirCliente(String cpf)
            throws ClienteException, DataSourceException{
        try{
            //Solicita a exlusão do cliente
            MemoriaCliente.excluir(cpf);
        }catch (Exception e){
            /*Imprime qualquer erro técnico no console e devolve
            uma exceção e uma mensagem amigável a camada de visão*/
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}