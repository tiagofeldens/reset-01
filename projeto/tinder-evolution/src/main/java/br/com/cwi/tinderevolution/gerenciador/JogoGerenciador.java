package br.com.cwi.tinderevolution.gerenciador;

import br.com.cwi.tinderevolution.Banco.FilmeBanco;
import br.com.cwi.tinderevolution.Banco.JogoBanco;
import br.com.cwi.tinderevolution.dominio.Filme;
import br.com.cwi.tinderevolution.dominio.Jogo;

import java.time.LocalDate;
import java.util.List;

public class JogoGerenciador {


    public JogoBanco banco = new JogoBanco();

    public Jogo salvar(Jogo jogo) {
        List<Jogo> jogos = banco.listar();

        if (jogo.getNome().isEmpty() || jogo.getCategoria() == null || jogo.getDataLancamento() == null || jogo.getPlataforma() == null) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        }

        for (Jogo jogoExistente : jogos) {
            if (jogo.getNome().equals(jogoExistente.getNome()) && jogo.getPlataforma().equals(jogoExistente.getPlataforma())) {
                return jogoExistente;
            }
        }
        if (jogo.getDataLancamento().isAfter(LocalDate.now())) {
            return null;
        }

        return banco.salvar(jogo);
    }

    public List<Jogo> listar() {
        return banco.listar();
    }

    public Jogo procurar(int id) {
        if (id > 0) {
            return banco.procurar(id);
        }
        return null;
    }

    public Jogo editar(int id, Jogo jogoAtualizado) {
        List<Jogo> jogos = banco.listar();
        Jogo jogoExistente = procurar(id);
        if (jogoExistente == null) {
            return null;
        }

        if (jogoAtualizado.getNome().isEmpty() || jogoAtualizado.getPublisher().isEmpty() || jogoAtualizado.getCategoria() == null || jogoAtualizado.getDataLancamento() == null || jogoAtualizado.getPlataforma() == null) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        } else {
            for (Jogo jogo : jogos) {
                if (jogoAtualizado.getNome().equals(jogo.getNome()) && jogoAtualizado.getPlataforma().equals(jogo.getPlataforma()) && jogoAtualizado.getId() != jogo.getId()) {
                    return jogoExistente;
                }
            }
            return banco.editar(jogoExistente, jogoAtualizado);

        }
    }

    public boolean deletar(int id) {
        if (id > 0) {
            return banco.deletar(id);
        }
        return false;
    }
}
