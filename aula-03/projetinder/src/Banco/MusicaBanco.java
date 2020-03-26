package Banco;

import dominio.Musica;

import java.util.ArrayList;
import java.util.List;

public class MusicaBanco {

    int contador = 1;
    final List<Musica> musicas = new ArrayList<>();

    public Musica salvar(Musica musica) {
        musica.id = contador++;
        musicas.add(musica);
        return musica;
    }

    public Musica editar(Musica musicaExistente, Musica musicaEditada) {
        musicaExistente.nome = musicaEditada.nome;
        musicaExistente.autor = musicaEditada.autor;
        musicaExistente.dataLancamento = musicaEditada.dataLancamento;
        musicaExistente.estilo = musicaExistente.estilo;
        return musicaExistente;
    }

    public List<Musica> listar() {
        return musicas;
    }

    public Musica procurar(int id) {
        for (Musica musica : musicas) {
            if (musica.id == id) {
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
