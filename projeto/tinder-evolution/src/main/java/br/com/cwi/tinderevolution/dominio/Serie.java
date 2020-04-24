package br.com.cwi.tinderevolution.dominio;

import java.time.LocalDate;

public class Serie {

    private int id;
    private String nome;
    private String diretor;
    private LocalDate dataLancamento;
    private int numeroDeTemporadas;
    private int numeroDeEpisodios;
    private CategoriasSerie categoria;
    private String sinopse;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public int getNumeroDeTemporadas() {
        return numeroDeTemporadas;
    }

    public void setNumeroDeTemporadas(int numeroDeTemporadas) {
        this.numeroDeTemporadas = numeroDeTemporadas;
    }

    public int getNumeroDeEpisodios() {
        return numeroDeEpisodios;
    }

    public void setNumeroDeEpisodios(int numeroDeEpisodios) {
        this.numeroDeEpisodios = numeroDeEpisodios;
    }

    public CategoriasSerie getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasSerie categoria) {
        this.categoria = categoria;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
}

