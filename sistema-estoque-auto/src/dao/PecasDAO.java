package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.MySQLConnection;
import model.Fornecedores;
import model.Pecas;

public class PecasDAO {

    private final Connection conn;
    //private String sql;
    //private final PreparedStatement stmt;

    public PecasDAO() {//(String sql) throws SQLException {
        //this.sql = sql;
        this.conn = new MySQLConnection().getConnection();
        //this.stmt = conn.prepareStatement(sql);
    }

    public void salvar(Pecas peca) {
        String sql = "insert into pecas (id_fornecedor, nome, descricao, "
                + "quantidade, valor_unidade_fornecedor, valor_unidade_cliente)"
                + " values (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, peca.getFornecedores().getId());
            stmt.setString(2, peca.getNome());
            stmt.setString(3, peca.getDescricao());
            stmt.setShort(4, peca.getQuantidade());
            stmt.setDouble(5, peca.getValorUnidadeFornecedor());
            stmt.setDouble(6, peca.getValorUnidadeCliente());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Peça salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar a peça! " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void editar(Pecas peca) {
        String sql = "update pecas set id_fornecedor = ?, nome = ?, descricao = ?, "
                + "quantidade = ?, valor_unidade_fornecedor = ?, "
                + "valor_unidade_cliente = ? where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, peca.getFornecedores().getId());
            stmt.setString(2, peca.getNome());
            stmt.setString(3, peca.getDescricao());
            stmt.setShort(4, peca.getQuantidade());
            stmt.setDouble(5, peca.getValorUnidadeFornecedor());
            stmt.setDouble(6, peca.getValorUnidadeCliente());
            stmt.setInt(7, peca.getId());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Peça editada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar a peça!" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void excluir(Pecas peca) {
        String sql = "delete from pecas where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, peca.getId());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Peça excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a peça!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public List<Pecas> listar() {
        List<Pecas> lista = new ArrayList<>();
        String sql = "select p.*, f.nome as nome_fornecedor from pecas p inner join fornecedores f on p.id_fornecedor = f.id";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pecas peca = new Pecas();
                peca.setId(rs.getInt("id"));
                
                Fornecedores fornecedor = new Fornecedores();
                fornecedor.setNome(rs.getString("nome_fornecedor"));
                peca.setFornecedores(fornecedor);
                
                peca.setNome(rs.getString("nome"));
                peca.setDescricao(rs.getString("descricao"));
                peca.setQuantidade(rs.getShort("quantidade"));
                peca.setValorUnidadeCliente(rs.getDouble("valor_unidade_cliente"));
                peca.setValorUnidadeFornecedor(rs.getDouble("valor_unidade_fornecedor"));
                
                lista.add(peca);
            }            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista de peças.\n" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }                        
        return lista;
    }
    
    public Pecas buscarPeca(String nome) {
        String sql = "select * from pecas where nome = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Pecas peca = new Pecas();
            
            if (rs.next()) {                
                peca.setId(rs.getInt("id"));
                
                int idFornecedor = rs.getInt("id_fornecedor");
                FornecedoresDAO fornecedorDao = new FornecedoresDAO();
                Fornecedores fornecedor = fornecedorDao.buscarIdFornecedor(idFornecedor);
                peca.setFornecedores(fornecedor);
                
                peca.setNome(rs.getString("nome"));
                peca.setDescricao(rs.getString("descricao"));
                peca.setQuantidade(rs.getShort("quantidade"));
                peca.setValorUnidadeFornecedor(rs.getDouble("valor_unidade_fornecedor"));
                peca.setValorUnidadeCliente(rs.getDouble("valor_unidade_fornecedor"));
            }
            return peca;
            
        } catch (SQLException e) {
        }
        
        return null;
    }
    
    public List<Pecas> filtrar(String nome) {
        List<Pecas> lista = new ArrayList<>();
        String sql = "select * from pecas where nome like ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pecas peca = new Pecas();
                peca.setId(rs.getInt("id"));
                
                int idFornecedor = rs.getInt("id_fornecedor");
                FornecedoresDAO fornecedorDao = new FornecedoresDAO();
                Fornecedores fornecedor = fornecedorDao.buscarIdFornecedor(idFornecedor);
                peca.setFornecedores(fornecedor);
                
                peca.setNome(rs.getString("nome"));
                peca.setDescricao(rs.getString("descricao"));
                peca.setQuantidade(rs.getShort("quantidade"));
                peca.setValorUnidadeFornecedor(rs.getDouble("valor_unidade_fornecedor"));
                peca.setValorUnidadeCliente(rs.getDouble("valor_unidade_cliente"));
                
                lista.add(peca);
            }            
            
        } catch (SQLException e) {
        }        
        return lista;
    }
    
    public void alterarEstoque(int id, int qtdNova) {
        String sql = "update pecas set quantidade = ? where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, qtdNova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Quantidade alterada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o estoque!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
