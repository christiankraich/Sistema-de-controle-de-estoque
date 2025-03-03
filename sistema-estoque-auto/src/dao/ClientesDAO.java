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
            JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente!" + erro);
        }
    }
    
    public Clientes buscarCliente(String cpf) {
        try {
            String sql = "select * from clientes where cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();
            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setDataNascimento(rs.getDate("data_nascimento"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCpf(rs.getString("cpf"));
                obj.setBairro(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getShort("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
            }
            return obj;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o cliente.");            
        }
        return null;        
    }
    
}
