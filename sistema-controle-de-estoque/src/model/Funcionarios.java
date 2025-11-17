package model;

public class Funcionarios extends PessoaFisica {
    
    // atributos encapsulados da entidade Funcionarios
    private Cargos cargo;    
    private String senha;
    private NivelAcesso nivelAcesso;
    
    // metodos especiais (getters e setters        
    public Cargos getCargo() {
        return cargo;
    }
    
    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
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
    
    @Override
    public String toString() {
        return getNome();
    }
    
    // enum que representa o nivel de acesso do usuário
    public enum NivelAcesso {
        ADMINISTRADOR,
        COMUM
    }
    
}
