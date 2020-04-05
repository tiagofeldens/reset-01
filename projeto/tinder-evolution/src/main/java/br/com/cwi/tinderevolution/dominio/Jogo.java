package br.com.cwi.tinderevolution.dominio;

import java.time.LocalDate;

public class Jogo {
    public int id;
    public String nome;
    public String publisher;
    public LocalDate dataLancamento;
    public CategoriasJogo categoria;
    public PlataformasJogo plataforma;


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
}
