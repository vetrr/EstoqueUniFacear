package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    protected static String url = "jdbc:postgresql://10.20.2.64:5432/EstoqueUniFacear";
    protected static String usuario = "estoque";
    protected static String senha = "Unifacear@2026";

    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        }
        catch (SQLException e) {
            throw new RuntimeException("A conexão falhou: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        getConnection();
    }

}
