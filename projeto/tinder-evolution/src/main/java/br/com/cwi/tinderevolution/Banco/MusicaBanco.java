package br.com.cwi.tinderevolution.Banco;

import br.com.cwi.tinderevolution.dominio.Musica;

import java.util.ArrayList;
import java.util.List;

public class MusicaBanco {

    int contador = 1;
    final List<Musica> musicas = new ArrayList<>();

    public Musica salvar(Musica musica) {
        musica.setId(contador++);
        musicas.add(musica);
        return musica;
    }

    public Musica editar(Musica musicaExistente, Musica musicaEditada) {
        musicaExistente.setNome(musicaEditada.getNome());
        musicaExistente.setAutor(musicaEditada.getAutor());
        musicaExistente.setDataLancamento(musicaEditada.getDataLancamento());
        musicaExistente.setEstilo(musicaEditada.getEstilo());
        return musicaExistente;
    }

    public List<Musica> listar() {
        return musicas;
    }

    public Musica procurar(int id) {
        for (Musica musica : musicas) {
            if (musica.getId() == id) {
                return musica;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Musica musicaParaDeletar = procurar(id);
        if (musicaParaDeletar != null) {
            return musicas.remove(musicaParaDeletar);
        }
        return false;


    }
}
