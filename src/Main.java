import cafeteria.FilaPedidos;
import cafeteria.Pedido;
import cafeteria.PilhaCancelados;
import playlist.Musica;
import playlist.Playlist;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        FilaPedidos fila = new FilaPedidos();
        PilhaCancelados pilha = new PilhaCancelados();
        Playlist playlist = new Playlist();

        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println("     AP2 - ESTRUTURAS DE DADOS");
            System.out.println("==============================");
            System.out.println("1 - Sistema da Cafeteria");
            System.out.println("2 - Gerenciador de Playlist");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro();

            switch (opcao) {

                case 1:
                    menuCafeteria(fila, pilha);
                    break;

                case 2:
                    menuPlaylist(playlist);
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // =========================
    // CAFETERIA
    // =========================

    public static void menuCafeteria(FilaPedidos fila,
                                     PilhaCancelados pilha) {

        int opcao;

        do {
            System.out.println("\n===== CAFETERIA =====");
            System.out.println("1 - Adicionar novo pedido");
            System.out.println("2 - Atender pedido");
            System.out.println("3 - Cancelar pedido");
            System.out.println("4 - Restaurar pedido");
            System.out.println("5 - Imprimir pedidos pendentes");
            System.out.println("6 - Imprimir pedidos cancelados");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro();

            switch (opcao) {

                case 1:
                    adicionarPedido(fila);
                    break;

                case 2:
                    atenderPedido(fila);
                    break;

                case 3:
                    cancelarPedido(fila, pilha);
                    break;

                case 4:
                    restaurarPedido(fila, pilha);
                    break;

                case 5:
                    fila.printQueue();
                    break;

                case 6:
                    pilha.printStack();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static void adicionarPedido(FilaPedidos fila) {

        System.out.print("Digite o ID do pedido: ");
        int id = lerInteiro();

        System.out.print("Digite a descrição do pedido: ");
        String descricao = scanner.nextLine();

        Pedido pedido = new Pedido(id, descricao);

        fila.enqueue(pedido);

        System.out.println("Pedido adicionado com sucesso!");
    }

    public static void atenderPedido(FilaPedidos fila) {

        Pedido pedido = fila.dequeue();

        if (pedido == null) {
            System.out.println("Não existem pedidos para atender.");
        } else {
            System.out.println("Pedido atendido:");
            System.out.println(pedido);
        }
    }

    public static void cancelarPedido(FilaPedidos fila,
                                      PilhaCancelados pilha) {

        Pedido pedido = fila.dequeue();

        if (pedido == null) {
            System.out.println("Não existem pedidos para cancelar.");
        } else {
            pilha.push(pedido);

            System.out.println("Pedido cancelado:");
            System.out.println(pedido);
        }
    }

    public static void restaurarPedido(FilaPedidos fila,
                                       PilhaCancelados pilha) {

        Pedido pedido = pilha.pop();

        if (pedido == null) {
            System.out.println("Não existem pedidos cancelados.");
        } else {
            fila.enqueue(pedido);

            System.out.println("Pedido restaurado:");
            System.out.println(pedido);
        }
    }

    // =========================
    // PLAYLIST
    // =========================

    public static void menuPlaylist(Playlist playlist) {

        int opcao;

        do {
            System.out.println("\n===== GERENCIADOR DE PLAYLIST =====");
            System.out.println("1 - Próxima música");
            System.out.println("2 - Música anterior");
            System.out.println("3 - Ordenar playlist");
            System.out.println("4 - Tocar música");
            System.out.println("5 - Adicionar música");
            System.out.println("6 - Remover música");
            System.out.println("7 - Listar músicas");
            System.out.println("8 - Buscar música");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro();

            switch (opcao) {

                case 1:
                    playlist.proximaMusica();
                    break;

                case 2:
                    playlist.musicaAnterior();
                    break;

                case 3:
                    menuOrdenacao(playlist);
                    break;

                case 4:
                    playlist.tocarMusica();
                    break;

                case 5:
                    adicionarMusica(playlist);
                    break;

                case 6:
                    removerMusica(playlist);
                    break;

                case 7:
                    playlist.listarMusicas();
                    break;

                case 8:
                    buscarMusica(playlist);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static void adicionarMusica(Playlist playlist) {

        System.out.print("Título da música: ");
        String titulo = scanner.nextLine();

        System.out.print("Artista: ");
        String artista = scanner.nextLine();

        System.out.print("Álbum: ");
        String album = scanner.nextLine();

        System.out.print("Duração em segundos: ");
        int duracao = lerInteiro();

        Musica musica =
                new Musica(titulo, artista, album, duracao);

        System.out.println("\nOnde deseja adicionar?");
        System.out.println("1 - Início");
        System.out.println("2 - Final");
        System.out.println("3 - Posição específica");
        System.out.print("Escolha: ");

        int opcao = lerInteiro();

        switch (opcao) {

            case 1:
                playlist.adicionarInicio(musica);
                System.out.println("Música adicionada no início!");
                break;

            case 2:
                playlist.adicionarFim(musica);
                System.out.println("Música adicionada no final!");
                break;

            case 3:
                System.out.print("Digite a posição: ");
                int posicao = lerInteiro();

                playlist.adicionarPosicao(musica, posicao);

                System.out.println("Música adicionada!");
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void removerMusica(Playlist playlist) {

        System.out.print("Digite o título da música: ");
        String titulo = scanner.nextLine();

        boolean removeu =
                playlist.removerPorTitulo(titulo);

        if (removeu) {
            System.out.println("Música removida com sucesso!");
        } else {
            System.out.println("Música não encontrada.");
        }
    }

    public static void menuOrdenacao(Playlist playlist) {

        System.out.println("\n===== ORDENAÇÃO =====");
        System.out.println("1 - Ordenar por título");
        System.out.println("2 - Ordenar por artista");
        System.out.print("Escolha: ");

        int opcao = lerInteiro();

        if (opcao == 1) {
            playlist.ordenarPorTitulo();

        } else if (opcao == 2) {
            playlist.ordenarPorArtista();

        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void buscarMusica(Playlist playlist) {

        System.out.print(
                "Digite título, artista ou álbum para buscar: "
        );

        String termo = scanner.nextLine();

        playlist.buscar(termo);
    }

    // =========================
    // LEITURA SEGURA DE NÚMEROS
    // =========================

    public static int lerInteiro() {

        while (true) {

            try {
                int numero =
                        Integer.parseInt(scanner.nextLine());

                return numero;

            } catch (NumberFormatException e) {
                System.out.print(
                        "Valor inválido. Digite um número: "
                );
            }
        }
    }
}