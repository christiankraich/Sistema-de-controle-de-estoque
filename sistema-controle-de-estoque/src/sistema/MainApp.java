package sistema;

import java.sql.Connection;
import jdbc.MySQLConnection;
import gui.TelaLogin;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MainApp {

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Não foi possível aplicar o Look and Feel");
        }

        SwingUtilities.invokeLater(() -> {
            try { 
                Connection conn = MySQLConnection.getConnection();
                TelaLogin telaLogin = new TelaLogin(conn);
                telaLogin.setVisible(true);
            } catch (Exception e) {
                System.err.println("Erro ao conectar: " + e.getMessage());
            }
        });
    }
}
