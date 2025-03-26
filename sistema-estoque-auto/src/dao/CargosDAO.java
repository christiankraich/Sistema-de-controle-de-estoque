package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.MySQLConnection;
import model.Cargos;

public class CargosDAO {
    
    private final Connection conn;

    public CargosDAO() {
        this.conn = new MySQLConnection().getConnection();
    }
    
    public void salvar(Cargos cargo) {
        String sql = "insert into cargos (nome) values (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cargo.getNome());
            
            stmt.execute();
            
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cargo salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o cargo. " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public List<Cargos> listar() {
        List<Cargos> lista = new ArrayList<>();
        String sql = "select * from cargos";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Cargos cargo = new Cargos();
                cargo.setId(rs.getInt("id"));
                cargo.setNome(rs.getString("nome"));
                lista.add(cargo);
            }
        return lista;   
            
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao criar a lista de cargos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }        
        return null;
    }
    
    public void editar(Cargos cargo) {
        String sql = "update cargos set nome = ? where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cargo.getNome());
            stmt.setInt(2, cargo.getId());
            
            stmt.execute();
            
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cargo editado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o cargo.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void excluir(Cargos cargo) {
        String sql = "delete from cargos where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cargo.getId());            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cargo excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o cargo. " + e);
        }
    }
    
    public Cargos buscarCargo(int id) {
        Cargos cargo = null;
        String sql = "select * from cargos where id = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cargo = new Cargos();
                    cargo.setId(rs.getInt("id"));
                    cargo.setNome(rs.getString("nome"));
                }
            }
            
        } catch (SQLException e) {
        }
        return cargo;
    }
    
}
