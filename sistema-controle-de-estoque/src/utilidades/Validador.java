package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validador {
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public boolean campoNome(JTextField campoNome) {
        String nome = campoNome.getText();
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O nome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);        
            return false;
        }
        
        if (nome.length() < 3) {
            JOptionPane.showMessageDialog(null, "O nome deve ter ao menos 3 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean campoCpf(JTextField campoCpf) {
        String cpf = campoCpf.getText();
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O CPF não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);        
            return false;
        }
        
        //if (cpf.lentgh)
        return true;        
    }
    
    public Date campoData(JTextField campoData) {
        Date data = obterDataValida(campoData.getText());
        if (data == null) {
            JOptionPane.showMessageDialog(null, "Data inválida ou no futuro.\nForneça uma data válida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
    
    public Date obterDataValida(String dataNasc) {
        try {
            sdf.setLenient(false);
            Date data = sdf.parse(dataNasc);
            if (data.after(new Date())) {
                return null;
            }
            return data;
        } catch (ParseException e) {
            return null;
        }
    }
    
}
