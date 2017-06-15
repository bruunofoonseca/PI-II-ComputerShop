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
        String sql = "INSERT INTO produto (NOMEPROD, FABRICANTE, TIPOPROD, "
                + "QUANTIDADE, STATUS, VALOR)" 
                + " VALUES (?, ?, ?, ?, ?, ?)";
        
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
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getFabricante());
            preparedStatement.setString(3, produto.getTipoProduto());
            preparedStatement.setInt(4, produto.getQtdProduto());
            preparedStatement.setBoolean(5, true);
            preparedStatement.setFloat(6, produto.getValorProduto());
            
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
        String sql = "UPDATE produto SET NOMEPROD=?, FABRICANTE=?, TIPOPROD=?, "
                + "QUANTIDADE=?, STATUS=?, VALOR=?"
                + "WHERE IDPROD=?";
        
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
        String sql = "UPDATE produto SET STATUS=? WHERE IDPROD=?";
        
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
    
    public static List<ProdutoModel> listar()
            throws SQLException, Exception {

        String sql = "SELECT * FROM produto WHERE (STATUS=?)";

        List<ProdutoModel> listaProdutos = null;

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
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<>();
                }
                
                ProdutoModel produto = new ProdutoModel();
                produto.setId(result.getInt("IDPROD"));
                produto.setNome(result.getString("NOMEPROD"));
                produto.setFabricante(result.getString("FABRICANTE"));
                produto.setTipoProduto(result.getString("TIPOPROD"));
                produto.setQtdProduto(result.getInt("QUANTIDADE"));
                produto.setStatus(result.getBoolean("STATUS"));
                produto.setValorProduto(result.getFloat("VALOR"));
                
                //Adiciona a instância na lista
                listaProdutos.add(produto);
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
        return listaProdutos;
    }
    
    public static List<ProdutoModel> procurar(String nome)
            throws SQLException, Exception {

        String sql = "SELECT * FROM produto "
                + "WHERE UPPER(NOMEPROD) LIKE UPPER(?) AND STATUS=?";
        
        List<ProdutoModel> listaProdutos = null;
        
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
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<>();
                }
                
                ProdutoModel produto = new ProdutoModel();
                produto.setId(result.getInt("IDPROD"));
                produto.setNome(result.getString("NOMEPROD"));
                produto.setFabricante(result.getString("FABRICANTE"));
                produto.setTipoProduto(result.getString("TIPOPROD"));
                produto.setQtdProduto(result.getInt("QUANTIDADE"));
                produto.setStatus(result.getBoolean("STATUS"));
                produto.setValorProduto(result.getFloat("VALOR"));
                
                //Adiciona a instância na lista
                listaProdutos.add(produto);
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
        
        return listaProdutos;        
    }

    public static ProdutoModel obter(Integer id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM produto WHERE IDPROD=? AND STATUS=?";

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
            preparedStatement.setInt(1, id);            
            preparedStatement.setBoolean(2, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {                
                ProdutoModel produto = new ProdutoModel();
                produto.setId(result.getInt("IDPROD"));
                produto.setNome(result.getString("NOMEPROD"));
                produto.setFabricante(result.getString("FABRICANTE"));
                produto.setStatus(result.getBoolean("STATUS"));
                produto.setTipoProduto(result.getString("TIPOPROD"));
                produto.setQtdProduto(result.getInt("QUANTIDADE"));
                produto.setValorProduto(result.getFloat("VALOR"));
                
                //Retorna o resultado
                return produto;
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

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        return null;
    }
}