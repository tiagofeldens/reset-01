package br.com.cwi.tinderevolution.gerenciador;

import br.com.cwi.tinderevolution.Banco.FilmeBanco;
import br.com.cwi.tinderevolution.dominio.Filme;

import java.time.LocalDate;
import java.util.List;

public class FilmeGerenciador {

    public FilmeBanco banco = new FilmeBanco();

    public Filme salvar(Filme filme) {
        List<Filme> filmes = banco.listar();

        if (filme.nome.isEmpty() || filme.autor.isEmpty() || filme.categoria == null || filme.dataLancamento == null || filme.sinopse.isEmpty()) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        }

        for (Filme filmeExistente : filmes) {
            if (filme.nome.equals(filmeExistente.nome)) {
                return filmeExistente;
            }
        }
        if (filme.dataLancamento.isAfter(LocalDate.now())) {
            return null;
        }

        return banco.salvar(filme);
    }

    public List<Filme> listar() {
        return banco.listar();
    }

    public Filme procurar(int id) {
        if (id > 0) {
            return banco.procurar(id);
        }
        return null;
    }

    public Filme editar(int id, Filme filmeAtualizado) {
        List<Filme> filmes = banco.listar();
        Filme filmeExistente = procurar(id);
        if (filmeExistente == null) {
            return null;
        }

        if (filmeAtualizado.nome.isEmpty() || filmeAtualizado.autor.isEmpty() || filmeAtualizado.categoria == null || filmeAtualizado.dataLancamento == null || filmeAtualizado.sinopse.isEmpty()) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        } else {
            for (Filme filme : filmes) {
                if (filmeAtualizado.nome.equals(filme.nome) && filmeAtualizado.id != filme.id) {
                    return filmeExistente;
                }
            }
            return banco.editar(filmeExistente, filmeAtualizado);

        }
    }

    public boolean deletar(int id) {
        if (id > 0) {
            return banco.deletar(id);
        }
        return false;
    }
}
