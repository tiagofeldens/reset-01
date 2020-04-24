package br.com.cwi.tinderevolution.Banco;

import br.com.cwi.tinderevolution.dominio.Jogo;

import java.util.ArrayList;
import java.util.List;

public class JogoBanco {

    int contador = 1;
    final List<Jogo> jogos  = new ArrayList<>();

    public Jogo salvar(Jogo jogo) {
        jogo.setId(contador++);
        jogos.add(jogo);
        return jogo;
    }

    public Jogo editar(Jogo jogoExistente, Jogo jogoEditado) {
        jogoExistente.setNome(jogoEditado.getNome());
        jogoExistente.setPublisher(jogoEditado.getPublisher());
        jogoExistente.setDataLancamento(jogoEditado.getDataLancamento());
        jogoExistente.setCategoria(jogoEditado.getCategoria());
        jogoExistente.setPlataforma(jogoEditado.getPlataforma());
        return jogoExistente;
    }

    public List<Jogo> listar() {
        return jogos;
    }

    public Jogo procurar(int id) {
        for (Jogo jogo : jogos) {
            if (jogo.getId() == id) {
                return jogo;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Jogo jogoParaDeletar = procurar(id);
        if (jogoParaDeletar != null) {
            return jogos.remove(jogoParaDeletar);
        }
        return false;


    }
}
