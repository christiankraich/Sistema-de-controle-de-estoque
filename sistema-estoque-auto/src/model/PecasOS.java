package model;

public class PecasOS {
    
    //atributos
    private int id;
    private Pecas peca;
    private OrdemDeServico ordemDeServico;
    private short quantidade;
    
    //metodos especiais
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Pecas getPeca() {
        return peca;
    }
    
    public void setPeca(Pecas peca) {
        this.peca = peca;
    }
    
    public OrdemDeServico getOrdemDeServico() {
        return ordemDeServico;
    }
    
    public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }
    
    public short getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }
    
}
