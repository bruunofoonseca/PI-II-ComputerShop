/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.memoria;

import com.ComputerShop.db.utils.ConnectionUtils;
import com.ComputerShop.models.ClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author BruunoFoonseca
 */
public class DBCliente {
    //Insere um cliente na tabela "cliente" do banco de dados
    public static void inserir(ClienteModel cliente)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO cliente (NOME, SEXO, STATUS, DATANASC, ESTADOCIVIL,"
                + "CPF, TEL, CEL, EMAIL, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, "
                + "BAIRRO, CIDADE, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ? ,?, ?, ?)";
        
        //Conexão para abertura e fechamento
        Connection connection = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSexo());
            preparedStatement.setBoolean(3, true);
            Timestamp t = new Timestamp(cliente.getDataNasc().getTime());
            preparedStatement.setTimestamp(4, t);
            preparedStatement.setString(5, cliente.getEstadoCivil());
            preparedStatement.setString(6, cliente.getCpf());
            preparedStatement.setString(7, cliente.getTelefone());
            preparedStatement.setString(8, cliente.getCelular());
            preparedStatement.setString(9, cliente.getEmail());
            preparedStatement.setString(10, cliente.getLogradouro());
            preparedStatement.setString(11, cliente.getNumero());
            preparedStatement.setString(12, cliente.getComplemento());
            preparedStatement.setString(13, cliente.getCep());
            preparedStatement.setString(14, cliente.getBairro());
            preparedStatement.setString(15, cliente.getCidade());
            preparedStatement.setString(16, cliente.getEstado());
            
            //Executa o comando no banco de dados
            preparedStatement.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    //Realiza a atualização dos dados de um cliente, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Cliente"
    public static void atualizar(ClienteModel cliente)
            throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando
        //prepared statement
        String sql = "UPDATE cliente SET NOME=?, SEXO=?, STATUS=?, DATANASC=?, "
                + "ESTADOCIVIL=?, CPF=?, TEL=?, CEL=?, EMAIL=?, LOGRADOURO=?, "
                + "NUMERO=?, COMPLEMENTO=?, CEP=?, BAIRRO=?, CIDADE=?, ESTADO=? "
            + "WHERE (IDCLI=?)";
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSexo());
            preparedStatement.setBoolean(3, true);
            Timestamp t = new Timestamp(cliente.getDataNasc().getTime());
            preparedStatement.setTimestamp(4, t);
            preparedStatement.setString(5, cliente.getEstadoCivil());
            preparedStatement.setString(6, cliente.getCpf());
            preparedStatement.setString(7, cliente.getTelefone());
            preparedStatement.setString(8, cliente.getCelular());
            preparedStatement.setString(9, cliente.getEmail());
            preparedStatement.setString(10, cliente.getLogradouro());
            preparedStatement.setString(11, cliente.getNumero());
            preparedStatement.setString(12, cliente.getComplemento());
            preparedStatement.setString(13, cliente.getCep());
            preparedStatement.setString(14, cliente.getBairro());
            preparedStatement.setString(15, cliente.getCidade());
            preparedStatement.setString(16, cliente.getEstado());
            preparedStatement.setInt(17, cliente.getId());
            
            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    //Lista todos os clientes da tabela clientes
    public static List<ClienteModel> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM cliente WHERE (STATUS=?)";

        //Lista de clientes de resultado
        List<ClienteModel> listaClientes = null;

        //Conexão para abertura e fechamento
        Connection connection = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaClientes == null) {
                    listaClientes = new ArrayList<>();
                }
                
                //Cria uma instância de Cliente e popula com os valores do BD
                ClienteModel cliente = new ClienteModel();
                cliente.setId(result.getInt("IDCLI"));
                cliente.setNome(result.getString("NOME"));
                cliente.setSexo(result.getString("SEXO"));
                Date d = new Date(result.getTimestamp("DATANASC").getTime());
                cliente.setDataNasc(d);
                cliente.setAtivo(result.getBoolean("STATUS"));
                cliente.setEstadoCivil(result.getString("ESTADOCIVIL"));
                cliente.setCpf(result.getString("CPF"));
                cliente.setTelefone(result.getString("TEL"));
                cliente.setCelular(result.getString("CEL"));
                cliente.setEmail(result.getString("EMAIL"));
                cliente.setLogradouro(result.getString("LOGRADOURO"));
                cliente.setNumero(result.getString("NUMERO"));
                cliente.setComplemento(result.getString("COMPLEMENTO"));
                cliente.setCep(result.getString("CEP"));
                cliente.setBairro(result.getString("BAIRRO"));
                cliente.setCidade(result.getString("CIDADE"));
                cliente.setEstado(result.getString("ESTADO"));
                
                //Adiciona a instância na lista
                listaClientes.add(cliente);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de clientes do banco de dados
        return listaClientes;
    }
    
    //Procura um cliente no banco de dados, de acordo com o nome
    public static List<ClienteModel> procurar(String nome)
            throws SQLException, Exception {
        //Monta a string de consulta de clientes no banco, utilizando
        //o valor passado como parâmetro para busca nas colunas de
        //nome (através do "LIKE" e ignorando minúsculas
        //ou maiúsculas, através do "UPPER" aplicado à coluna e ao
        //parâmetro). Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de clientes configurada com
        //o valor correto ("enabled" com "true")
        String sql = "SELECT * FROM cliente "
                + "WHERE UPPER(NOME) LIKE UPPER(?) AND STATUS=?";
        
        //Lista de clientes de resultado
        List<ClienteModel> listaClientes = null;
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, "%" + nome + "%");
            preparedStatement.setBoolean(2, true);
            
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaClientes == null) {
                    listaClientes = new ArrayList<>();
                }
                
                //Cria uma instância de Cliente e popula com os valores do BD
                ClienteModel cliente = new ClienteModel();
                cliente.setId(result.getInt("IDCLI"));
                cliente.setNome(result.getString("NOME"));
                cliente.setSexo(result.getString("SEXO"));
                Date d = new Date(result.getTimestamp("DATANASC").getTime());
                cliente.setDataNasc(d);
                cliente.setAtivo(result.getBoolean("STATUS"));
                cliente.setEstadoCivil(result.getString("ESTADOCIVIL"));
                cliente.setCpf(result.getString("CPF"));
                cliente.setTelefone(result.getString("TEL"));
                cliente.setCelular(result.getString("CEL"));
                cliente.setEmail(result.getString("EMAIL"));
                cliente.setLogradouro(result.getString("LOGRADOURO"));
                cliente.setNumero(result.getString("NUMERO"));
                cliente.setComplemento(result.getString("COMPLEMENTO"));
                cliente.setCep(result.getString("CEP"));
                cliente.setBairro(result.getString("BAIRRO"));
                cliente.setCidade(result.getString("CIDADE"));
                cliente.setEstado(result.getString("ESTADO"));
                
                //Adiciona a instância na lista
                listaClientes.add(cliente);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        //Retorna a lista de clientes do banco de dados
        return listaClientes;        
    }
}
