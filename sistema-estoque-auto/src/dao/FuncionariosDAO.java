package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.MySQLConnection;
import model.Cargos;
import model.Funcionarios;

public class FuncionariosDAO {

    private final Connection conn;

    public FuncionariosDAO() {
        this.conn = new MySQLConnection().getConnection();
    }

    public void salvar(Funcionarios funcionario) {
        //criar comando sql
        String sql = "insert into funcionarios (id_cargo, nome, data_nascimento, "
                + "email, cpf, telefone, cep, endereco, numero, complemento, bairro, "
                + "cidade, estado, senha, nivel_acesso) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //preparar a conexao SQL para se conectar com o banco de dados
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, funcionario.getCargo());
            stmt.setString(2, funcionario.getNome());
            stmt.setObject(3, funcionario.getDataNascimento());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getCpf());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getCep());
            stmt.setString(8, funcionario.getEndereco());
            stmt.setShort(9, funcionario.getNumero());
            stmt.setString(10, funcionario.getComplemento());
            stmt.setString(11, funcionario.getBairro());
            stmt.setString(12, funcionario.getCidade());
            stmt.setString(13, funcionario.getEstado());
            stmt.setString(14, funcionario.getSenha());
            stmt.setString(15, funcionario.getNivelAcesso().name());
            //executar o comando SQL
            stmt.executeQuery();
            //fechar a conexao
            stmt.close();
            JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o funcionário!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Funcionarios buscarFuncionario(String cpf) {
        String sql = "select * from funcionarios where cpf = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Funcionarios funcionario = new Funcionarios();

            if (rs.next()) {
                funcionario.setId(rs.getInt("id"));
                funcionario.setCargo((Cargos) rs.getObject("id_cargo"));
                funcionario.setNome(rs.getString(sql));
                funcionario.setDataNascimento(rs.getDate("data_nascimento"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setNumero(rs.getShort("numero"));
                funcionario.setComplemento(rs.getString("complemento"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setEstado(rs.getString("estado"));
                funcionario.setSenha(rs.getString("senha"));
                String nivelAcesso = rs.getString("nivel_acesso");
                
                try {
                    funcionario.setNivelAcesso(Funcionarios.nivelAcesso.valueOf(nivelAcesso));                    
                } catch (IllegalArgumentException e) {
                    funcionario.setNivelAcesso(Funcionarios.nivelAcesso.Comum);
                }                    
            }
            return funcionario;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Funcionário não cadastrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

}
