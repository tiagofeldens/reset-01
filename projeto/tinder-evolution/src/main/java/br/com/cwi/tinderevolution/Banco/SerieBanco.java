package br.com.cwi.tinderevolution.Banco;

import br.com.cwi.tinderevolution.dominio.Serie;

import java.util.ArrayList;
import java.util.List;

public class SerieBanco {

    int contador = 1;
    final List<Serie> series = new ArrayList<>();

    public Serie salvar(Serie serie) {
        serie.id = contador++;
        series.add(serie);
        return serie;
    }

    public Serie editar(Serie serieExistente, Serie serieEditada) {
        serieExistente.nome = serieEditada.nome;
        serieExistente.diretor = serieEditada.diretor;
        serieExistente.dataLancamento = serieEditada.dataLancamento;
        serieExistente.categoria = serieEditada.categoria;
        return serieExistente;
    }

    public List<Serie> listar() {
        return series;
    }

    public Serie procurar(int id) {
        for (Serie serie : series) {
            if (serie.id == id) {
                return serie;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Serie serieParaDeletar = procurar(id);
        if (serieParaDeletar != null) {
            return series.remove(serieParaDeletar);
        }
        return false;


    }
}
