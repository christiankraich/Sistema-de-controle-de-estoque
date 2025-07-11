package jdbc;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class MySQLConnection {
        
    private static Connection conn;
    private static final Dotenv dotenv = Dotenv.load();

    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String SENHA = dotenv.get("DB_PASS");
    
    // faz a conexão com o banco de dados 
    public static Connection getConnection() throws SQLException { 
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(URL, USER, SENHA);
        }
        return conn;
    }
    
    // fecha a conexão com o banco de dados
    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}
