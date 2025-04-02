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

public class FornecedoresDAO {

    private final Connection conn;

    public FornecedoresDAO() {
        this.conn = new MySQLConnection().getConnection();
    }

    public void salvar(Fornecedores fornecedor) {
        String sql = "insert into fornecedores (nome, email, cnpj, telefone, cep, "
                + "endereco, numero, complemento, bairro, cidade, estado)"
                + " values(?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEmail());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setString(5, fornecedor.getCep());
            stmt.setString(6, fornecedor.getEndereco());
            stmt.setShort(7, fornecedor.getNumero());
            stmt.setString(8, fornecedor.getComplemento());
            stmt.setString(9, fornecedor.getBairro());
            stmt.setString(10, fornecedor.getCidade());
            stmt.setString(11, fornecedor.getEstado());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o fornecedor! " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    public Fornecedores buscarFornecedor(String cnpj) {
        String sql = "select * from fornecedores where cnpj = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();
            Fornecedores fornecedor = new Fornecedores();

            if (rs.next()) {
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNumero(rs.getShort("numero"));
                fornecedor.setComplemento(rs.getString("complemento"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setEstado(rs.getString("estado"));
                fornecedor.setCidade(rs.getString("cidade"));
            }
            return fornecedor;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao encontrar o fornecedor. " + e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        return null;

    }

    public List<Fornecedores> listar() {
        List<Fornecedores> lista = new ArrayList<>();
        String sql = "select * from fornecedores";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores fornecedor = new Fornecedores();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNumero(rs.getShort("numero"));
                fornecedor.setComplemento(rs.getString("complemento"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setEstado(rs.getString("estado"));
                lista.add(fornecedor);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista! " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public List<Fornecedores> filtrar(String nome) {
        List<Fornecedores> lista = new ArrayList<>();
        String sql = "select * from fornecedores where nome like ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores fornecedor = new Fornecedores();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNumero(rs.getShort("numero"));
                fornecedor.setComplemento(rs.getString("complemento"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setEstado(rs.getString("estado"));
                lista.add(fornecedor);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista de fornecedores! " + e.getMessage());
        }
        return lista;
    }

    public void editar(Fornecedores fornecedor) {
        String sql = "update fornecedores set nome = ?, email = ?, cnpj = ?, telefone = ?,"
                + "cep = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?,"
                + "cidade = ?, estado = ? where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEmail());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setString(5, fornecedor.getCep());
            stmt.setString(6, fornecedor.getEndereco());
            stmt.setShort(7, fornecedor.getNumero());
            stmt.setString(8, fornecedor.getComplemento());
            stmt.setString(9, fornecedor.getBairro());
            stmt.setString(10, fornecedor.getCidade());
            stmt.setString(11, fornecedor.getEstado());
            stmt.setInt(12, fornecedor.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor editado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o fornecedor! " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluir(Fornecedores fornecedor) {
        String sql = "delete from fornecedores where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fornecedor.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o fornecedor! " + e.getMessage());
        }

    }

    public Fornecedores buscarIdFornecedor(int id) {
        Fornecedores fornecedor = null;
        String sql = "select * from fornecedores where id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    fornecedor = new Fornecedores();
                    fornecedor.setId(rs.getInt("id"));
                    fornecedor.setNome(rs.getString("nome"));
                }
            }

        } catch (SQLException e) {
        }
        return fornecedor;
    }    

}
