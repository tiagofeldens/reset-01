package br.com.cwi.tinderevolution.Banco;

import br.com.cwi.tinderevolution.dominio.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeBanco {

    int contador = 1;
    final List<Filme> filmes = new ArrayList<>();

    public Filme salvar(Filme filme) {
        filme.setId(contador++);
        filmes.add(filme);
        return filme;
    }

    public Filme editar(Filme filmeExistente, Filme filmeEditado) {
        filmeExistente.setNome(filmeEditado.getNome());
        filmeExistente.setAutor(filmeEditado.getAutor());
        filmeExistente.setDataLancamento(filmeEditado.getDataLancamento());
        filmeExistente.setCategoria(filmeEditado.getCategoria());
        filmeExistente.setSinopse(filmeEditado.getSinopse());
        return filmeExistente;
    }

    public List<Filme> listar() {
        return filmes;
    }

    public Filme procurar(int id) {
        for (Filme filme : filmes) {
            if (filme.getId() == id) {
                return filme;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Filme filmeParaDeletar = procurar(id);
        if (filmeParaDeletar != null) {
            return filmes.remove(filmeParaDeletar);
        }
        return false;


    }
}
