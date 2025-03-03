package jdbc;

import java.sql.Connection;
import javax.swing.JOptionPane;

public class TesteConexao {
    public static void main(String[] args) {
        Connection conn = new MySQLConnection().getConnection();
        if (conn != null) {
            JOptionPane.showMessageDialog(null, "Conexão com o Banco de Dados bem-sucedida!");
        }
    }
    
}