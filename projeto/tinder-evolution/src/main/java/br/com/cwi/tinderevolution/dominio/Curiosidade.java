package br.com.cwi.tinderevolution.dominio;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Curiosidade {
    private int id;
    private String descricao;
    private CategoriasCuriosidade categoria;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriasCuriosidade getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasCuriosidade categoria) {
        this.categoria = categoria;
    }
}
