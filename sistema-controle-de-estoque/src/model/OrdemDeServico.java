package model;

import java.util.Date;

public class OrdemDeServico {
    
    // atributos encapsulados da entidade OrdemDeServico
    private int id;
    private Clientes cliente;
    private Funcionarios funcionario;
    private Date dataAbertura;
    private Date dataConcluido;
    private String descricao;
    private double valorTotal;
    private String observacoes;
    private Status status;

    // metodos especiais (getters e setters)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataConcluido() {
        return dataConcluido;
    }

    public void setDataConcluido(Date dataConcluido) {
        this.dataConcluido = dataConcluido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }
    
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public String getObservacoes() {
        return observacoes;
    }
    
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    // enum que representa o status do pedido
    public enum Status {
        CONCLUÍDA,
        PENDENTE
    }
    
}
