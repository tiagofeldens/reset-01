package br.com.cwi.tinderevolution.Banco;

import br.com.cwi.tinderevolution.dominio.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeBanco {

    int contador = 1;
    final List<Filme> filmes = new ArrayList<>();

    public Filme salvar(Filme filme) {
        filme.id = contador++;
        filmes.add(filme);
        return filme;
    }

    public Filme editar(Filme filmeExistente, Filme filmeEditado) {
        filmeExistente.nome = filmeEditado.nome;
        filmeExistente.autor = filmeEditado.autor;
        filmeExistente.dataLancamento = filmeEditado.dataLancamento;
        filmeExistente.categoria = filmeEditado.categoria;
        filmeExistente.sinopse = filmeEditado.sinopse;
        return filmeExistente;
    }

    public List<Filme> listar() {
        return filmes;
    }

    public Filme procurar(int id) {
        for (Filme filme : filmes) {
            if (filme.id == id) {
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
