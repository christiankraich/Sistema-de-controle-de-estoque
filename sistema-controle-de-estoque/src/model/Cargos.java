package model;

public class Cargos {
    
    // atributos encapsulados da entidade Cargos
    private int id;
    private String nome;
    
    // metodos especiais (getters e setters)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    // sobrescreve o método toString para exibir o nome do cargo
    @Override
    public String toString() {
        return this.nome;
    }
    
}
