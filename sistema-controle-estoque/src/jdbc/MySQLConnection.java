package jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MySQLConnection {
        
    private static final String URL = "jdbc:mysql://localhost:3306/controle_de_estoque";
    private static final String USER = "root";
    private static final String SENHA = "";
    
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
