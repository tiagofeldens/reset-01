package br.com.cwi.tinderevolution.gerenciador;

import br.com.cwi.tinderevolution.Banco.SerieBanco;
import br.com.cwi.tinderevolution.dominio.Serie;

import java.time.LocalDate;
import java.util.List;

public class SerieGerenciador {


    public SerieBanco banco = new SerieBanco();

    public Serie salvar(Serie serie) {
        List<Serie> series = banco.listar();

        if (serie.getNome().isEmpty() || serie.getDiretor().isEmpty()|| serie.getNumeroDeEpisodios() == 0 || serie.getNumeroDeTemporadas() == 0 || serie.getDataLancamento() == null || serie.getCategoria() == null || serie.getSinopse().isEmpty()) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        }

        for (Serie serieExistente : series) {
            if (serie.getNome().equals(serieExistente.getNome())) {
                return serieExistente;
            }
        }
        if (serie.getDataLancamento().isAfter(LocalDate.now())) {
            return null;
        }

        return banco.salvar(serie);
    }

    public List<Serie> listar() {
        return banco.listar();
    }

    public Serie procurar(int id) {
        if (id > 0) {
            return banco.procurar(id);
        }
        return null;
    }

    public Serie editar(int id, Serie serieAtualizada) {
        List<Serie> series = banco.listar();
        Serie serieExistente = procurar(id);
        if (serieExistente == null) {
            return null;
        }

        if (serieAtualizada.getNome().isEmpty() || serieAtualizada.getDiretor().isEmpty()|| serieAtualizada.getNumeroDeEpisodios() == 0 || serieAtualizada.getNumeroDeTemporadas() == 0 || serieAtualizada.getDataLancamento() == null || serieAtualizada.getCategoria() == null || serieAtualizada.getSinopse().isEmpty()) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        } else {
            for (Serie filme : series) {
                if (serieAtualizada.getNome().equals(filme.getNome()) && serieAtualizada.getId() != filme.getId()) {
                    return serieExistente;
                }
            }
            return banco.editar(serieExistente, serieAtualizada);

        }
    }

    public boolean deletar(int id) {
        if (id > 0) {
            return banco.deletar(id);
        }
        return false;
    }
}
