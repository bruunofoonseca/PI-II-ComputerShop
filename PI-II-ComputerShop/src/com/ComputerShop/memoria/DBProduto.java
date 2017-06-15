package com.ComputerShop.memoria;

import com.ComputerShop.db.utils.ConnectionUtils;
import com.ComputerShop.models.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author diogo
 */
public class DBProduto {
    
    // insere um produto na tabela produto
    public static void inserir(ProdutoModel produto)
            throws SQLException, Exception{
        
        // construindo a strin de inserção no BD na tabela produto
        String sql = "INSERT INTO PRODUTO (IdProd, NomeProd, Fabricante, TipoProd, Quantidade, Status, Valor)" 
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        // conexao para abertura e fechamento do BD
        Connection connection = null;
        // Statement para obtenção atraves da conexão, execuçao
        // comandos SQL
        PreparedStatement preparedStatement = null;
        try {
            // abrindo conexão
            connection = ConnectionUtils.getConnection();
            // criar um preparedStatement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            // configura os parametros do preparedStatement
            preparedStatement.setInt(1, produto.getId());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setString(3, produto.getFabricante());
            preparedStatement.setString(4, produto.getTipoProduto());
            preparedStatement.setInt(5, produto.getQtdProduto());
            preparedStatement.setBoolean(6, true);
            preparedStatement.setFloat(7, produto.getValorProduto());
            
            // executa o comando SQL
            preparedStatement.execute();
        } finally{
            // Se o preparedStatement ainda estiver aberto, realiza fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }
    
    // Realiza a atualização do produto, conforme ID e dados
    // passados como parametros
    public static void atualizar(ProdutoModel produto)
            throws SQLException, Exception {
        // String de update no BD
        String sql = "UPDATE produto SET NomeProd=?, Fabricante=?, TipoProd=?, Quantidade=?, Status=?, Valor=?"
                + "WHERE (produto_id=?)";
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            // abrindo conexão
            connection = ConnectionUtils.getConnection();
            // Criar um preparedStatement para executar instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            // configurando os parametros para update
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getFabricante());
            preparedStatement.setString(3, produto.getTipoProduto());
            preparedStatement.setInt(4, produto.getQtdProduto());
            preparedStatement.setBoolean(5, true);
            preparedStatement.setFloat(6, produto.getValorProduto());
            preparedStatement.setInt(7, produto.getId());
        } finally {
            //Se o preparedStatement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    // Realiza a exclusão logica de um produto, no BD
    // como parametro. A exclusão apenas ira INATIVAR o 
    // produto em todas as tela de pesquisa
    public static void excluir(Integer id) throws SQLException, Exception{
        // String de exclusão, a partir de um ID
        String sql = "UPDATE produto SET enable=? WHERE (quarto_id)";
        // conexão para abertura e fechamento no BD
         Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um preparedStatement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do prepared preparedStatement
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);
            
            // executa o comando no BD
            preparedStatement.execute();
    } finally {
            //Se o preparedStatement ainda estiver aberto, realiza seu fechamento
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
