package playlist;

public class Playlist {

    private NoMusica inicio;
    private NoMusica fim;
    private NoMusica atual;

    public Playlist() {
        inicio = null;
        fim = null;
        atual = null;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    // Adicionar música no início
    public void adicionarInicio(Musica musica) {

        NoMusica novo = new NoMusica(musica);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
            atual = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
    }

    // Adicionar música no final
    public void adicionarFim(Musica musica) {

        NoMusica novo = new NoMusica(musica);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
            atual = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    // Adicionar música em uma posição específica
    public void adicionarPosicao(Musica musica, int posicao) {

        if (posicao <= 1 || estaVazia()) {
            adicionarInicio(musica);
            return;
        }

        NoMusica aux = inicio;
        int contador = 1;

        while (aux.proximo != null && contador < posicao - 1) {
            aux = aux.proximo;
            contador++;
        }

        if (aux == fim) {
            adicionarFim(musica);
            return;
        }

        NoMusica novo = new NoMusica(musica);

        novo.proximo = aux.proximo;
        novo.anterior = aux;

        aux.proximo.anterior = novo;
        aux.proximo = novo;
    }

    // Remover música pelo título
    public boolean removerPorTitulo(String titulo) {

        if (estaVazia()) {
            return false;
        }

        NoMusica aux = inicio;

        while (aux != null &&
                !aux.musica.getTitulo().equalsIgnoreCase(titulo)) {

            aux = aux.proximo;
        }

        if (aux == null) {
            return false;
        }

        // Se for a música atual, altera a referência
        if (aux == atual) {
            if (aux.proximo != null) {
                atual = aux.proximo;
            } else {
                atual = aux.anterior;
            }
        }

        // Único elemento
        if (aux == inicio && aux == fim) {
            inicio = null;
            fim = null;
            atual = null;
        }

        // Primeiro elemento
        else if (aux == inicio) {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }

        // Último elemento
        else if (aux == fim) {
            fim = fim.anterior;
            fim.proximo = null;
        }

        // Elemento do meio
        else {
            aux.anterior.proximo = aux.proximo;
            aux.proximo.anterior = aux.anterior;
        }

        return true;
    }

    // Próxima música
    public void proximaMusica() {

        if (atual == null) {
            System.out.println("A playlist está vazia.");
            return;
        }

        if (atual.proximo != null) {
            atual = atual.proximo;
            System.out.println("Música atual: " + atual.musica.getTitulo());
        } else {
            System.out.println("Você já está na última música.");
        }
    }

    // Música anterior
    public void musicaAnterior() {

        if (atual == null) {
            System.out.println("A playlist está vazia.");
            return;
        }

        if (atual.anterior != null) {
            atual = atual.anterior;
            System.out.println("Música atual: " + atual.musica.getTitulo());
        } else {
            System.out.println("Você já está na primeira música.");
        }
    }

    // Tocar música atual
    public void tocarMusica() {

        if (atual == null) {
            System.out.println("Não existe música para tocar.");
            return;
        }

        System.out.println("\n===== TOCANDO =====");
        System.out.println(atual.musica);
    }

    // Listar todas
    public void listarMusicas() {

        if (estaVazia()) {
            System.out.println("A playlist está vazia.");
            return;
        }

        System.out.println("\n===== PLAYLIST =====");

        NoMusica aux = inicio;
        int posicao = 1;

        while (aux != null) {

            if (aux == atual) {
                System.out.println(
                        posicao + " - " + aux.musica + " <-- ATUAL"
                );
            } else {
                System.out.println(
                        posicao + " - " + aux.musica
                );
            }

            aux = aux.proximo;
            posicao++;
        }
    }

    // Ordenar por título
    public void ordenarPorTitulo() {

        if (inicio == null || inicio.proximo == null) {
            return;
        }

        NoMusica i = inicio;

        while (i != null) {

            NoMusica j = i.proximo;

            while (j != null) {

                if (i.musica.getTitulo().compareToIgnoreCase(
                        j.musica.getTitulo()) > 0) {

                    Musica temp = i.musica;
                    i.musica = j.musica;
                    j.musica = temp;
                }

                j = j.proximo;
            }

            i = i.proximo;
        }

        atual = inicio;

        System.out.println("Playlist ordenada por título!");
    }

    // Ordenar por artista
    public void ordenarPorArtista() {

        if (inicio == null || inicio.proximo == null) {
            return;
        }

        NoMusica i = inicio;

        while (i != null) {

            NoMusica j = i.proximo;

            while (j != null) {

                if (i.musica.getArtista().compareToIgnoreCase(
                        j.musica.getArtista()) > 0) {

                    Musica temp = i.musica;
                    i.musica = j.musica;
                    j.musica = temp;
                }

                j = j.proximo;
            }

            i = i.proximo;
        }

        atual = inicio;

        System.out.println("Playlist ordenada por artista!");
    }

    // Buscar música
    public void buscar(String termo) {

        if (estaVazia()) {
            System.out.println("A playlist está vazia.");
            return;
        }

        NoMusica aux = inicio;
        boolean encontrou = false;

        System.out.println("\n===== RESULTADO DA BUSCA =====");

        while (aux != null) {

            if (aux.musica.getTitulo().toLowerCase()
                    .contains(termo.toLowerCase())
                    ||
                    aux.musica.getArtista().toLowerCase()
                            .contains(termo.toLowerCase())
                    ||
                    aux.musica.getAlbum().toLowerCase()
                            .contains(termo.toLowerCase())) {

                System.out.println(aux.musica);
                encontrou = true;
            }

            aux = aux.proximo;
        }

        if (!encontrou) {
            System.out.println("Nenhuma música encontrada.");
        }
    }
}