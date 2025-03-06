package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.MySQLConnection;
import model.Clientes;

public class ClientesDAO {

    private final Connection conn;

    public ClientesDAO() {
        this.conn = new MySQLConnection().getConnection();
    }

    public void Salvar(Clientes cliente) {
        try {
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
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente!");
        }
    }
    
    public Clientes buscarCliente(String cpf) {
        try {
            String sql = "select * from clientes where cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Clientes cliente = new Clientes();
            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDataNascimento(rs.getDate("data_nascimento"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setBairro(rs.getString("telefone"));
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
    
}
