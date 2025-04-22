package utilidades;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LimpaComponente {

    // limpa todos os campos de texto e combo boxes de um painel específico
    public void limparCampos(JPanel painel) {
        Component componentes[] = painel.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JTextField jTextField) {
                jTextField.setText("");
            }
            if (componente instanceof JComboBox jComboBox) {
                jComboBox.setSelectedIndex(0);
            }
        }
    }

    // remove todas as linhas de uma tabela, mantendo apenas as colunas
    public void limparTabela(JTable tabela) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
    }
}
