package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.OrdemDeServico;

public class OrdemDeServicoDAO {
    
    private final Connection conn;
    
    public OrdemDeServicoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void salvar(OrdemDeServico ordemDeServico) {
        String sql = "insert into ordem_de_servico (id_cliente, id_funcionario, "
                + "descricao, valor_total, observacoes, status)"
                + "values (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ordemDeServico.getCliente().getId());
            stmt.setInt(2, ordemDeServico.getFuncionario().getId());
            stmt.setString(3, ordemDeServico.getDescricao());
            stmt.setDouble(4, ordemDeServico.getValorTotal());
            stmt.setString(5, ordemDeServico.getObservacoes());
            stmt.setString(6, ordemDeServico.getStatus().name());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Ordem de Serviço criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar Ordem de Serviço." + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
