/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.memoria;

import com.ComputerShop.db.utils.ConnectionUtils;
import com.ComputerShop.models.ClienteModel;
import com.ComputerShop.models.PedidoModel;
import com.ComputerShop.models.VendaModel;
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
    public static void inserir(VendaModel pedido)
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
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, pedido.getCliente().getId());
            Timestamp t = new Timestamp(pedido.getDataVenda().getTime());
            preparedStatement.setTimestamp(2, t);
            preparedStatement.setFloat(3, pedido.getValorTotal());
            
            //Executa o comando no banco de dados
            preparedStatement.execute();
            
            preparedStatement.getGeneratedKeys().next();
            
            int idPedido = preparedStatement.getGeneratedKeys().getInt(1);
            
            for(int i = 0; i < pedido.getPedidos().size(); i++) {
                inserirItemPedido(idPedido, pedido.getPedidos().get(i));
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
    
    private static void inserirItemPedido(int idPedido, PedidoModel itemPedido)
            throws SQLException, Exception {
        
        String sql = "INSERT INTO pedido (IDPROD, IDPEDIDO, QUANTIDADE, SUBTOTAL) "
                + "VALUES (?, ?, ?, ?)";
        
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
            preparedStatement.setInt(1, itemPedido.getProduto().getId());
            preparedStatement.setInt(2, idPedido);
            preparedStatement.setInt(3, itemPedido.getQtd());
            preparedStatement.setFloat(3, itemPedido.getValorParcial());
            
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
}
