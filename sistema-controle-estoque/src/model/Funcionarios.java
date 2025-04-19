package model;

public class Funcionarios extends Clientes {
    
    //atributos
    private Cargos cargos;    
    private String senha;
    private NivelAcesso nivelAcesso;

    //metodos especiais       
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
    
    public enum NivelAcesso {
        ADMINISTRADOR,
        COMUM
    }
    
}
