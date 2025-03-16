package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.MySQLConnection;
import model.Clientes;

public class ClientesDAO {

    private final Connection conn;

    public ClientesDAO() {
        this.conn = new MySQLConnection().getConnection();
    }

    public void salvar(Clientes cliente) {
        //1º passo: criar o comando sql
        String sql = "insert into clientes (nome, data_nascimento, email, cpf,"
                + " telefone, cep, endereco, numero, complemento, bairro, cidade, estado)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //2º passo: preparar a conexao SQL para se conectar com o banco
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setObject(2, cliente.getDataNascimento());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getCep());
            stmt.setString(7, cliente.getEndereco());
            stmt.setShort(8, cliente.getNumero());
            stmt.setString(9, cliente.getComplemento());
            stmt.setString(10, cliente.getBairro());
            stmt.setString(11, cliente.getCidade());
            stmt.setString(12, cliente.getEstado());
            //3º passo: executar o comando SQL
            stmt.execute();
            //4º passo: fechar a conexão
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente!");
        }
    }

    public Clientes buscarCliente(String cpf) {
        String sql = "select * from clientes where cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Clientes cliente = new Clientes();

            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDataNascimento(rs.getDate("data_nascimento"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getShort("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
            }
            return cliente;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente não cadastrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public List<Clientes> listar() {
        List<Clientes> lista = new ArrayList<>();
        String sql = "select * from clientes";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDataNascimento(rs.getDate("data_nascimento"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getShort("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                lista.add(cliente);
            }
            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista de clientes.");
        }
        return null;
    }

    public List<Clientes> filtrar(String nome) {
        List<Clientes> lista = new ArrayList<>();
        String sql = "select * from clientes where nome like ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDataNascimento(rs.getDate("data_nascimento"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getShort("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                lista.add(cliente);
            }
            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista de clientes.");
        }
        return null;
    }

    public void editar(Clientes cliente) {

        //1º passo: criar o comando sql
        String sql = "update clientes set nome = ?, data_nascimento = ?, email = ?, "
                + "cpf = ?, telefone = ?, cep = ?, endereco = ?, numero = ?, "
                + "complemento = ?, bairro = ?, cidade = ?, estado = ? where id = ?";
        //2º passo: preparar a conexao SQL para se conectar com o banco
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setObject(2, cliente.getDataNascimento());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getCep());
            stmt.setString(7, cliente.getEndereco());
            stmt.setShort(8, cliente.getNumero());
            stmt.setString(9, cliente.getComplemento());
            stmt.setString(10, cliente.getBairro());
            stmt.setString(11, cliente.getCidade());
            stmt.setString(12, cliente.getEstado());
            stmt.setInt(13, cliente.getId());
            //3º passo: executar o comando SQL
            stmt.execute();
            //4º passo: fechar a conexão
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o cliente!");
        }
    }

    public void excluir(Clientes cliente) {
        String sql = "delete from clientes where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, cliente.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente!" + e);
        }
    }

}
