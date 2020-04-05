package br.com.cwi.tinderevolution.dominio;

public class Esporte {
    public int id;
    public String nome;

    public Esporte(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "Esporte{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
