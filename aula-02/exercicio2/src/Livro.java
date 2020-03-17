public class Livro {
    String titulo;
    String autor;
    Categorias Categorias;
    Status Status;

    public Livro(String titulo, String autor, Categorias categorias, Status status) {
        this.titulo = titulo;
        this.autor = autor;
        Categorias = categorias;
        Status = status;
    }

    @Override
    public String toString() {
        return Categorias + " - " + titulo + " (" + autor + "): " + Status;
    }
}
