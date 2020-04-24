package br.com.cwi.tinderevolution.dominio;

import java.time.LocalDate;

public class Filme {
    private int id;
    private String nome;
    private String autor;
    private LocalDate dataLancamento;
    private CategoriasFilme categoria;
    private String sinopse;

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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public CategoriasFilme getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasFilme categoria) {
        this.categoria = categoria;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
}
