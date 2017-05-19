package com.ComputerShop.models;

import com.ComputerShop.exceptions.ClienteException;

//Validar cliente
public class ValidarCliente {
        public static void validar (CadastraCliente cliente) throws ClienteException{
           //Validação do cadastro do cliente
           if(cliente == null){
               throw new ClienteException("Não foi informado um cliente");
           }
           if(cliente.getNome() == null || "".equals(cliente.getNome())){
               throw new ClienteException("Não foi informado o NOME");
           }
           if(cliente.getCpf() == null || "".equals(cliente.getCpf())){
               throw new ClienteException("Não foi informa um CPF");
           }
           if(cliente.getTelefone() == null || "".equals(cliente.getTelefone()) 
           || cliente.getCelular() == null || "".equals(cliente.getCelular())){
               throw new ClienteException("Não foi informado nenhum telefone de contato");
           }
           /*if(cliente.getSexo() == null || "".equals(cliente.getSexo())){
               throw new ClienteException("Não foi informado o sexo");
           }*/
           
           //Validar endereço do cliente
           if(cliente.getLogradouro() == null || "".equals(cliente.getLogradouro())){
               throw new ClienteException("Não foi informado logradouro");
           }
           if(cliente.getNumero() == null || "".equals(cliente.getNumero())){
               throw new ClienteException("Não foi informado nenhum numero");
           }
           if(cliente.getCep() == null || "".equals(cliente.getCep())){
               throw new ClienteException("Não foi informado o CEP");
           }
           if(cliente.getBairro() == null || "".equals(cliente.getBairro())){
               throw new ClienteException("Não foi informado nenhum bairro");
           }
           if(cliente.getEstado() == null || "".equals(cliente.getEstado())){
               throw new ClienteException("Não foi informado o estado");
           }
            if (cliente.getCidade() == null || "".equals(cliente.getEstado())) {
                throw new ClienteException("Não foi informado o cidade");
            }
           
           
        }
    
}
