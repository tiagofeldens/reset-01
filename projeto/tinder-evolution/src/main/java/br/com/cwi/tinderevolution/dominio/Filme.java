package br.com.cwi.tinderevolution.dominio;

import java.time.LocalDate;

public class Filme {
    public int id;
    public String nome;
    public String autor;
    public LocalDate dataLancamento;
    public CategoriasFilme categoria;
    public String sinopse;

    public Filme(String nome, String autor, LocalDate dataLancamento, CategoriasFilme categoria, String sinopse) {
        this.nome = nome;
        this.autor = autor;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.sinopse = sinopse;
    }


    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", categoria=" + categoria +
                ", sinopse='" + sinopse + '\'' +
                '}';
    }
}
