package br.com.cwi.tinderevolution.Banco;

import br.com.cwi.tinderevolution.dominio.Jogo;

import java.util.ArrayList;
import java.util.List;

public class JogoBanco {

    int contador = 1;
    final List<Jogo> jogos  = new ArrayList<>();

    public Jogo salvar(Jogo jogo) {
        jogo.id = contador++;
        jogos.add(jogo);
        return jogo;
    }

    public Jogo editar(Jogo jogoExistente, Jogo jogoEditado) {
        jogoExistente.nome = jogoEditado.nome;
        jogoExistente.publisher = jogoEditado.publisher;
        jogoExistente.dataLancamento = jogoEditado.dataLancamento;
        jogoExistente.categoria = jogoEditado.categoria;
        jogoExistente.plataforma = jogoEditado.plataforma;
        return jogoExistente;
    }

    public List<Jogo> listar() {
        return jogos;
    }

    public Jogo procurar(int id) {
        for (Jogo jogo : jogos) {
            if (jogo.id == id) {
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
