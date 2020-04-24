package br.com.cwi.tinderevolution.Banco;

import br.com.cwi.tinderevolution.dominio.Curiosidade;

import java.util.ArrayList;
import java.util.List;

public class CuriosidadeBanco {

    int contador = 1;
    final List<Curiosidade> curiosidades = new ArrayList<>();

    public Curiosidade salvar(Curiosidade curiosidade) {
        curiosidade.setId(contador++);
        curiosidades.add(curiosidade);
        return curiosidade;
    }

    public Curiosidade editar(Curiosidade curiosidadeExistente, Curiosidade curiosidadeEditada) {
        curiosidadeExistente.setDescricao(curiosidadeEditada.getDescricao());
        curiosidadeExistente.setCategoria(curiosidadeEditada.getCategoria());
        return curiosidadeExistente;
    }

    public List<Curiosidade> listar() {
        return curiosidades;
    }

    public Curiosidade procurar(int id) {
        for (Curiosidade curiosidade : curiosidades) {
            if (curiosidade.getId() == id) {
                return curiosidade;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Curiosidade curiosidadeParaDeletar = procurar(id);
        if (curiosidadeParaDeletar != null) {
            return curiosidades.remove(curiosidadeParaDeletar);
        }
        return false;


    }
}
