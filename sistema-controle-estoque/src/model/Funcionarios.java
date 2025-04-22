package model;

// essa classe herda os atributos e métodos da classe Clientes
public class Funcionarios extends Clientes {
    
    // atributos encapsulados da entidade Funcionarios
    private Cargos cargos;    
    private String senha;
    private NivelAcesso nivelAcesso;

    // metodos especiais (getters e setters    
    public Cargos getCargos() {
        return cargos;
    }
    
    public void setCargos(Cargos cargos) {
        this.cargos = cargos;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    
    // enum que representa o nivel de acesso do usuário
    public enum NivelAcesso {
        ADMINISTRADOR,
        COMUM
    }
    
}
