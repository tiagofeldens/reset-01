package dominio;

import java.time.LocalDate;

public class Musica {
    public int id;
    public String nome;
    public String autor;
    public LocalDate dataLancamento;
    public String estilo;

    public Musica(int id, String nome, String autor, LocalDate dataLancamento, String estilo) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.dataLancamento = dataLancamento;
        this.estilo = estilo;
    }
}
