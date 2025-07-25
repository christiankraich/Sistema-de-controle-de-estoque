package model;

import java.util.Date;

public class Pedidos {
    
    // atributos encapsulados da entidade pedido
    private int id;
    private Fornecedores fornecedores;
    private Date data;
    private double valorTotal;
    private Status status;
    
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

    public void setFornecedores(Fornecedores fornecedor) {
        this.fornecedores = fornecedor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    // enum que representa o status do pedido
    public enum Status {
        CONCLUÍDO,
        PENDENTE
    }
}
