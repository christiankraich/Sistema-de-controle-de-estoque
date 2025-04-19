package model;

public class OrdemDeServico {
    
    //atributos
    private int id;
    private Clientes cliente;
    private Funcionarios funcionario;
    private String dataAbertura;
    private String dataConcluido;
    private String descricao;
    private Status status;

    //metodos especiais
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

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataConcluido() {
        return dataConcluido;
    }

    public void setDataConcluido(String dataConcluido) {
        this.dataConcluido = dataConcluido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public enum Status {
        Concluída,
        Pendente
    }
    
}
