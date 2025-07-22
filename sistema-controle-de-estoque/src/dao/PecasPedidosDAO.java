package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.PecasPedidos;

public class PecasPedidosDAO {
    
    private final Connection conn;
    
    public PecasPedidosDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void salvar(PecasPedidos pecasPedidos) {
        String sql = "insert into pecas_pedidos (id_peca, id_pedido, quantidade, subtotal)"
                + "value (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pecasPedidos.getPecas().getId());
            stmt.setInt(2, pecasPedidos.getPedidos().getId());
            stmt.setInt(3, pecasPedidos.getQuantidade());
            stmt.setDouble(4, pecasPedidos.getSubtotal());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar os itens do pedido!");
        }
    }
    
}
