package com.ComputerShop.validador;

import com.ComputerShop.exceptions.ClienteException;
import com.ComputerShop.models.ClienteModel;

//Validar cliente
public class ValidarCliente {
    public static void validar (ClienteModel cliente) throws ClienteException{
        //Validação do cadastro do cliente
        if(cliente == null) {
            throw new ClienteException("Não foi informado um cliente");
        }

        if(cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new ClienteException("Não foi informado o NOME");
        }
        
        if(cliente.getSexo() == null || "".equals(cliente.getSexo()) || (!cliente.getSexo().equals("Masculino")) 
            && !cliente.getSexo().equals("Feminino")) {
            throw new ClienteException("Não foi informado o sexo");
        }
        
        if(cliente.getDataNasc() == null) {
            throw new ClienteException("Não foi informado a Data de Nascimento");
        }

        if(cliente.getCpf().equals("   .   .   -  ")) {
            throw new ClienteException("Não foi informado o CPF");
        }

        if(cliente.getTelefone().equals("(  )    -    ")) {
            throw new ClienteException("Informe um TELEFONE");
        }
        
        //Validar endereço
        if(cliente.getLogradouro() == null || "".equals(cliente.getLogradouro())) {
            throw new ClienteException("Não foi informado logradouro");
        }
        if(cliente.getNumero() == null || "".equals(cliente.getNumero())) {
            throw new ClienteException("Não foi informado nenhum numero");
        }
        if(cliente.getCep().equals("     -   ")) {
            throw new ClienteException("Não foi informado o CEP");
        }
        if(cliente.getBairro() == null || "".equals(cliente.getBairro())) {
            throw new ClienteException("Não foi informado nenhum bairro");
        }
        if(cliente.getEstado() == null || cliente.getEstado().equals("")) {
            throw new ClienteException("Não foi informado o estado");
        }
        if (cliente.getCidade() == null || "".equals(cliente.getCidade())) {
            throw new ClienteException("Não foi informado o cidade");
        }
    }
}