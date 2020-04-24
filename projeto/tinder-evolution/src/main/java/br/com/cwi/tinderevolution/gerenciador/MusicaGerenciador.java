package br.com.cwi.tinderevolution.gerenciador;

import br.com.cwi.tinderevolution.Banco.MusicaBanco;
import br.com.cwi.tinderevolution.dominio.Musica;

import java.time.LocalDate;
import java.util.List;

public class MusicaGerenciador {

    public MusicaBanco banco = new MusicaBanco();

    public Musica salvar(Musica musica) {
        List<Musica> musicas = banco.listar();

        if (musica.getNome().isEmpty() || musica.getAutor().isEmpty() || musica.getEstilo() == null || musica.getDataLancamento() == null) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        }

        for (Musica musicaExistente : musicas) {
            if (musica.getNome().equals(musicaExistente.getNome())) {
                return musicaExistente;
            }
        }
        if (musica.getDataLancamento().isAfter(LocalDate.now())) {
            return null;
        }

        return banco.salvar(musica);
    }

    public List<Musica> listar() {
        return banco.listar();
    }

    public Musica procurar(int id) {
        if (id > 0) {
            return banco.procurar(id);
        }
        return null;
    }

    public Musica editar(int id, Musica musicaAtualizada) {
        List<Musica> musicas = banco.listar();
        Musica musicaExistente = procurar(id);
        if (musicaExistente == null) {
            return null;
        }

        if (musicaAtualizada.getNome().isEmpty() || musicaAtualizada.getAutor().isEmpty() || musicaAtualizada.getEstilo() == null || musicaAtualizada.getDataLancamento() == null) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        } else {
            for (Musica musica : musicas) {
                if (musicaAtualizada.getNome().equals(musica.getNome()) && musicaAtualizada.getId() != musica.getId()) {
                    return musicaExistente;
                }
            }
            return banco.editar(musicaExistente, musicaAtualizada);

        }
    }

    public boolean deletar(int id) {
        if (id > 0) {
            return banco.deletar(id);
        }
        return false;
    }

}


