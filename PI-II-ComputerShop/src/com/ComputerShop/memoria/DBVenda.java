/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.memoria;

import com.ComputerShop.db.utils.ConnectionUtils;
import com.ComputerShop.models.ClienteModel;
import com.ComputerShop.models.ItemPedidoModel;
import com.ComputerShop.models.PedidoModel;
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
public class DBVenda {
    public static void inserir(PedidoModel pedido)
            throws SQLException, Exception {
        
        String sql = "INSERT INTO pedido (IDCLI, DATACOMP, VALOR) "
                + "VALUES (?, ?, ?)";
        
        //Conexão para abertura e fechamento
        Connection connection = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql, 
                    PreparedStatement.RETURN_GENERATED_KEYS);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, pedido.getCliente().getId());
            Timestamp t = new Timestamp(pedido.getDataVenda().getTime());
            preparedStatement.setTimestamp(2, t);
            preparedStatement.setFloat(3, pedido.getValorTotal());
            
            //Executa o comando no banco de dados
            preparedStatement.execute();
            
            preparedStatement.getGeneratedKeys().next();
            
            int idPedido = preparedStatement.getGeneratedKeys().getInt(1);
            
            for(int i = 0; i < pedido.getItens().size(); i++) {
                inserirItemPedido(idPedido, pedido.getItens().get(i));
            }
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
    
    private static void inserirItemPedido(int idPedido, ItemPedidoModel itemPedido)
            throws SQLException, Exception {
        
        String sql = "INSERT INTO itenspedidos (IDPROD, IDPEDIDO, QUANTIDADE, SUBTOTAL) "
                + "VALUES (?, ?, ?, ?)";
        
        //Conexão para abertura e fechamento
        Connection connection2 = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement2 = null;
        try {
            //Abre uma conexão com o banco de dados
            connection2 = ConnectionUtils.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement2 = connection2.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement2.setInt(1, itemPedido.getProduto().getId());
            preparedStatement2.setInt(2, idPedido);
            preparedStatement2.setInt(3, itemPedido.getQtd());
            preparedStatement2.setFloat(4, itemPedido.getValorParcial());
            
            //Executa o comando no banco de dados
            preparedStatement2.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement2 != null && !preparedStatement2.isClosed()) {
                preparedStatement2.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection2 != null && !connection2.isClosed()) {
                connection2.close();
            }
        }
    }
    
    public static List<ClienteModel> listar()
            throws SQLException, Exception {

        String sql = "SELECT * FROM cliente WHERE (STATUS=?)";

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
}
