package com.ComputerShop.db.utils;

import com.ComputerShop.constants.MainConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author diogo
 */

//Obtem um objeto de conexao
// Pode ser usado para abrir conexao e fechar
public class ConnectionUtils {
    
    //Obtem uma conexao
    public static Connection getConnection(){
    
        // Conexao para abertura e fechamento
        Connection connection = null;
        try {
            // Só tenta abrir conecao caso nao exista nenhuma aberta
            String dbURL = MainConstants.DB_ADRESS;
            //Propriedades para guarda usuario e senha
            Properties properties = new Properties();
            properties.put("user", MainConstants.DB_USER);
            properties.put("password", MainConstants.DB_PASS);
            // realiza conexao com banco
            connection = DriverManager.getConnection(dbURL, properties);

        } catch(SQLException ex){
            ex.printStackTrace();
        }

        return connection;
    }
}
