package model;

public class Pecas {
    
    // atributos encapsulados da entidade Pecas
    private int id;
    private Fornecedores fornecedores;
    private String nome;
    private String descricao;
    private short quantidade;
    private double valorUnidadeFornecedor;
    private double valorUnidadeCliente;

    // metodos especiais (getters e setters)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fornecedores getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(Fornecedores fornecedores) {
        this.fornecedores = fornecedores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnidadeFornecedor() {
        return valorUnidadeFornecedor;
    }

    public void setValorUnidadeFornecedor(double valorUnidadeFornecedor) {
        this.valorUnidadeFornecedor = valorUnidadeFornecedor;
    }

    public double getValorUnidadeCliente() {
        return valorUnidadeCliente;
    }

    public void setValorUnidadeCliente(double valorUnidadeCliente) {
        this.valorUnidadeCliente = valorUnidadeCliente;
    }
    
    @Override
    public String toString() {
        return getNome();
    }
        
}
