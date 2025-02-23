package jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MySQLConnection {
        
    private static final String URL = "jdbc:mysql://localhost:3306/sistema automotivo";
    private static final String USER = "root";
    private static final String SENHA = "";
    
    public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, SENHA);            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o Banco de Dados!\n" + e);
        }
        return null;
    }
    
}
