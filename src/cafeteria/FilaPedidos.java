package cafeteria;

public class FilaPedidos {

    private NoPedido inicio;
    private NoPedido fim;

    public FilaPedidos() {
        inicio = null;
        fim = null;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    // Adiciona um pedido no final da fila
    public void enqueue(Pedido pedido) {

        NoPedido novo = new NoPedido(pedido);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    // Remove o pedido mais antigo
    public Pedido dequeue() {

        if (estaVazia()) {
            return null;
        }

        Pedido pedidoRemovido = inicio.pedido;
        inicio = inicio.proximo;

        // Se a fila ficou vazia
        if (inicio == null) {
            fim = null;
        }

        return pedidoRemovido;
    }

    // Exibe todos os pedidos pendentes
    public void printQueue() {

        if (estaVazia()) {
            System.out.println("Não existem pedidos pendentes.");
            return;
        }

        System.out.println("\n===== PEDIDOS PENDENTES =====");

        NoPedido atual = inicio;

        while (atual != null) {
            System.out.println(atual.pedido);
            atual = atual.proximo;
        }
    }
}