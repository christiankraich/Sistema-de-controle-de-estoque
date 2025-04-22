package model;

// essa classe herda os atributos e métodos da classe Clientes
public class Fornecedores extends Clientes{
    
    // atributo específico encapsulado da entidade Fornecedores        
    private String cnpj;
    
    // metodos especiais (getters e setters)  
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }   
    
    // sobrescreve o método toString para exibir o nome do fornecedor
    @Override
    public String toString() {
        return getNome();
    }   
}
