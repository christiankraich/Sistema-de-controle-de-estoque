package model;

public class Fornecedores extends Pessoa {
    
    // atributo encapsulado da entidade Fornecedores     
    private String razaoSocial;
    private String cnpj;
    
    // metodos especiais (getters e setters)
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
        
    // sobrescreve o método toString para exibir o razaoSocial do fornecedor
    @Override
    public String toString() {
        return getRazaoSocial();
    }   
}
