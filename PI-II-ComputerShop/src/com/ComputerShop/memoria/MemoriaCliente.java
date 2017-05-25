package com.ComputerShop.memoria;

import com.ComputerShop.models.ClienteModel;
import java.util.*;

public class MemoriaCliente {
    //Armazena Clientes cadastrados
      private static int totalClientes = 0;  
      private static List<ClienteModel> listaClientes = new ArrayList<ClienteModel>();
    
    //Inserir Clientes no mock  
    public static void inserir(ClienteModel cliente)
        throws Exception {
        cliente.setId(totalClientes++);
        listaClientes.add(cliente);
        }
    
    public static void atualizar (ClienteModel clienteProcura)
            throws Exception{
        if (clienteProcura != null && clienteProcura.getId() != null && !listaClientes.isEmpty()) {
            for (ClienteModel listCliente : listaClientes) {
                if(listCliente != null && listCliente.getId() == clienteProcura.getId()){
                   listCliente.setNome(clienteProcura.getNome());
                   listCliente.setSexo(clienteProcura.getSexo());
                   listCliente.setDataNascimento(clienteProcura.getDataNascimento());
                   listCliente.setEstadoCivil(clienteProcura.getEstadoCivil());
                   listCliente.setCpf(clienteProcura.getCpf());
                   listCliente.setTelefone(clienteProcura.getTelefone());
                   listCliente.setCelular(clienteProcura.getCelular());
                   listCliente.setEmail(clienteProcura.getEmail());
                   break;
                }
            }
        }
    }
    
    //Excluir o cliente com ID fornecido
    public static void excluir(String cpf) throws Exception{
        if(cpf != null && !listaClientes.isEmpty()){
            for(int i = 0; i<listaClientes.size(); i++){
                ClienteModel clienteLi = listaClientes.get(i);
                if(clienteLi != null && clienteLi.getCpf() == cpf){
                    listaClientes.remove(i);
                    break;
                }
            }
        }
    }
    
    //Lista os clientes
    public static List<ClienteModel> listar()
            throws Exception{
        //Retorna lista de clientes
        return listaClientes;
    }
    
    
    //Procurar Clientes no mock
    public static List<ClienteModel> procurar (String nome)
        throws Exception{
        List<ClienteModel> listaResultado = new ArrayList<ClienteModel>();
        
        if(nome != null && !listaClientes.isEmpty()){
            for(ClienteModel clienteList : listaClientes){
                if(clienteList != null && clienteList.getNome() != null){
                    if(clienteList.getNome().toUpperCase().contains(nome.toUpperCase())){
                        listaResultado.add(clienteList);
                    }
                }
            }
        }
        //Retorna resulta de pesquisa
        return listaResultado;
    }
    
    
    
    
    // Obtem um cliente da lista
    public static ClienteModel obter(String cpf)
            throws Exception{
        if(cpf != null && !listaClientes.isEmpty()){
            for (int i = 0; i < listaClientes.size(); i++) {
                if(listaClientes.get(i) != null && listaClientes.get(i).getCpf() == cpf){
                    return listaClientes.get(i);
                }
            }
        }
        return  null;
    }
        
        
    }
      
      
      

