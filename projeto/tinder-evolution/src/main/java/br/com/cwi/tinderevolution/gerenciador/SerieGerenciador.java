package br.com.cwi.tinderevolution.gerenciador;

import br.com.cwi.tinderevolution.Banco.SerieBanco;
import br.com.cwi.tinderevolution.dominio.Serie;

import java.time.LocalDate;
import java.util.List;

public class SerieGerenciador {


    public SerieBanco banco = new SerieBanco();

    public Serie salvar(Serie serie) {
        List<Serie> series = banco.listar();

        if (serie.nome.isEmpty() || serie.diretor.isEmpty()|| serie.numeroDeEpisodios == 0 || serie.numeroDeTemporadas == 0 || serie.dataLancamento == null || serie.categoria == null || serie.sinopse.isEmpty()) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        }

        for (Serie serieExistente : series) {
            if (serie.nome.equals(serieExistente.nome)) {
                return serieExistente;
            }
        }
        if (serie.dataLancamento.isAfter(LocalDate.now())) {
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

        if (serieAtualizada.nome.isEmpty() || serieAtualizada.diretor.isEmpty()|| serieAtualizada.numeroDeEpisodios == 0 || serieAtualizada.numeroDeTemporadas == 0 || serieAtualizada.dataLancamento == null || serieAtualizada.categoria == null || serieAtualizada.sinopse.isEmpty()) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        } else {
            for (Serie filme : series) {
                if (serieAtualizada.nome.equals(filme.nome) && serieAtualizada.id != filme.id) {
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
