package br.com.cwi.tinderevolution.dominio;

import java.time.LocalDate;

public class Jogo {
    private int id;
    private String nome;
    private String publisher;
    private LocalDate dataLancamento;
    private CategoriasJogo categoria;
    private PlataformasJogo plataforma;

    public Jogo(String nome, String publisher, LocalDate dataLancamento, CategoriasJogo categoria, PlataformasJogo plataforma) {
        this.nome = nome;
        this.publisher = publisher;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", publisher='" + publisher + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", categoria=" + categoria +
                ", plataforma=" + plataforma +
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public CategoriasJogo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasJogo categoria) {
        this.categoria = categoria;
    }

    public PlataformasJogo getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(PlataformasJogo plataforma) {
        this.plataforma = plataforma;
    }
}
