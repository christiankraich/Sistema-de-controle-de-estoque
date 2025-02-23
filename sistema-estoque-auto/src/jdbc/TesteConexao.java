package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection conn = new MySQLConnection().getConnection();
            if(conn != null) {
                JOptionPane.showMessageDialog(null, "Conexão com o Banco de Dados bem-sucedida!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}