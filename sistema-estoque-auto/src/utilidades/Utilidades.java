package utilidades;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Utilidades {
    
    public void limparCampos(JPanel painel) {
        Component componentes[] = painel.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JTextField jTextField) {
                jTextField.setText("");
            }
            if (componente instanceof JComboBox jComboBox) {
                jComboBox.setSelectedItem("---");
            }
        }
    }
    
}
