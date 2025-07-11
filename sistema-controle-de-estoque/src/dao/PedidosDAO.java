package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Pedidos;

public class PedidosDAO {

    private final Connection conn;

    // construtor que inicializa a conexão com o banco de dados
    public PedidosDAO(Connection conn) {
        this.conn = conn;
    }

    // salva o pedido no banco de dados
    public void Salvar(Pedidos pedido) {
        String sql = "insert into pedidos (id_fornecedor, data, valor_total, status"
                + "values (?, ?, ?, ?)";
        // prepara a declaração sql
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // atribui os valores do pedido para cada parâmetro do sql
            stmt.setInt(0, pedido.getFornecedor().getId());
            stmt.setObject(1, pedido.getData());
            stmt.setDouble(2, pedido.getValorTotal());
            stmt.setString(3, pedido.getStatus().name());
            // executa o comando sql
            stmt.execute();
            // exibe a mensagem em caso de sucesso
            JOptionPane.showMessageDialog(null, "Pedido efetuado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // exibe a mensagem em caso de erro
            JOptionPane.showMessageDialog(null, "Erro ao fazer o pedido!" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int retornaUltimoIdVenda() {
        int ultimoId = 0;
        String sql = "select max(id) id from pedidos";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ultimoId = rs.getInt("id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao retornar o último id do pedido!" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return ultimoId;
    }
}
