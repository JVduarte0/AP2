package cafeteria;

public class PilhaCancelados {

    private NoPedido topo;

    public PilhaCancelados() {
        topo = null;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    // Adiciona um pedido ao topo da pilha
    public void push(Pedido pedido) {

        NoPedido novo = new NoPedido(pedido);

        novo.proximo = topo;
        topo = novo;
    }

    // Remove o último pedido cancelado
    public Pedido pop() {

        if (estaVazia()) {
            return null;
        }

        Pedido pedidoRemovido = topo.pedido;
        topo = topo.proximo;

        return pedidoRemovido;
    }

    // Exibe os pedidos cancelados
    public void printStack() {

        if (estaVazia()) {
            System.out.println("Não existem pedidos cancelados.");
            return;
        }

        System.out.println("\n===== PEDIDOS CANCELADOS =====");

        NoPedido atual = topo;

        while (atual != null) {
            System.out.println(atual.pedido);
            atual = atual.proximo;
        }
    }
}