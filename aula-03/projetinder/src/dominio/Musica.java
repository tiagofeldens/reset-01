package dominio;

import java.time.LocalDate;

public class Musica {
    public int id;
    public String nome;
    public String autor;
    public LocalDate dataLancamento;
    public EstiloMusical estilo;

    public Musica(String nome, String autor, LocalDate dataLancamento, EstiloMusical estilo) {
        this.nome = nome;
        this.autor = autor;
        this.dataLancamento = dataLancamento;
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return "Musica[" +
                "id: " + id +
                ", nome: '" + nome + '\'' +
                ", artista: '" + autor + '\'' +
                ", estiloMusical: " + estilo +
                ", lancamento: " + dataLancamento +
                ']';
    }
}



