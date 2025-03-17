package model;

public class Funcionarios extends Clientes {
    
    //atributos
    private Cargos cargo;    
    private String senha;
    private nivelAcesso nivelAcesso;

    //metodos especiais       
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
    
    public nivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(nivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    
    public enum nivelAcesso {
        Administrativo,
        Comum
    }
    
}
