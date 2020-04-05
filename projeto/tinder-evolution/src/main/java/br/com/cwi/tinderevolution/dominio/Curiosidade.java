package br.com.cwi.tinderevolution.dominio;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Curiosidade {
    public int id;
    public String descricao;
    public CategoriasCuriosidade categoria;

    public Curiosidade(String descricao, CategoriasCuriosidade categoria) {
        this.descricao = descricao;
        this.categoria = categoria;
    }


    @Override
    public String toString() {
        return "Curiosidade{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
