package model;

public class Pecas {
    
    //atributos
    private int id;
    private Fornecedores fornecedor;
    private String nome;
    private String descricao;
    private short quantidade;
    private double valorUnidadeFornecedor;
    private double valorUnidadeCliente;

    //metodos especiais
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fornecedores getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedores fornecedor) {
        this.fornecedor = fornecedor;
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
        
}
