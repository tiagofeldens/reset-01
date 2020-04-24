package br.com.cwi.tinderevolution.dominio;

public class Esporte{
    private int id;
    private String nome;

    public Esporte(String nome) {
        this.nome = nome;
    }

    public Esporte() {
    }

    @Override
    public String toString() {
        return "Esporte{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
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
}
