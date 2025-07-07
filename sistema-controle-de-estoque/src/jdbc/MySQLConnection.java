package jdbc;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MySQLConnection {
        
    private static final Dotenv dotenv = Dotenv.load();

    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String SENHA = dotenv.get("DB_PASS");
    
    // faz a conexão com o banco de dados MySQL
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, SENHA);            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o Banco de Dados!");
        }
        return null;
    }
    
}
