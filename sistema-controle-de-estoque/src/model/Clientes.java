package model;

public class Clientes extends PessoaFisica {
    
    @Override
    public String toString() {
        return getNome();
    }
    
    public String getEnderecoCompleto() {
        return (getEndereco() + ", Nº " + getNumero() + " " + getComplemento() + " - " + getBairro() + " - " + getCidade() + ", " + getEstado());
    }
}
