package br.com.cwi.tinderevolution.dominio;

import java.time.LocalDate;

public class Musica {
    private int id;
    private String nome;
    private String autor;
    private LocalDate dataLancamento;
    private EstiloMusical estilo;

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

    public EstiloMusical getEstilo() {
        return estilo;
    }

    public void setEstilo(EstiloMusical estilo) {
        this.estilo = estilo;
    }
}



