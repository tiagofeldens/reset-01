package br.com.cwi.tinderevolution.dominio;

import java.time.LocalDate;

public class Serie {

    public int id;
    public String nome;
    public String diretor;
    public LocalDate dataLancamento;
    public int numeroDeTemporadas;
    public int numeroDeEpisodios;
    public CategoriasSerie categoria;
    public String sinopse;

    public Serie(String nome, String diretor, LocalDate dataLancamento, int numeroDeTemporadas, int numeroDeEpisodios, CategoriasSerie categoria, String sinopse) {
        this.nome = nome;
        this.diretor = diretor;
        this.dataLancamento = dataLancamento;
        this.numeroDeTemporadas = numeroDeTemporadas;
        this.numeroDeEpisodios = numeroDeEpisodios;
        this.categoria = categoria;
        this.sinopse = sinopse;
    }


    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", diretor='" + diretor + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", numeroDeTemporadas=" + numeroDeTemporadas +
                ", numeroDeEpisodios=" + numeroDeEpisodios +
                ", categoria=" + categoria +
                ", sinopse='" + sinopse + '\'' +
                '}';
    }
}

