package cafeteria;

public class NoPedido {

    Pedido pedido;
    NoPedido proximo;

    public NoPedido(Pedido pedido) {
        this.pedido = pedido;
        this.proximo = null;
    }
}