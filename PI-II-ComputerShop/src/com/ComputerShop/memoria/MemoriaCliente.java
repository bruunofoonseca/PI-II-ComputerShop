package com.ComputerShop.mock;

import com.ComputerShop.models.CadastraCliente;
import java.util.*;

public class MemoriaCliente {
    //Armazena Clientes cadastrados
      private static int totalClientes = 0;  
      private static List<CadastraCliente> listaClientes = new ArrayList<CadastraCliente>();
    
    //Inserir Clientes no mock  
    public static void inserir(CadastraCliente cliente)
        throws Exception {
        cliente.setId(totalClientes++);
        listaClientes.add(cliente);
        }
    
    public static void atualizar (CadastraCliente clienteProcura)
            throws Exception{
        if (clienteProcura != null && clienteProcura.getId() != null && !listaClientes.isEmpty()) {
            for (CadastraCliente listCliente : listaClientes) {
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
    public static void excluir(Integer id) throws Exception{
        if(id != null && !listaClientes.isEmpty()){
            for(int i = 0; i<listaClientes.size(); i++){
                CadastraCliente clienteLi = listaClientes.get(i);
                if(clienteLi != null && clienteLi.getId() == id){
                    listaClientes.remove(i);
                    break;
                }
            }
        }
    }
    
    //Lista os clientes
    public static List<CadastraCliente> listar()
            throws Exception{
        //Retorna lista de clientes
        return listaClientes;
    }
    
    
    //Procurar Clientes no mock
    public static List<CadastraCliente> procurar (String nome)
        throws Exception{
        List<CadastraCliente> listaResultado = new ArrayList<CadastraCliente>();
        
        if(nome != null && !listaClientes.isEmpty()){
            for(CadastraCliente clienteList : listaClientes){
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
    public static CadastraCliente obter(Integer id)
            throws Exception{
        if(id != null && !listaClientes.isEmpty()){
            for (int i = 0; i < listaClientes.size(); i++) {
                if(listaClientes.get(i) != null && listaClientes.get(i).getId() == id){
                    return listaClientes.get(i);
                }
            }
        }
        return  null;
    }
        
        
    }
      
      
      

