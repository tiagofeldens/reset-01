package br.com.cwi.tinderevolution.Banco;

import br.com.cwi.tinderevolution.dominio.Curiosidade;

import java.util.ArrayList;
import java.util.List;

public class CuriosidadeBanco {

    int contador = 1;
    final List<Curiosidade> curiosidades = new ArrayList<>();

    public Curiosidade salvar(Curiosidade curiosidade) {
        curiosidade.id = contador++;
        curiosidades.add(curiosidade);
        return curiosidade;
    }

    public Curiosidade editar(Curiosidade curiosidadeExistente, Curiosidade curiosidadeEditada) {
        curiosidadeExistente.descricao = curiosidadeEditada.descricao;
        curiosidadeExistente.categoria = curiosidadeEditada.categoria;
        return curiosidadeExistente;
    }

    public List<Curiosidade> listar() {
        return curiosidades;
    }

    public Curiosidade procurar(int id) {
        for (Curiosidade curiosidade : curiosidades) {
            if (curiosidade.id == id) {
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
