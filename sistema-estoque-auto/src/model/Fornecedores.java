package model;

public class Fornecedores extends Clientes{
    
    //atributos        
    private String cnpj;
    
    //metodos especiais    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }   

    @Override
    public String toString() {
        return getNome();
    }   
}
