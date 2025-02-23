package model;

public class PecasPedidos {
    
    //atributos
    private int id;
    private Pecas peca;
    private Pedidos pedido;
    private int quantidade;
    
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
    
    public Pedidos getPedido() {
        return pedido;
    }
    
    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
