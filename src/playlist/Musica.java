package playlist;

public class Musica {

    private String titulo;
    private String artista;
    private String album;
    private int duracao;

    public Musica(String titulo, String artista, String album, int duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        int minutos = duracao / 60;
        int segundos = duracao % 60;

        return "Título: " + titulo +
                " | Artista: " + artista +
                " | Álbum: " + album +
                " | Duração: " + minutos + ":" +
                String.format("%02d", segundos);
    }
}
