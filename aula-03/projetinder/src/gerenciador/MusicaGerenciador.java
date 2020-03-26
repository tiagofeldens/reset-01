package gerenciador;

import Banco.MusicaBanco;
import dominio.Musica;

import java.time.LocalDate;
import java.util.List;

public class MusicaGerenciador {

    private MusicaBanco banco = new MusicaBanco();

    public Musica salvar (Musica musica){
        List<Musica> musicas = banco.listar();

        for (Musica musicaExistente : musicas){
            if (musica.nome.equals(musicaExistente.nome)){
                return musicaExistente;

            }
        }
        if (musica.dataLancamento.isAfter(LocalDate.now())) {
            return null;
        }

        return banco.salvar(musica);
    }

    public List<Musica> listar () {
        return banco.listar();
    }

    public Musica procurar (int id){
        if (id>0) {
            return banco.procurar(id);
        }
        return null;
        }

    public Musica editar (int id, Musica musicaAtualizada){
        Musica musicaExistente = procurar(id);
        if (musicaExistente == null) {
            return null;
        }
        else {
            return banco.editar(musicaAtualizada, musicaAtualizada);
        }
        }

    public boolean deletar(int id) {
        if (id > 0) {
            return banco.deletar(id);
        }
        return false;
    }

    }


